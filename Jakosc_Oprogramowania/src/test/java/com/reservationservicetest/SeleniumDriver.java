package com.reservationservicetest;

import org.openqa.selenium.WebDriver;

public class SeleniumDriver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        SeleniumDriver.driver = driver;
    }


}
