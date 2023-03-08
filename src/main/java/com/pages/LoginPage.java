package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    //1. By locators:
    By email = By.id("CustomerEmail");
    By password = By.id("CustomerPassword");
    By forgotPassLink = By.linkText("Forgot your password?");
    By signButton = By.xpath("//button[contains(text(), '\n" +
            "          Sign In\n" +
            "        ')]");
    //2.Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean isPasswordLinkDisplayed(){
        return driver.findElement(forgotPassLink).isDisplayed();
    }

    public void enterEmail(String mail){
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    public void clickSignin(){
        driver.findElement(signButton).click();
    }

    public AccountPage login (String username, String pass){
        driver.findElement(email).sendKeys(username);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signButton).click();
        return new AccountPage(driver);
    }
}
