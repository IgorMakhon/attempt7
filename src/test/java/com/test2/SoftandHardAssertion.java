package com.test2;

import com.base.AfterBeforeMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SoftandHardAssertion extends AfterBeforeMethods {
        private String URLforTest="http://the-internet.herokuapp.com/disappearing_elements";
        List<String> elements = new ArrayList<String>();
        @Test
        public void veryfingPresenceHard() {
            preTest();
            //open the page
            driver.get(URLforTest);
            //find elements
            List<WebElement> tabNames = driver.findElements(By.cssSelector("ul>li>a"));
            //verify quantity of tabs
            int tabNumbers = tabNames.size();
            Assert.assertTrue(tabNumbers==5, "the qty is not 5, it is "+tabNumbers);
            //compare text in tabs with List
            for(int i = 0;i<elements.size();i++){
                String tabLabel = tabNames.get(i).getText();
                String desiredName = elements.get(i);
                Assert.assertTrue(tabLabel.equals(desiredName),"the tab "+tabLabel+" is not equal to the "+ desiredName);
            }
        }

        @Test
        public void veryfingPresenceSoft() {
            preTest();

            SoftAssert softAssert = new SoftAssert();
            //open the page
            driver.get(URLforTest);
            //find elements
            List<WebElement> tabNames = driver.findElements(By.cssSelector("ul>li>a"));
            //verify quantity of tabs
            int tabNumbers = tabNames.size();
            softAssert.assertTrue(tabNumbers==5, "the qty is not 5, it is "+tabNumbers);
            //compare text in tabs with List
            for(int i = 0;i<tabNames.size();i++){
                String tabLabel = tabNames.get(i).getText();
                String desiredName = elements.get(i);
                softAssert.assertTrue(tabLabel.equals(desiredName),"the tab "+tabLabel+" is not equal to the "+ desiredName);
                System.out.println("the tab text is " + tabLabel+" and the disered text is " +desiredName);
            }
            softAssert.assertAll();
        }
            public void preTest() {
                //adding elements in list
                if(elements.size()<1){
                    Collections.addAll(elements,
                            "Home",
                            "About",
                            "Contact Us",
                            "Portfolio",
                            "Gallery");
                }
            }
    }
