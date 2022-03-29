package org.undostres.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public Properties pr;

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String BrowserName) throws Exception {
        System.out.println("Running browser is " + BrowserName);
        if (BrowserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver");
            driver= new FirefoxDriver();
        } else if (BrowserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
            driver= new ChromeDriver();
        } else {
            throw new Exception("No browser Selected");
        }
    }
    @BeforeMethod
    public void browserLaunch() throws IOException {
        //Load Properties file
        File f= new File("./locators.properties");
        FileInputStream fi= new FileInputStream(f);
        pr= new Properties();
        pr.load(fi);

        // open url
        driver.get("https://prueba.undostres.com.mx/");
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
