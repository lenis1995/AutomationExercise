package com.projectTestPackage.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public HomePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver,10);
    }

    //INITIALIZE DRIVER AND LOCATORS

    WebDriver driver;
    WebDriverWait wait;

    By registerLink=By.xpath("//a[@id='menuUserLink']");
    By image=By.xpath("//div[@id='headphonesImg']");
    By username=By.xpath("//input[@name='username']");
    By password=By.xpath("//input[@name='password']");
    By signIn=By.xpath("//button[@id='sign_in_btnundefined']");
    By searchButton=By.id("menuSearch");
    By searchBar=By.xpath("//input[@id='autoComplete']");
    By closeButton=By.xpath("//div[@data-ng-click='closeSearchForce()']");

    public static By createNewAccount=By.xpath("//a[text()='CREATE NEW ACCOUNT']");
    public static By warningMessage=By.xpath("//label[@id='signInResultMessage']");
    //------------------------------------------------------------------------------------------------------------------

    //METHODS DECLARATION

    public void clickOnRegisterLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(image));
        driver.findElement(registerLink).click();
    }
    public void clickOnCreateAnAccount(){
        wait.until(ExpectedConditions.elementToBeClickable(createNewAccount));
        driver.findElement(createNewAccount).click();
    }
    public String getHomePageTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(image));
        return driver.getTitle().trim();
    }
    public void logInData(String user,String pass){
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signIn).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(warningMessage,"Maximum number logged users"));
    }
    public void closeWindow(){
        driver.findElement(closeButton).click();
    }
    public void clickOnSearchButton(){
        driver.findElement(searchButton).click();
    }
    public void findProduct(String product){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        driver.findElement(searchBar).sendKeys(product);
    }

}
