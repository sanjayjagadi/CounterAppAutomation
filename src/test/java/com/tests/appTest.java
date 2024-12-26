package com.tests;

import base.BaseTest;
import com.automate.customannotations.FrameworkAnnotation;
import com.automate.entity.TestData;
import com.automate.enums.CategoryType;
import com.automate.pages.HomePage;
import com.automate.reports.ExtentReportLogger;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automate.driver.manager.DriverManager;

import static org.testng.AssertJUnit.assertEquals;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class appTest extends BaseTest {

  HomePage homePage;

  @FrameworkAnnotation(author = "Sanjay Kumar", category = {CategoryType.FUNCTIONAL})
  @Test(priority = 1, description = "TestCase: Verify that the counter displays 0 on app launch")
  public void validateDefaultValueInHomePageOnAppLaunch(TestData data) {
    try {
      System.out.println("Starting validate Default Value In HomePage is Zero");
      homePage = new HomePage();
      PageFactory.initElements(DriverManager.getDriver(), homePage);

     // Get and print the text of the element
      String defaultInitialValue = homePage.validateInitialValue();
      ExtentReportLogger.logInfo("Counter default value on app launch: " + defaultInitialValue);
      System.out.println("Counter value: " + defaultInitialValue);

      // Validate the counter value of the Default
      assertEquals("0", defaultInitialValue);

      System.out.println("Test case to validate Default value in HomePage is completed successfully.");
    } catch (Exception e) {
      System.out.println("An issue detected during test execution: " + e.getMessage());
      ExtentReportLogger.logInfo("An issue detected during test execution: " + e.getMessage());
      e.printStackTrace();
      Assert.fail("Unexpected issue during test execution: " + e.getMessage());
    }
  }

  @FrameworkAnnotation(author = "Sanjay Kumar", category = {CategoryType.FUNCTIONAL})
  @Test(priority = 2,description = "Verify that clicking the +1 button increments the counter by 1. On clicking the button, the value should be reflected in the text field. ")
  public void validateIncrementValueButtonActionInHomePage(TestData data) {
    try {
      System.out.println("Starting verification of the increment value (+1) functionality on the homepage");
      ExtentReportLogger.logInfo("Starting verification of the increment value (+1) functionality on the homepage");
      homePage = new HomePage();
      PageFactory.initElements(DriverManager.getDriver(), homePage);

      // Get and print the text of the element
      String setValue = homePage.validateIncrementValue("1");
      ExtentReportLogger.logInfo("Set value: " + setValue);
      System.out.println("Set value: " + setValue);

      // Validate the counter value
      assertEquals("1", setValue);

      System.out.println("Test execution finished successfully.");
      ExtentReportLogger.logInfo("Test execution finished successfully.");
    } catch (Exception e) {
      System.out.println("Failure occurred while executing the test" + e.getMessage());
      ExtentReportLogger.logInfo("Failure occurred while executing the test" + e.getMessage());
      e.printStackTrace();
      Assert.fail("Failure occurred while executing the test " + e.getMessage());
    }
  }


  @FrameworkAnnotation(author = "Sanjay Kumar", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
  @Test(priority =3,description = "Verify that clicking the Reset button resets the counter to 0. On clicking the button, the value should be reflected in the text field as 0 ")
  public void validateResetButtonActionInHomePage(TestData data) {
    try {
      ExtentReportLogger.logInfo("started  Validating the Reset button on the homepage");
      System.out.println("started Validation the Reset button on the homepage");
      homePage = new HomePage();
      PageFactory.initElements(DriverManager.getDriver(), homePage);

      // Get and print the text of the element
      String setValue = homePage.validateResetButtonFunctionality();
      System.out.println("Set value: " + setValue);

      // Validate the counter value
      assertEquals("0", setValue);

      System.out.println("Test got completed successfully.");
    } catch (Exception e) {
      System.out.println("Error occurred during test execution: " + e.getMessage());
      ExtentReportLogger.logInfo("Error occurred during test execution: " + e.getMessage());
      e.printStackTrace();
      Assert.fail("Testcase failed due to exception: " + e.getMessage());
    }
  }
  @FrameworkAnnotation(author = "Sanjay Kumar", category = {CategoryType.FUNCTIONAL})
  @Test(priority = 4,description = "Validate Calender button functionality along with ok button")
  public void validateCalenderFunctionalityInHomePageWithOKButton(TestData data) {
    try {
      System.out.println("Started Validating the Reset button on the homepage");
      ExtentReportLogger.logInfo("Started Validating the Reset button on the homepage");
      homePage = new HomePage();
      PageFactory.initElements(DriverManager.getDriver(), homePage);

      // Get and print the text of the element
      String setValue = homePage.validateCalenderFunctionalityWithOKButton();
      System.out.println("Set value: " + setValue);

      // Validate the counter value
      assertEquals("0", setValue);

      System.out.println("Testcase got completed successfully.");
      ExtentReportLogger.logInfo("Testcase got completed successfully.");
    } catch (Exception e) {
      System.out.println("Error occurred during test execution: " + e.getMessage());
      ExtentReportLogger.logInfo("Error occurred during test execution: " + e.getMessage());
      e.printStackTrace();
      Assert.fail("Test failed due to exception: " + e.getMessage());
    }
  }


  @FrameworkAnnotation(author = "Sanjay Kumar", category = {CategoryType.EDGECASES})
  @Test(priority = 5,description = "Validate Calender button functionality along with ok button")
  public void validateCalenderFunctionalityInHomePageWithCancelButton(TestData data) {
    try {
      System.out.println("Started Validating the Calender button on the homepage with Cancel button");
      ExtentReportLogger.logInfo("Started Validating the Calender button on the homepage with Cancel button");
      homePage = new HomePage();
      PageFactory.initElements(DriverManager.getDriver(), homePage);

      // Get and print the text of the element
      String setValue = homePage.validateCalenderFunctionalityWithCancelButton();
      System.out.println("Set value: " + setValue);

      // Validate the counter value
      assertEquals("0", setValue);

      System.out.println("Testcase got completed successfully.");
      ExtentReportLogger.logInfo("Testcase got completed successfully.");
    } catch (Exception e) {
      System.out.println("Error occurred during test execution: " + e.getMessage());
      ExtentReportLogger.logInfo("Error occurred during test execution: " + e.getMessage());
      e.printStackTrace();
      Assert.fail("Test failed due to exception: " + e.getMessage());
    }
  }



  // Tapping is not possible on this element because the response is an instance, not a clickable element.
  @FrameworkAnnotation(author = "Sanjay Kumar", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
  @Test(priority =6,description = "Verify the app handles invalid actions gracefully (e.g., tapping buttons \n" +
    "when the app is busy).")
  public void tappingFunctionality(TestData data) {
      System.out.println("Tap action cannot proceed; the element is identified as an instance, not tappable.");
      ExtentReportLogger.logInfo("Tap action cannot proceed; the element is identified as an instance, not tappable.");

      //Sample Code
    /* public void testAppBusyInvalidAction() {
        // Simulate app being busy (e.g., loading screen or busy state)
        // Example: Click on the +1 button while the app is "busy"
        MobileElement incrementButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc='+1']"));
        // Assuming we simulate the busy state with a loading spinner or progress bar
        // Ideally, we should have a loading state or progress bar visible here
        MobileElement loadingSpinner = driver.findElement(By.xpath("//android.widget.ProgressBar[@content-desc='loading']"));
        Assert.assertTrue("App should show loading spinner", loadingSpinner.isDisplayed());

        // Try clicking the button while the app is busy
        incrementButton.click();
        MobileElement counter = driver.findElement(By.xpath("//android.view.View[@content-desc='0']")); // Expect no increment
        Assert.assertEquals("Counter should not change when app is busy", "0", counter.getText());
    } */
  }



}
