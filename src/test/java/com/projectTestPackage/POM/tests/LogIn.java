package com.projectTestPackage.POM.tests;

import com.projectTestPackage.POM.pages.HomePage;
import com.projectTestPackage.POM.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogIn {

    WebDriver driver;
    String actualResult=null;
    String expecResult=null;
    HomePage homePageObj;

    @BeforeTest
    public void setupSystem() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+ "\\drivers\\chromedriver2.exe");
        String URL= "https://www.advantageonlineshopping.com/#/";
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        Thread.sleep(3000); //Only to visualizate process
    }
    @Test(priority = 0,enabled=true)
    public void goToRegisterPage() throws InterruptedException {

        //VALIDATE HOME PAGE NAME AN CLICK ON REGISTER LINK
        homePageObj= new HomePage(driver);
        homePageObj.clickOnRegisterLink();
        Thread.sleep(3000); //Only to visualizate process
        homePageObj.logInData(RegisterUser.user,RegisterUser.pass);
        actualResult=(driver.findElement(HomePage.warningMessage).getAttribute("innerText"));
        expecResult="Maximum number logged users";
        Assert.assertNotEquals(actualResult,expecResult,"¡Login error!");
    }
    @AfterTest
    public void tearDown(){driver.quit();}
}
