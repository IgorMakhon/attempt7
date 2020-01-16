package com.base;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AfterBeforeMethods {
    public ChromeDriver driver;
    @BeforeMethod(alwaysRun = true)
    protected void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("START!");
    }

    @AfterMethod(alwaysRun = true)
    protected void destroyDriver() {
        driver.quit();
    }
}
