package com.shidqiadiatma.steps;

import com.shidqiadiatma.factories.driverManager;
import com.shidqiadiatma.helpers.keyword;
import com.shidqiadiatma.pages.loginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class commonStep {

    private final AndroidDriver androidDriver;

    public commonStep() {
        androidDriver = driverManager.getInstance().getDriver();
    }

    @Given("user is already on home page")
    public void userIsAlreadyOnHomePage() {
        loginPage loginPage = new loginPage(androidDriver);
        Assert.assertTrue(loginPage.verifyLayout_swaglabsLogo());
        Assert.assertTrue(loginPage.verifyLayout_swaglabsImage());
        loginPage.doLogin_autofill();
    }

    @Given("user open SwagLabs app")
    public void userOpenSwagLabsApp() {
        loginPage loginPage = new loginPage(androidDriver);
        Assert.assertTrue(loginPage.verifyLayout_swaglabsLogo());
        Assert.assertTrue(loginPage.verifyLayout_swaglabsImage());
    }

    @And("user take screenshot {string}")
    public void userTakeScreenshot(String screenshot) {
        keyword.takeScreenshot(screenshot);
    }
}
