package com.shidqiadiatma.factories;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author Shidqi Adiatma a.k.a. hipstertester on 23/12/23
 * @project sauce-labs-mobile-selenium-cucumber
 */

public class driverManager {

    private static final driverManager instance = new driverManager();

    ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    private driverManager() {
    }

    public static driverManager getInstance() {
        return instance;
    }

    public AndroidDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AndroidDriver androidDriver) {
        driver.set(androidDriver);
    }

    public void removeDriver() {
        driver.remove();
    }
}
