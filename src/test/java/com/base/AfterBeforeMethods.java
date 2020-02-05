package com.base;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AfterBeforeMethods {
    public ChromeDriver driver;
    @BeforeMethod(alwaysRun = true)
    protected void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //set headless mode;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("c:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        chromeOptions.addArguments("--headless");

        driver = new ChromeDriver(chromeOptions);

        System.out.println("START!");
    }

    @AfterMethod(alwaysRun = true)
    protected void destroyDriver() {
        driver.quit();
        System.out.println("END!");
    }
}
