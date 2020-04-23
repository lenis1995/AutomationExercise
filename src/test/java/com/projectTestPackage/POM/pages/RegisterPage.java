package com.projectTestPackage.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    public RegisterPage(WebDriver driver){
        this.driver=driver;
    }

    //INITIALIZE DRIVER AND LOCATORS

    WebDriver driver;

    By username=By.xpath("//input[@name='usernameRegisterPage']");
    By email=By.xpath("//input[@name='emailRegisterPage']");
    By password=By.xpath("//input[@name='passwordRegisterPage']");
    By confirmPassword=By.xpath("//input[@name='confirm_passwordRegisterPage']");
    By checkbox=By.name("i_agree");
    public static By submit=By.xpath("//button[@id='register_btnundefined']");

    //------------------------------------------------------------------------------------------------------------------

    //METHODS DECLARATION

    public void setUsername(String user){driver.findElement(username).sendKeys(user);}
    public void setEmail(String mail){driver.findElement(email).sendKeys(mail);}
    public void setPassword(String pass){driver.findElement(password).sendKeys(pass);}
    public void setPassConfirm(String confirm){driver.findElement(confirmPassword).sendKeys(confirm);}
    public void checkConditions(){driver.findElement(checkbox).click();}
    public void clickOnRegister(){ driver.findElement(submit).click();}
    public void setSubmit(String user, String mail, String pass){
        this.setUsername(user);
        this.setEmail(mail);
        this.setPassword(pass);
        this.setPassConfirm(pass);
        this.checkConditions();
    }
}
