package com.reservationservicetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class SeleniumManager {

    public static void initWebDriver(){
        System.setProperty("webdriver.opera.driver", "/Users/zashiwaki/Downloads/operadriver_mac64/operadriver");
        WebDriver driver = new OperaDriver();
        SeleniumDriver.setDriver(driver);
    }

    public static void shutdownDriver(){
        SeleniumDriver.getDriver().quit();
    }

}
