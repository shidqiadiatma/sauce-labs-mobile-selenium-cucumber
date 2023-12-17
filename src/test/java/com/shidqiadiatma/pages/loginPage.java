package com.shidqiadiatma.pages;

import com.shidqiadiatma.helpers.keyword;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class loginPage {

    protected AppiumDriver appiumDriver;

    public loginPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-standard_user']/android.widget.TextView")
    private WebElement autofill_standard_user;
    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    private WebElement input_username;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    private WebElement input_password;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    private WebElement login_button;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-Login']/android.view.ViewGroup/android.widget.ImageView[1]")
    private WebElement swaglabs_logo;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-Login']/android.view.ViewGroup/android.widget.ImageView[2]")
    private WebElement swaglabs_image;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
    private WebElement snackbar_error;

    public boolean verifyLayout_swaglabsLogo(){
        keyword.waitUntilElementIsVisible(swaglabs_logo);
        return swaglabs_logo.isDisplayed();
    }

    public boolean verifyLayout_swaglabsImage(){
        keyword.waitUntilElementIsVisible(swaglabs_image);
        return swaglabs_image.isDisplayed();
    }

    public void doLogin(String username, String password) {
        keyword.inputText(input_username, username);
        keyword.inputText(input_password, password);
        keyword.tapElement(login_button);
        keyword.waitFor(2);
    }

    public void doLogin_autofill() {
        keyword.waitUntilElementIsClickable(autofill_standard_user);
        keyword.tapElement(autofill_standard_user);
        keyword.waitFor(3);
        String value = input_username.getText();
        Assert.assertEquals(value, "standard_user");
        keyword.waitFor(3);
        keyword.tapElement(login_button);
        keyword.waitFor(3);
    }

    public void verifySnackbarErrorExist(String expectedMessage) {
        String actual = snackbar_error.getText();
        Assert.assertEquals(actual, expectedMessage);
    }

}
