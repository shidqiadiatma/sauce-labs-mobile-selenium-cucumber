package com.shidqiadiatma.factories;

import io.appium.java_client.android.AndroidDriver;

public class driverManager {

    // implements design pattern singleton and thread local
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
