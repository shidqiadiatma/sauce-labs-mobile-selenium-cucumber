package com.shidqiadiatma.steps;

import com.shidqiadiatma.factories.driverManager;
import com.shidqiadiatma.pages.*;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class checkoutStep {

    private final AndroidDriver androidDriver;

    public checkoutStep() {
        androidDriver = driverManager.getInstance().getDriver();
    }

    @When("user tap Add To Cart button on first product")
    public void userTapAddToCartButtonOnFirstProduct() {
        homePage homePage = new homePage(androidDriver);
        homePage.add_firstProduct_to_cart();
    }
    @And("user tap Add To Cart button on second product")
    public void userTapAddToCartButtonOnSecondProduct() {
        homePage homePage = new homePage(androidDriver);
        homePage.add_secondProduct_to_cart();
    }

    @And("user tap Cart icon")
    public void userTapCartIcon() {
        homePage homePage = new homePage(androidDriver);
        homePage.tap_cartIcon();
    }

    @And("user tap Checkout button on Your Cart page")
    public void userTapCheckoutButton() {
        yourCartPage yourCartPage = new yourCartPage(androidDriver);
        yourCartPage.tap_checkoutButton();
    }

    @And("user fill in Checkout Information")
    public void userFillInCheckoutInformation() {
        checkoutInformationPage checkoutInformationPage = new checkoutInformationPage(androidDriver);
        checkoutInformationPage.fill_checkoutInformation();
    }

    @And("user tap Finish button on Checkout Overview page")
    public void userTapFinishButtonOnCheckoutOverviewPage() {
        checkoutOverviewPage checkoutOverviewPage = new checkoutOverviewPage(androidDriver);
        checkoutOverviewPage.tap_finishButton();
    }

}
