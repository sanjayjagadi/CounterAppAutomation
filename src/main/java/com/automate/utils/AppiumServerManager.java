package com.automate.utils;

import com.automate.enums.ConfigProperties;
import com.automate.utils.configloader.PropertyUtils;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

public final class AppiumServerManager {

  private static AppiumDriverLocalService service;

  static boolean checkIfServerIsRunning(int port) {
    boolean isServerRunning = false;
    try (ServerSocket serverSocket = new ServerSocket(port)) {
      // Port is free, server not running
    } catch (IOException e) {
      // If binding fails, assume server is running
      isServerRunning = true;
    }
    return isServerRunning;
  }

  public static void startAppiumServer() {
    String nodeJsPath = "C:\\Program Files\\nodejs\\node.exe";
    String appiumPath = "C:\\Users\\sanja\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"; // Adjust path if needed
    String logFilePath = System.getProperty("user.dir") + "/logs/appium_server.log";

    System.out.println("Node.js Path: " + nodeJsPath);
    System.out.println("Appium.js Path: " + appiumPath);
    System.out.println("Log File Path: " + logFilePath);

    if (PropertyUtils.getPropertyValue(ConfigProperties.START_APPIUM_SERVER).equalsIgnoreCase("yes")) {
      if (!checkIfServerIsRunning(4723)) {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
          .usingDriverExecutable(new File(nodeJsPath))
          .withAppiumJS(new File(appiumPath))
          .withIPAddress("127.0.0.1")
          .usingPort(4723)
          .withArgument(GeneralServerFlag.BASEPATH,"/wd/hub/")
          .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
          .withArgument(GeneralServerFlag.ALLOW_INSECURE, "chromedriver_autodownload")
          .withLogFile(new File(logFilePath));
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        service.clearOutPutStreams();
      }
    }
  }

  public static void stopAppiumServer() {
    if (PropertyUtils.getPropertyValue(ConfigProperties.START_APPIUM_SERVER).equalsIgnoreCase("yes")) {
      if (service != null) {
        service.stop();
      }
      try {
        Runtime.getRuntime().exec("pkill -f node");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
