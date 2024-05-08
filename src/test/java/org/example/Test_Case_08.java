package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Test_Case_08 {
    @Test
    @Description("We are going to Automate the Ebay [Search Mac and Print all the Title]")
    public void Test_Case_Login() {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Mac" + "\n");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> Print_Title = driver.findElements(By.xpath("//*[@aria-level=\"3\"]"));
        for(WebElement elements: Print_Title){
            System.out.println(elements.getText());
        }

        driver.quit();
    }
}
