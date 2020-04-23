package com.projectTestPackage.POM.tests;

import com.projectTestPackage.POM.pages.HomePage;
import com.projectTestPackage.POM.pages.Products;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Purchase {

    WebDriver driver;
    String actualResult=null;
    String expecResult=null;
    HomePage homePageObj;
    Products product;


    @BeforeTest
    public void setupSystem(){
        System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+ "\\drivers\\chromedriver2.exe");
        String URL= "https://www.advantageonlineshopping.com/#/";
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
    }
    @Test(priority = 0,enabled=true)
    public void addProduct() throws InterruptedException {
        homePageObj=new HomePage(driver);
        homePageObj.clickOnSearchButton();
        //Thread.sleep(3000); //Only to visualizate process
        homePageObj.findProduct("head");
        homePageObj.clickOnSearchButton();
        homePageObj.closeWindow();
        product=new Products(driver);
        product.clickOnProduct();
        product.addToKart();

        expecResult="(1 Item)";
        actualResult=product.getProducts();

        Assert.assertEquals(actualResult,expecResult);
    }
    @AfterTest
    public void tearDown(){driver.quit();}
}
