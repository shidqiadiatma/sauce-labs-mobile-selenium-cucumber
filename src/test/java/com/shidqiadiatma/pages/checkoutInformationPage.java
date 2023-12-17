package com.shidqiadiatma.pages;

import com.shidqiadiatma.helpers.enums.direction;
import com.shidqiadiatma.helpers.keyword;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class checkoutInformationPage {

    protected AppiumDriver appiumDriver;

    public checkoutInformationPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-First Name']")
    private WebElement input_firstName;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Last Name']")
    private WebElement input_lastName;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Zip/Postal Code']")
    private WebElement input_postalCode;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CONTINUE']")
    private WebElement continue_button;



    public void fill_checkoutInformation() {
        keyword.waitUntilElementIsVisible(input_firstName);
        keyword.inputText(input_firstName, "samsul");
        keyword.inputText(input_lastName, "ipong");
        keyword.inputText(input_postalCode, "33783");
        keyword.tapElement(continue_button);
        keyword.waitFor(3);



    }

}
