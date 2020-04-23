package com.projectTestPackage.POM.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class Setup {

    WebDriver driver;
    String URL= "https://www.advantageonlineshopping.com/#/";

    public Setup(WebDriver driver){
        this.driver=driver;
    }

    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver" , "C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\chromedriver_win32\\chromedriver2.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
    }

}
