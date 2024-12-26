package com.automate.pages;

import com.automate.driver.manager.DriverManager;
import com.automate.pages.screen.ScreenActions;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import static org.testng.AssertJUnit.assertEquals;
public final class HomePage extends ScreenActions {


  public static String defaultValue = "//android.view.View[@content-desc='0']";
  public static String incrementValue = "//android.widget.Button[@content-desc='+1']";
  public static String decrementValue = "//android.widget.Button[@content-desc='-2']";
  public static String resetButton = "//android.widget.Button[@content-desc='Reset']";
  public static String pickADate = "//android.widget.Button[@content-desc='Pick a Date']";
  public static String okButtonCalender = "//android.widget.Button[@content-desc='OK']";
  public static String cancelButtonCalender = "//android.widget.Button[@content-desc='Cancel']";
  public static String dateSelected = "(//android.view.View[@content-desc='Selected'])[1]";
  public static String dateSelectedSnackBar = "(//android.view.View[@content-desc='Selected'])[2]";

    ;

  public String getNextDayXPath() {
    // Calculate the next day
    LocalDate currentDate = LocalDate.now();
    LocalDate nextDay = currentDate.plusDays(1); // +1 day

    // Format the date as required (e.g., "10, Tuesday, December 10, 2024")
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE, MMMM d, yyyy", Locale.ENGLISH);
    String formattedDate = nextDay.format(formatter);

    // Create the dynamic XPath based on the formatted date
    return "//android.widget.Button[@content-desc='" + formattedDate + "']";
  }

  public static String getValueInBox(String value) {
    return "//android.view.View[@content-desc='" + value + "']";
  }

  public String validateInitialValue() {
    // Ensure the driver is initialized
    if (DriverManager.getDriver() == null) {
      System.out.println("Driver not initialized!");
      Assert.fail("Driver is not initialized.");
    }

    // Wait for the element to be visible
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10); // 10 seconds wait
    MobileElement counterValue = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(defaultValue)));

    // Get and print the content-desc attribute
    return counterValue.getAttribute("content-desc");
  }

  public String validateIncrementValue(String value) {
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10); // 10 seconds wait
    MobileElement incrementButton = (MobileElement) wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath(incrementValue))
    );

    // Click the increment button
    incrementButton.click();

    // Wait for the counter value to be updated and visible
    MobileElement setValue = (MobileElement) wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath(getValueInBox(value)))
    );

    // Return the updated counter value
    return setValue.getAttribute("content-desc");
  }

  public String validateDecrementValue(String value) {
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10); // 10 seconds wait
    MobileElement decrementButton = (MobileElement) wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath(decrementValue))
    );

    // Click the increment button
    decrementButton.click();

    // Wait for the counter value to be updated and visible
    MobileElement setValue = (MobileElement) wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath(getValueInBox(value)))
    );

    // Return the updated counter value
    return setValue.getAttribute("content-desc");
  }

  public String validateResetButtonFunctionality() {
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10); // 10 seconds wait
    MobileElement reset_button = (MobileElement) wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath(resetButton))
    );

    // Click the increment button
    reset_button.click();

    // Wait for the counter value to be updated and visible
    MobileElement resetValue = (MobileElement) wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath(defaultValue))
    );

    // Return the updated counter value
    return resetValue.getAttribute("content-desc");
  }

  public String validateCalenderFunctionalityWithOKButton() {
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10); // 10 seconds wait
    MobileElement incrementButton = (MobileElement) wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath(pickADate))
    );

    // Click the increment button
    incrementButton.click();

    // Wait for the counter value to be updated and visible
    MobileElement pickADate = (MobileElement) wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath(getNextDayXPath()))
    );
    pickADate.click();


    MobileElement okButton = (MobileElement) wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath(okButtonCalender))
    );
    okButton.click();

    MobileElement selectedText = (MobileElement) wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath(dateSelected))
    );

    assertEquals("Selected", selectedText.getAttribute("content-desc"));

    MobileElement selectedTextInSnackBar = (MobileElement) wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath(dateSelectedSnackBar))
    );

    assertEquals("Selected", selectedTextInSnackBar.getAttribute("content-desc"));


    MobileElement getValue = (MobileElement) wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath(defaultValue))
    );

    // Return the updated counter value
    return getValue.getAttribute("content-desc");
  }

  public String validateCalenderFunctionalityWithCancelButton() {
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10); // 10 seconds wait
    MobileElement incrementButton = (MobileElement) wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath(pickADate))
    );

    // Click the increment button
    incrementButton.click();

    // Wait for the counter value to be updated and visible
    MobileElement pickADate = (MobileElement) wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath(getNextDayXPath()))
    );
    pickADate.click();


    MobileElement okButton = (MobileElement) wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath(cancelButtonCalender))
    );
    okButton.click();

    MobileElement getValue = (MobileElement) wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath(defaultValue))
    );

    // Return the updated counter value
    return getValue.getAttribute("content-desc");
  }
}
