package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase_02 {
    @Test
    public void login(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
