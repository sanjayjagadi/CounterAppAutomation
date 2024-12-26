package com.automate.driver;

import com.automate.constants.FrameworkConstants;
import com.automate.customexceptions.DriverInitializationException;
import com.automate.enums.ConfigJson;
import com.automate.enums.MobileBrowserName;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

import static com.automate.utils.configloader.JsonUtils.getConfig;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Drivers {

//  public static AppiumDriver<MobileElement> createAndroidDriverForNativeApp(String deviceName, String udid, int port, String emulator) {
//    try {
//      var capability = new DesiredCapabilities();
//      capability.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
//      capability.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
//      capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2); // Specific to Android
//      capability.setCapability(MobileCapabilityType.UDID, udid); // To uniquely identify device
//      capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getConfig(ConfigJson.APP_PACKAGE));
//      capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getConfig(ConfigJson.APP_ACTIVITY));
//      capability.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, port); // To set different port for each thread
//      capability.setCapability(MobileCapabilityType.NO_RESET, true);
//      capability.setCapability(MobileCapabilityType.FULL_RESET, false);
//
//
//      if (emulator.equalsIgnoreCase("yes")) {
//        capability.setCapability(AndroidMobileCapabilityType.AVD, deviceName);
//        capability.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT,
//                                 Integer.parseInt(getConfig(ConfigJson.AVD_LAUNCH_TIMEOUT)));
//      }
//
//      System.out.println("Creating Android Driver with the following capabilities:");
//      System.out.println("Platform: " + Platform.ANDROID);
//      System.out.println("Device Name: " + deviceName);
//      System.out.println("UDID: " + udid);
//      System.out.println("App Package: " + getConfig(ConfigJson.APP_PACKAGE));
//      System.out.println("App Activity: " + getConfig(ConfigJson.APP_ACTIVITY));
//      System.out.println("System Port: " + port);
//      System.out.println("AVD Emulator: " + emulator);
//
//      return new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capability);
//    } catch (Exception e) {
//      throw new DriverInitializationException("Failed to initialize driver. Please check the desired capabilities", e);
//    }
//  }


  public static AppiumDriver<MobileElement> createAndroidDriverForNativeApp(String deviceName, String udid, int port, String emulator) {
    try {
      var capability = new DesiredCapabilities();
      capability.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
      capability.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
      capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2); // Specific to Android
      capability.setCapability(MobileCapabilityType.UDID, udid); // To uniquely identify device
      capability.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "app" + File.separator + "app-release.apk");
      // Set app to null explicitly

      // Optionally set the app package and activity if you want to launch an already installed app
      capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.testapp");
      capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.testapp.MainActivity");

      capability.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, port); // To set different port for each thread
      capability.setCapability(MobileCapabilityType.NO_RESET, true);  // Ensure no reset (app not uninstalled)
      capability.setCapability(MobileCapabilityType.FULL_RESET, false); // Ensure no full reset (app not uninstalled)
      capability.setCapability("skipDeviceInitialization", true);
      if (emulator.equalsIgnoreCase("yes")) {
        capability.setCapability(AndroidMobileCapabilityType.AVD, deviceName);
        capability.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT,
                                 Integer.parseInt(getConfig(ConfigJson.AVD_LAUNCH_TIMEOUT)));
      }

      capability.setCapability("avdLaunchTimeout", 300000); // For emulator
      capability.setCapability("disableWindowAnimation", false); // Keep animations enabled

      System.out.println("Creating Android Driver with the following capabilities:");
      System.out.println("Platform: " + Platform.ANDROID);
      System.out.println("Device Name: " + deviceName);
      System.out.println("UDID: " + udid);
      System.out.println("System Port: " + port);
      System.out.println("AVD Emulator: " + emulator);

      return new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capability);
    } catch (Exception e) {
      throw new DriverInitializationException("Failed to initialize driver. Please check the desired capabilities", e);
    }
  }



  public static AppiumDriver<MobileElement> createAndroidDriverForWeb(String deviceName, String udid, int port, String emulator) {
    try {
      var capability = new DesiredCapabilities();
      capability.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
      capability.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
      capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
      capability.setCapability(MobileCapabilityType.UDID, udid);
      capability.setCapability(CapabilityType.BROWSER_NAME, MobileBrowserName.CHROME);
      capability.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_PORT,
                               port); // For Web view/Chrome browser to launch the browser on different port
      if (emulator.equalsIgnoreCase("yes")) {
        capability.setCapability(AndroidMobileCapabilityType.AVD, deviceName);
        capability.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT,
                                 Integer.parseInt(getConfig(ConfigJson.AVD_LAUNCH_TIMEOUT)));
      }

      return new AndroidDriver<>(new URL(getConfig(ConfigJson.APPIUM_URL)), capability);
    } catch (Exception e) {
      throw new DriverInitializationException("Failed to initialize driver. Please check the desired capabilities", e);
    }
  }

  public static AppiumDriver<MobileElement> createIOSDriverForNativeApp(String deviceName, String udid, int port) {
    try {
      var capability = new DesiredCapabilities();
      capability.setCapability(CapabilityType.PLATFORM_NAME, Platform.IOS);
      capability.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
      capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
      capability.setCapability(MobileCapabilityType.UDID, udid);
      capability.setCapability(MobileCapabilityType.APP, FrameworkConstants.IOS_APP_PATH);
      capability.setCapability(IOSMobileCapabilityType.BUNDLE_ID, getConfig(ConfigJson.BUNDLE_ID));
      capability.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT,
                               port); // To set different port for each thread - This port is used to communicate with WebDriverAgent driver

      return new IOSDriver<>(new URL(getConfig(ConfigJson.APPIUM_URL)), capability);
    } catch (Exception e) {
      throw new DriverInitializationException("Failed to initialize driver. Please check the desired capabilities", e);
    }
  }

  public static AppiumDriver<MobileElement> createIOSDriverForWeb(String deviceName, String udid, int port) {
    try {
      var capability = new DesiredCapabilities();
      capability.setCapability(CapabilityType.PLATFORM_NAME, Platform.IOS);
      capability.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
      capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
      capability.setCapability(MobileCapabilityType.UDID, udid);
      capability.setCapability(IOSMobileCapabilityType.BUNDLE_ID, getConfig(ConfigJson.BUNDLE_ID));
      capability.setCapability(CapabilityType.BROWSER_NAME, MobileBrowserName.SAFARI);
      capability.setCapability("webkitDebugProxyPort", port); // For web view/Safari browser testing on real device

      return new IOSDriver<>(new URL(getConfig(ConfigJson.APPIUM_URL)), capability);
    } catch (Exception e) {
      throw new DriverInitializationException("Failed to initialize driver. Please check the desired capabilities", e);
    }
  }
}