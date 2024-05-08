package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Alert_Handling {
    @Test
    @Description("Handling Alerts")
    public void Test_Case_Login() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // We Can use xpath
        //button[@onclick="jsAlert()"]
        //button[text()="Click for JS Alert"]

        driver.findElement(By.xpath("//button[text()=\"Click for JS Alert\"]")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You successfully clicked an alert");
        System.out.println(result);

        driver.quit();
    }
}
