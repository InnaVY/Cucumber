package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver){
        this.driver= driver;
    }

    //1.Locator
    By categories = By.cssSelector(".didactics");

    public String getTitle(){
       return  driver.getTitle();
    }

  public int getCategoriesCount(){
     return  driver.findElements(categories).size();
  }

  public List<String> getCategoriesList(){
      List<String> categoriesList = new ArrayList<>();

      List<WebElement> categoriesElements = driver.findElements(categories);
      for (WebElement e: categoriesElements){
          System.out.println(e.getText());
         categoriesList.add(e.getText());

      }
    return categoriesList;
  }
}
