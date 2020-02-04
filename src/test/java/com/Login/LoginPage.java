package com.Login;

import com.base.AfterBeforeMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPage extends AfterBeforeMethods {
@Test
    public void checkPassword(){
        //open the page;
        driver.get("http://the-internet.herokuapp.com/login");
        //find element;
        WebElement usernameField = driver.findElement(By.cssSelector("#username"));
        //click on the element;
        usernameField.clear();
        //enter the value in the field;
        usernameField.sendKeys("Igor");
        //find login button;
        WebElement buttonLogin = driver.findElementByCssSelector("button.radius");
        buttonLogin.click();
        //explicit wait;
        WebDriverWait explicitWait = new WebDriverWait(driver,10);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        //find the message;
        WebElement textOfMessage = driver.findElement(By.id("flash"));
        //check the text in alert;
        Assert.assertTrue(textOfMessage.getText().contains("Your username is invalid!"), "flash message is wrong!");


    }
}
