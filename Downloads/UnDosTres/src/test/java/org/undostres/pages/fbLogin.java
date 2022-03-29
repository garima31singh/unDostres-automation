package org.undostres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class fbLogin {
    WebDriver driver;
    Properties pr;

    public fbLogin(WebDriver driver, Properties pr){
        this.driver=driver;
        this.pr=pr;
    }
    @Test
    public void facebookLogin() throws InterruptedException {

        WebDriverWait wait= new WebDriverWait(driver,30);

        //Take action on pop-up
        WebElement emailAdd= driver.findElement(By.xpath(pr.getProperty("emailFB")));
        emailAdd.click();
        emailAdd.sendKeys("automationexcersise@test.com");
        Thread.sleep(1000);

        WebElement pass= driver.findElement(By.xpath(pr.getProperty("pwdFB")));
        pass.click();
        pass.sendKeys("123456");

        WebElement frameId= driver.findElement(By.xpath(pr.getProperty("frame")));
        driver.switchTo().frame(frameId);

        //capture captcha
        WebElement captc= driver.findElement(By.xpath(pr.getProperty("Captcha")));
        wait.until(ExpectedConditions.elementToBeClickable(captc));
        captc.click();
        driver.switchTo().parentFrame();


        driver.findElement(By.id("loginBtn")).click();

        //adding wait that will wait till success screen appears
        WebElement expectedMessage= driver.findElement(By.xpath("//div[@class='flex-column']/div/div[2]"));
        wait.until(ExpectedConditions.visibilityOf(expectedMessage));

        //Verifying result
        String URL= driver.getCurrentUrl();
        Assert.assertTrue(URL.contains("https://prueba.undostres.com.mx/confirmation/success"));
        System.out.println(URL);


    }
}
