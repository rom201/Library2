package com.library2.pages;

import com.library2.utilities.BrowserUtilities;
import com.library2.utilities.ConfigurationReader;
import com.library2.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends BasePage{


    @FindBy(id = "inputEmail")
    private WebElement emailAddress; // works as user name

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(xpath = "//button[.='Sign in']")
    private WebElement signInButton;


    public void getLoginPage(){
        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
    }


    String email = "";
    String pass = "";


    public void loginAsStudent(){
        getLoginPage();


        email = ConfigurationReader.getProperty("emailStudent");
        pass = ConfigurationReader.getProperty("passwordStudent");
        emailAddress.sendKeys(email);
        password.sendKeys(pass);
        signInButton.click();
    }

    public void loginAsLibrarian(){
       getLoginPage();


        email = ConfigurationReader.getProperty("emailLibrarian");
        pass = ConfigurationReader.getProperty("passwordLibrarian");
        emailAddress.sendKeys(email);
        password.sendKeys(pass);
        signInButton.click();
    }



    public WebElement findHeaderElement(String string){
        String headerElementXpath = "//th[contains(@aria-label, '"+string+"')]";
        WebElement webElement  = Driver.getDriver().findElement(By.xpath(headerElementXpath));
        return webElement;
    }


    public void clickOnHeaderElement(String string){
        String headerElementXpath = "//th[contains(@aria-label, '"+ string + "')]";
        WebElement element=Driver.getDriver().findElement(By.xpath(headerElementXpath));
        BrowserUtilities.waitUntilElementIsClickableAndClick(element);
    }


    public String currentSortedOrderOfHeaderElement(String string) {
        String currentSortOrder = "";
        BrowserUtilities.waitUntilElementIsVisible(findHeaderElement(string));
        String strFromAttribute = findHeaderElement(string).getAttribute("aria-label");
        if (strFromAttribute.contains("ascending")) {
            return currentSortOrder = "descending";
        } else {
            return currentSortOrder = "ascending";
        }
    }

}
