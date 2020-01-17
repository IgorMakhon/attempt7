package com.test;

import com.base.AfterBeforeMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomePage extends AfterBeforeMethods {
    @Test
    public void checkTitle() {
        driver.get("http://the-internet.herokuapp.com/");
        Assert.assertEquals(driver.getTitle(),"The Internet");
    }
}