package org.undostres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.undostres.Assertions.assertionClass;

import java.util.Properties;

public class Recharge {
     WebDriver driver;
     Properties pr;

    public Recharge(WebDriver driver,Properties pr){
        this.driver=driver;
        this.pr=pr;
    }
    @Test
    public void rechargeScreen() throws InterruptedException {

        //**Verifying page title
        String expectedTitle= pr.getProperty("titleHome");
        String actualTitle= driver.getTitle();
        assertionClass.compareStrings(actualTitle,expectedTitle);

        //**Choose operator
        driver.findElement(By.xpath(pr.getProperty("clickOperator"))).click();
        WebElement operator= driver.findElement(By.xpath(pr.getProperty("clickOperator")));
        operator.click();
        Thread.sleep(1000);
        WebElement chooseOperator= driver.findElement(By.xpath(pr.getProperty("chooseType")));
        chooseOperator.click();

        //**enter phone number
        WebElement enterNumber= driver.findElement(By.xpath(pr.getProperty("numberField")));
        enterNumber.click();
        enterNumber.sendKeys("8465433546");

        //**Enter recharge amount
        WebElement chooseAmount= driver.findElement((By.xpath(pr.getProperty("amountField"))));
        chooseAmount.click();
        WebElement enterAmount= driver.findElement(By.xpath(pr.getProperty("chooseAmount")));
        enterAmount.click();

        //Submit details
        driver.findElement(By.xpath(pr.getProperty("submitButton"))).click();
    }
}
