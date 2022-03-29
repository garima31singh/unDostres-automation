package org.undostres.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.undostres.Assertions.assertionClass;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class payment {
     WebDriver driver;
     Properties pr;

    public payment(WebDriver driver, Properties pr){
        this.driver=driver;
        this.pr=pr;
    }
    @Test
    public void paymentScreen() throws InterruptedException {

        //Define explicit wait
        WebDriverWait wait= new WebDriverWait(driver,20);

        WebElement getTitle =driver.findElement(By.xpath(pr.getProperty("pagetitle")));
        String titleOfPage= getTitle.getText();
//        System.out.println(titleOfPage);

        wait.until(ExpectedConditions.visibilityOf(getTitle));

        //Choose payment option
        driver.findElement(By.xpath(pr.getProperty("paymentOption"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(pr.getProperty("clickRadioButton"))).click();

        //Enter Card Details
        driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
        WebElement cardNumber= driver.findElement(By.xpath(pr.getProperty("enterCardNum")));
        cardNumber.click();
        cardNumber.sendKeys("4111111111111111");

        WebElement expMonth= driver.findElement(By.xpath(pr.getProperty("enterExpiryMonth")));
        expMonth.click();
        expMonth.sendKeys("11");
        Thread.sleep(1000);

        WebElement expYear= driver.findElement(By.xpath(pr.getProperty("enterExpYear")));
        expYear.click();
        expYear.sendKeys("25");

        WebElement cvv= driver.findElement(By.xpath(pr.getProperty("enterCVV")));
        cvv.click();
        cvv.sendKeys("111");
        Thread.sleep(1000);

        WebElement email= driver.findElement(By.xpath(pr.getProperty("emailField")));
        email.click();
        email.sendKeys("test@test.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath(pr.getProperty("clickPayment"))).click();

        //Wait until next page becomes visible
        WebElement fbLogin= driver.findElement(By.xpath(pr.getProperty("fbTitle")));
        wait.until(ExpectedConditions.visibilityOf(fbLogin));

    }
}
