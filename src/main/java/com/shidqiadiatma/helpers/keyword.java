package com.shidqiadiatma.helpers;

import com.shidqiadiatma.helpers.enums.direction;
import com.shidqiadiatma.factories.driverManager;
import com.shidqiadiatma.helpers.enums.fileType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;


import java.io.File;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class keyword {

    private static final AppiumDriver driver = driverManager.getInstance().getDriver();
//    private static final int ANIMATION_TIME = 200;
    private static final int PRESS_TIME = 200;
    private static final int EDGE_BORDER = 10;
    private static final Duration WAIT_DURATION = Duration.ofSeconds(20);

    private static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, WAIT_DURATION);
    }

    public static void waitFor(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void inputText(WebElement element, String value) {
        waitUntilElementIsVisible(element);
        element.clear();
        element.sendKeys(value);
    }

    public static void waitUntilElementIsVisible(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void verifyElementExist(WebElement element) {
        element.isDisplayed();
    }

    public static void verifyWordingOnElement(WebElement element, String expectedText) {
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    public static void waitUntilElementIsClickable(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void tapElement(WebElement element) {
        waitUntilElementIsClickable(element);
        element.click();
    }

    public static void getText(WebElement element, String expectedNumber) {
        waitUntilElementIsClickable(element);
        element.getText();
    }

    private static void swipe(Point source, Point target) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), source.getX(), source.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), target.getX(), target.getY()));
        driver.perform(Collections.singleton(swipe));
    }

    public static void swipe(direction Direction) {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        int startX = width / 2, startY = 0, endX = width / 2, endY = 0;

        if (Direction.equals(direction.UP)) {
            startY = (int) (height * 0.2);
            endY = (int) (height * 0.8);
        } else if (Direction.equals(direction.DOWN)) {
            startY = (int) (height * 0.8);
            endY = (int) (height * 0.2);
        }

        Point start = new Point(startX, startY);
        Point end = new Point(endX, endY);

        swipe(end, start);
    }

    public static void pullToRefresh() {
        int deviceWidth = driver.manage().window().getSize().getWidth();
        int deviceHeight = driver.manage().window().getSize().getHeight();
        int midX = deviceWidth / 2;
        int midY = deviceHeight / 2;
        int bottomEdge = (int) (deviceHeight * 0.85f);

        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(midX, midY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
                .moveTo(PointOption.point(midX, bottomEdge))
                .release().perform();
    }

    public static void swipeByElement(WebElement startElement, WebElement endElement) {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }

    public static void takeScreenshot(String fileName) {
        try {
            TakesScreenshot screenshot = ((TakesScreenshot) driverManager.getInstance().getDriver());
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("reports/screenshots" + File.separator + fileName + "." + fileType.PNG.name());

            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void swipeScreen(direction dir) {
        Dimension dims = driver.manage().window().getSize();
        PointOption pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        PointOption pointOptionEnd = switch (dir) {
            case DOWN -> PointOption.point(dims.width / 2, dims.height - EDGE_BORDER);
            case UP -> PointOption.point(dims.width / 2, EDGE_BORDER);
            case LEFT -> PointOption.point(EDGE_BORDER, dims.height / 2);
            case RIGHT -> PointOption.point(dims.width - EDGE_BORDER, dims.height / 2);
            default -> throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        };

        try {
            new TouchAction((PerformsTouchActions) driver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
        }
    }
}

