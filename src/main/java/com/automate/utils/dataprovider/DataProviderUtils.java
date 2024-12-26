package com.automate.utils.dataprovider;

import com.automate.constants.FrameworkConstants;
import com.automate.entity.AppTestData;
import com.automate.entity.TestData;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataProviderUtils {

  private static List<Map<String, String>> list = new ArrayList<>();

  @DataProvider
  public static Object[][] getData(Method method) {
    AppTestData AppTestData = null;
    TestData testData = null;
    String testName = method.getName();

    if (list.isEmpty())
      list = ExcelUtils.getTestDetails(FrameworkConstants.TEST_DATA_SHEET);

    List<Map<String, String>> smallList = new ArrayList<>(list);

    Predicate<Map<String, String>> isTestNameNotMatching = map -> !map.get("TestCaseName").equalsIgnoreCase(testName);

    smallList.removeIf(isTestNameNotMatching);

    for (Map<String, String> mapData : smallList) {

      AppTestData = AppTestData.builder()
        .setActual(mapData.get("actual"))
        .setExpected(mapData.get("expected"))
        .build();


      testData = TestData.builder()
        .setAppTestData(AppTestData)
        .build();
    }
    return new Object[][] {
      {testData}
    };
  }
}

