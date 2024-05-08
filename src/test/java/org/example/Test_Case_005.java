package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Test_Case_005 {
    @Test
    @Description("WGoing to Automate the Login Page using Selenium")
    public void Test_Case_Login(){

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");

        // Open Chrome Browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        WebElement anchor_tag = driver.findElement(By.linkText("Start a free trial"));
        System.out.println(anchor_tag.getAttribute("href"));
        driver.quit();
    }
}
