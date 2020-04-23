package com.projectTestPackage.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Products {

        public Products(WebDriver driver){
            this.driver=driver;
            wait=new WebDriverWait(driver,10);
        }

        //INITIALIZE DRIVER AND LOCATORS

        WebDriver driver;
        WebDriverWait wait;

        By headphones=By.xpath("//a[text()='Beats Studio 2 Over-Ear Matte Black Headphones']");
        By addProductButton=By.xpath("//button[@name='save_to_cart']");
        By numberOfProducts=By.xpath("//label[@class='roboto-regular ng-binding']");
        By kart=By.id("shoppingCartLink");

        public void clickOnProduct(){
            driver.findElement(headphones).click();
        }
        public void addToKart(){
            driver.findElement(addProductButton).click();
        }
        public String getProducts(){
            driver.findElement(kart).click();
            String products=driver.findElement(numberOfProducts).getAttribute("innerText");
            return products;
        }

}
