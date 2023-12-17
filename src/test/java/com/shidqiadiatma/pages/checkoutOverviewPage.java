package com.shidqiadiatma.pages;

import com.shidqiadiatma.helpers.enums.direction;
import com.shidqiadiatma.helpers.keyword;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class checkoutOverviewPage {

    protected AppiumDriver appiumDriver;

    public checkoutOverviewPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-FINISH']")
    private WebElement finish_button;

    public void tap_finishButton () {
        keyword.swipe(direction.UP);
        keyword.waitUntilElementIsClickable(finish_button);
        keyword.tapElement(finish_button);
        keyword.waitFor(3);
    }


}
