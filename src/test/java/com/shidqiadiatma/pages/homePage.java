package com.shidqiadiatma.pages;

import com.shidqiadiatma.helpers.enums.direction;
import com.shidqiadiatma.helpers.keyword;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class homePage {

    protected AppiumDriver appiumDriver;

    public homePage(AppiumDriver driver) {
        this.appiumDriver = driver;
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']/android.view.ViewGroup/android.widget.ImageView")
    private WebElement burgerNav_icon;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]")
    private WebElement swagLabs_icon;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView")
    private WebElement cart_icon;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart drop zone']/android.view.ViewGroup")
    private WebElement top_greyBox;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart drop zone']/android.view.ViewGroup/android.widget.TextView")
    private WebElement title_page;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Toggle']/android.widget.ImageView")
    private WebElement toggle_icon;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Modal Selector Button']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    private WebElement filter_icon;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='Selector container']/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private WebElement popUp_title;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='Selector container']/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView")
    private WebElement highToLow_option;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Toggle']/android.widget.ImageView")
    private WebElement changeView_icon;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[1]/android.widget.TextView")
    private WebElement add_to_cart_product1;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[2]/android.widget.TextView")
    private WebElement add_to_cart_product2;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.TextView")
    private WebElement Numberbadge_cart;

    public void verify_Component_OnHomePage(String titlePage_text) {
        keyword.verifyElementExist(burgerNav_icon);
        keyword.verifyElementExist(swagLabs_icon);
        keyword.verifyElementExist(cart_icon);
        keyword.verifyElementExist(top_greyBox);
        keyword.verifyWordingOnElement(title_page, titlePage_text);
        keyword.verifyElementExist(toggle_icon);
        keyword.verifyElementExist(filter_icon);

    }

    public void add_firstProduct_to_cart() {
        keyword.waitUntilElementIsClickable(add_to_cart_product1);
        keyword.tapElement(add_to_cart_product1);
        keyword.swipe(direction.UP); //scroll down
        keyword.waitFor(3);
        String value = Numberbadge_cart.getText();
        Assert.assertEquals(value, "1");
    }

    public void add_secondProduct_to_cart() {
        keyword.waitUntilElementIsClickable(add_to_cart_product2);
        keyword.tapElement(add_to_cart_product2);
        keyword.waitFor(3);
        String value = Numberbadge_cart.getText();
        Assert.assertEquals(value, "2");
        keyword.waitFor(3);

    }

    public void tap_cartIcon() {
        keyword.tapElement(cart_icon);
        keyword.waitFor(4);
    }



    public static void comparePrices(WebDriver driver) {
        // Use the provided XPath expressions to locate the elements
        String xpathExpression = "(//android.widget.TextView[@content-desc='test-Price'])";
        List<WebElement> itemPrices = driver.findElements(By.xpath(xpathExpression));

        boolean isSorted = isPriceSorted(itemPrices);

        Assert.assertTrue(isSorted, "Items are not sorted by price (high to low)");
    }

    private static boolean isPriceSorted(List<WebElement> itemPrices) {
        for (int i = 0; i < itemPrices.size() - 1; i++) {
            double value1 = extractNumericValue(itemPrices.get(i));
            double value2 = extractNumericValue(itemPrices.get(i + 1));

            if (value1 < value2) {
                return false;
            }
        }
        return true;
    }

    private static double extractNumericValue(WebElement element) {
        String priceText = element.getText().replace("$", "");
        return Double.parseDouble(priceText);
    }

    public boolean verifySuccessLogin() {
        keyword.waitUntilElementIsVisible(cart_icon);
        return cart_icon.isDisplayed();
    }

    public void tap_changeView_icon() {
        keyword.waitUntilElementIsVisible(changeView_icon);
        keyword.tapElement(changeView_icon);
        keyword.waitFor(2);
    }

    public void tap_FilterIcon() {
        keyword.waitUntilElementIsVisible(filter_icon);
        keyword.tapElement(filter_icon);
        keyword.waitFor(2);
    }

    public void tap_HighToLow() {
        keyword.waitUntilElementIsVisible(popUp_title);
        keyword.tapElement(highToLow_option);
        keyword.waitFor(2);
    }

}
