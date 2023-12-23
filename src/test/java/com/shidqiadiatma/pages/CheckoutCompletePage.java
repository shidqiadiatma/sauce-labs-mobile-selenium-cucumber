package com.shidqiadiatma.pages;

import com.shidqiadiatma.helpers.keyword;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class checkoutCompletePage {

    protected AppiumDriver appiumDriver;

    public checkoutCompletePage (AppiumDriver driver) {
        this.appiumDriver = driver;
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-CHECKOUT: COMPLETE!']/android.view.ViewGroup/android.widget.TextView[1]")
    private WebElement title_checkoutComplete;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-CHECKOUT: COMPLETE!']/android.view.ViewGroup/android.widget.TextView[2]")
    private WebElement description_checkoutComplete;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-CHECKOUT: COMPLETE!']/android.view.ViewGroup/android.widget.ImageView")
    private WebElement image_onCheckoutComplete;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-BACK HOME']")
    private WebElement backHome_button;

    public void verify_component_OnCheckoutComplete () {
        keyword.verifyElementExist(title_checkoutComplete);
        keyword.verifyElementExist(description_checkoutComplete);
        keyword.verifyElementExist(image_onCheckoutComplete);
        keyword.verifyElementExist(backHome_button);
    }









}
