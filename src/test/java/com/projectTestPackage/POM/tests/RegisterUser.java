package com.projectTestPackage.POM.tests;

import com.projectTestPackage.POM.pages.HomePage;
import com.projectTestPackage.POM.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegisterUser {

    WebDriver driver;
    String actualResult=null;
    String expecResult=null;
    HomePage homePageObj;
    RegisterPage registerPage;
    public static String user="lenis10";
    public static String pass="Pass123";

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
    public void goToRegisterPage(){

        //VALIDATE HOME PAGE NAME AN CLICK ON REGISTER LINK
        homePageObj= new HomePage(driver);
        actualResult=homePageObj.getHomePageTitle();
        expecResult=" Advantage Shopping";
        homePageObj.clickOnRegisterLink();
        Assert.assertEquals(actualResult,expecResult);
        System.out.print(actualResult);
        //CLICK ON CREATE NEW ACCOUNT
        homePageObj.clickOnCreateAnAccount();


    }
    @Test(priority = 1,enabled=true)
    public void registerUser(){

        //FILL THE NECESSARY FIELDS TO REGISTER AND CHECK IF REGISTER BUTTON IS AVAILABLE
        registerPage=new RegisterPage(driver);
        registerPage.setSubmit(user,"lenis@gmail.com",pass);
        actualResult=driver.findElement(RegisterPage.submit).getAttribute("class");
        expecResult="sec-sender-a invalid ng-scope";
        Assert.assertNotEquals(actualResult,expecResult);
        registerPage.clickOnRegister();
        System.out.println(actualResult);
    }
    @AfterTest
    public void tearDown(){driver.quit();}
}
