package com.test1;

import com.base.AfterBeforeMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitForElement extends AfterBeforeMethods {

    @Test
    public void checkHelloWorld() {
        //open the page
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        //click on the button
        WebElement element = driver.findElement(By.cssSelector("div#start>button"));
        //clicking on the element
        element.click();
        //find Hello World
        WebElement text1 = driver.findElement(By.cssSelector("div#finish>h4"));
        //explicit wait
        WebDriverWait explicitWait = new WebDriverWait(driver,10);
        explicitWait.until(ExpectedConditions.visibilityOf(text1));
        //checking Hello World
        Assert.assertTrue(text1.getText().contains("Hello World!"),"!!!!TEST HAS BEEN FAILED!!!!");
    }
}
