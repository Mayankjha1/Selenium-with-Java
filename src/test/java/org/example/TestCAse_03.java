package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCAse_03 {
    @Test
    public void googleVerify(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(),"Google");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com/");
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
