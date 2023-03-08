package com.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_Driver(String browsers){
        System.out.println("Browser value is " + browsers);
       if (browsers.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if (browsers.equals("firefox")){
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver());

        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
}
