package com.shidqiadiatma.steps;

import com.shidqiadiatma.factories.driverManager;
import com.shidqiadiatma.pages.homePage;
import com.shidqiadiatma.pages.loginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class loginStep {

    private final AndroidDriver androidDriver;

    public loginStep() {
        androidDriver = driverManager.getInstance().getDriver();
    }

    @When("user login using {string}")
    public void loginAs(String credentialType) {

        String username;
        String password;

        switch (credentialType) {
            case "standard_user" -> {
                username = "standard_user";
                password = "secret_sauce";
            }
            case "locked_out_user" -> {
                username = "locked_out_user";
                password = "secret_sauce";
            }
            default -> throw new RuntimeException("credential type doesn't exist");
        }
        loginPage loginPage = new loginPage(androidDriver);
        loginPage.doLogin(username, password);
    }

    @Then("user direct to dashboard screen")
    public void userDirectToDashboardScreen() {
        homePage homePage = new homePage(androidDriver);
        Assert.assertTrue(homePage.verifySuccessLogin());

    }
    @Then("user verify snackbar error with value {string} exists")
    public void userVerifySnackbarError(String value) {
        loginPage loginPage = new loginPage(androidDriver);
        loginPage.verifySnackbarErrorExist(value);
    }

}
