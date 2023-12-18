package com.shidqiadiatma.steps;

import com.shidqiadiatma.factories.driverManager;
import com.shidqiadiatma.helpers.keyword;
import com.shidqiadiatma.pages.loginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class commonStep {

    private final AndroidDriver androidDriver;

    public commonStep() {
        androidDriver = driverManager.getInstance().getDriver();
    }

    @Given("user is already on home page")
    public void userIsAlreadyOnHomePage() {
        loginPage loginPage = new loginPage(androidDriver);
        loginPage.verify_Component_OnLoginPage();
        loginPage.tap_Autofill();
        loginPage.verify_usernameIsFilledIn();
        loginPage.tap_loginButton();
    }

    @Given("user open SwagLabs app")
    public void userOpenSwagLabsApp() {
        loginPage loginPage = new loginPage(androidDriver);
        loginPage.verify_Component_OnLoginPage();
    }

    @And("user take screenshot {string}")
    public void userTakeScreenshot(String screenshot) {
        keyword.takeScreenshot(screenshot);
    }
}
