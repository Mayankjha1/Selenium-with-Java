package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flipkart_Question {
    // You have to open Flipkart
    // Click on Electronics>Power bank > Power bank > Click on high to low
    // Print the title of first Highest price Powerbank
    @Test
    @Description("We are going to Automate the Ebay [Search Mac and Print all the Title]")
    public void Test_Case_Login() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        ////[@class="CGMB7B"]

        driver.findElement(By.xpath("//*[text()='Electronics']")).click();
        driver.findElement(By.className("CGMB7B")).click();
        // driver.findElement(By.xpath("//*[contains(text()='Power Bank')]")).click();
        // Scroll
        WebElement element = driver.findElement(By.xpath("//*[text()='Help Center']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);


    }
}
