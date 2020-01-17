package com.test3;

import com.base.AfterBeforeMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitForElement2 extends AfterBeforeMethods {
    @Test
    public void afterRendering() {
        //open site;
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        //find the button;
        WebElement button = driver.findElement( By.cssSelector("div#start>button"));
        //click on the button;
        button.click();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //find text;
        WebElement text2 = driver.findElement(By.cssSelector("div#finish>h4"));
        //checking the text
        Assert.assertTrue(text2.getText().contains("Hello World!"),"!!!!TEST HAS BEEN FAILED!!!!");
    }
}
