package com.shidqiadiatma.steps;

import com.shidqiadiatma.factories.driverManager;
import com.shidqiadiatma.pages.homePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class sortingStep {
    private final AndroidDriver androidDriver;

    public sortingStep() {
        androidDriver = driverManager.getInstance().getDriver();
    }


    @When("user select filter price high to low")
    public void userSelectFilter() {
        homePage homePage = new homePage(androidDriver);
        homePage.tap_changeView_icon();
        homePage.tap_FilterIcon();
        homePage.tap_HighToLow();
    }

    @Then("compare first product price with second product price")
    public void compareProductPrice(){
        new homePage(androidDriver);
        homePage.comparePrices(androidDriver);

    }
}
