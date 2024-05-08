package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_04 {
    @Test
    @Description("WGoing to Automate the Login Page using Selenium")
    public void Test_Case_Login(){

        // Open Chrome Browser
        WebDriver driver = new ChromeDriver();
        // Search the URL in CHrome Browser
        driver.get("https://app.vwo.com/#/login");
        // Search and Enter the Id
        driver.findElement(By.id("login-username")).sendKeys("nihapeg859@agafx.com");
        // Search and Enter the Password
        driver.findElement(By.name("password")).sendKeys("qwerty@12345A-");
        // Search the id and click on Login button
        driver.findElement(By.id("js-login-btn")).click();
        //We are waiting for 3-4 sec for error message and all
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // If error Message will come i.e for wrong id and password
        WebElement Notification_box = driver.findElement(By.className("notification-box-description"));
        String Notification_box_01 = Notification_box.getText();
        // Expected result and Actual result
        Assert.assertEquals(Notification_box_01,"Your email, password, IP address or location did not match");
        //Message in Console
        System.out.println("Executed Successfully");
        // Close the browser
        driver.quit();

    }


}
