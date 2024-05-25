package org.example.Challenges;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

//Calculate the Total Amount of Money Spent via Selenium Script
public class Automation_Challenge_1 {

    @Test
    @Description("Calculate the Total Amount of Money Spent via Selenium Script")
    public void Test_Case_Login() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.applitools.com");
        Thread.sleep(5000);

        // Enter the Username as Admin and Password as Password@123
        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("Password@123");
        driver.findElement(By.xpath("//a[@id=\"log-in\"]")).click();

        // Fetch Table Data
        List<WebElement> Fetch_Table_Data = driver.findElements(By.xpath("//table[@class=\"table table-padded\"]/tbody/tr"));
        for(WebElement element: Fetch_Table_Data){
           // System.out.println(element.getText());
            String Amount = driver.findElement(with(By.className("text-success")).below(element)).getText();
            String Amount2 = driver.findElement(with(By.className("text-danger")).below(element)).getText();
            System.out.println("Amount Positive " + Amount);
            System.out.println("Amount Negative " + Amount2);

        }

        // quit the browser
        Thread.sleep(5000);
        driver.quit();

    }

}
