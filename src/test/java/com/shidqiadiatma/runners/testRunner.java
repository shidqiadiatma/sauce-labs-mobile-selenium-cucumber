package com.shidqiadiatma.runners;

import com.shidqiadiatma.factories.driverManager;
import com.shidqiadiatma.factories.mobileFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;

@CucumberOptions(features = "src/test/java/com/shidqiadiatma/features",
        glue = "com.shidqiadiatma.steps",
        tags = "@sorting",
        plugin = {
                "pretty",
                "html:reports/cucumber-result/cucumber-reports.html",
                "json:reports/cucumber-result/cucumber-reports.json"
        }, monochrome = true)

public class testRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeMethod(alwaysRun = true)
    public void setupDriver() throws MalformedURLException {
        driverManager.getInstance().setDriver(
                new mobileFactory().launchMobile("Emulator Android"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        driverManager.getInstance().removeDriver();
    }
}
