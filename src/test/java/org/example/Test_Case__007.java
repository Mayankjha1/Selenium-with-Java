package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Test_Case__007 {
    // Open Chrome and Search on google what is API Testing > then just get all the anchor tag and print on console
    @Test
    @Description("WGoing to Automate the Login Page using Selenium")
    public void Test_Case_Login(){


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.className("gLFyf")).sendKeys("What is API Testing" + "\n");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List <WebElement> all_tags = driver.findElements(By.tagName("a"));
        for(WebElement element: all_tags){
            System.out.println(element.getText());
            System.out.println(element.getSize());
        }
        driver.quit();
    }
}
