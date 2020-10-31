package com.library2.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BrowserUtilities {

    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

    public static void wait(int sec) {
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception here");
        }
    }


    public static void waitUntilElementIsClickableAndClick(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();

    }

    public static void waitUntilElementIsVisible(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));

    }

}

