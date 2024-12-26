# Appium Mobile Automation Framework

Framework for Mobile test automation (Native app and Browser) on Android 




![Appium Logo](https://user-images.githubusercontent.com/48508827/136083498-e707b438-0ade-47fc-bb2b-fce34f8d04e3.png)

## Appium setup on MAC (Android):

1) Install Homebrew
2) Install [NodeJS](https://nodejs.org/en/download/)
3) Install [Java JDK18.0.2] and [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
4) Install Appium server using npm (CLI) or the Appium desktop client
5) Install [Android Studio](https://developer.android.com/studio)
6) Install [Appium Inspector](https://github.com/appium/appium-inspector/releases/)
7) Set `JAVA_HOME` and `ANDROID_HOME` environment variables

## Appium Doctor to verify the installations

1) Install appium-doctor using the command:  
`npm install -g appium-doctor`

2) To view available options:  
`appium-doctor --help`
3) to verify devices attached 
   adb devices
 4)  To check Android setup: appium-doctor --android To check iOS setup: appium-doctor --ios



##  Creating Android Virtual Device (Emulator) from Android Studio:

1) Open Android Studio.
2) Click on **Tools** -> **AVD Manager** -> **Create Virtual Device** -> Select the device and OS version -> **Finish**.
3) Once the Virtual device is created, click on **Launch this AVD in the emulator**.
4) Command to view the list of connected devices:  
`adb devices`
##  Creating Android Virtual Device (Emulator) from Android Studio:


 ##   Clone the Repository
                       

                  
                   
				step 1 - git clone https://github.com/sanjayjagadi/CounterAppAutomation.git
				step 2 - git fetch 
				step 3   git checkout master
				step 4 - mvn clean install
                step 5 - mvn test

##  Appium setup on Windows (Android):

1) Install [Java JDK18.0.2](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) and [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
2) Install [NodeJS](https://nodejs.org/en/download/)
3) Install [Android Studio](https://developer.android.com/studio)
4) Install Appium Server using npm (CLI) with the command:  
   `npm install -g appium`  
   Appium version 2.11.3 is recommended.
Command to check the installed Appium version: appium --version


5) Add the Android SDK path to your environment variables:
ANDROID_HOME = <path to Sdk folder> %ANDROID_HOME%\tools %ANDROID_HOME%\tools\bin %ANDROID_HOME%\platform-tools


6) Install [Appium Desktop](https://github.com/appium/appium-desktop/releases/)
7) Install [Appium Inspector](https://github.com/appium/appium-inspector/releases/)


## Creating Android Virtual Device (Emulator) from Android Studio:

1) Open Android Studio.
2) Click on **Tools** -> **AVD Manager** -> **Create Virtual Device** -> Select the device and OS version -> **Finish**.
3) Once the Virtual device is created, click on **Launch this AVD in the emulator**.
4) Command to view the list of connected devices:  
`adb devices`

## Running Tests on Android Emulator:

1) Navigate to the `testng_android_Emulator.xml` file.
2) Add the relevant details as follows:

```xml
<test name="Test_NativeApp-Pixel7_Emulator">
        <parameter name="emulator" value="yes"/>
        <parameter name="platformName" value="android"/>
        <parameter name="udid" value="emulator-5554"/>
        <parameter name="deviceName" value=""/>
        <parameter name="systemPort" value="5685"/>
        <parameter name="appPackage" value="com.example.testapp"/>
        <parameter name="appActivity" value="com.example.testapp.MainActivity"/>
   
   Run the tests using the command:

mvn test -DsuiteXmlFile=testng_android_Emulator.xml -X
This will initiate the test execution on the Android emulator.
