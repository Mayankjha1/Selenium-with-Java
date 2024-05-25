package org.example.Challenges;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import java.util.List;

public class Automation_Challenge_2 {
    @Test
    @Description("Web tables verification\n")
    public void Test_Case_Login() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        Thread.sleep(3000);

        //Scroll
        WebElement element = driver.findElement(By.xpath("//div[@class=\"action-buttons\"]/span[@id=\"edit-record-3\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println("Scrolled");

        // Click on edit
       driver.findElement(By.xpath("//div[@class=\"action-buttons\"]/span[@id=\"edit-record-3\"]")).click();


        //Action Class
        Actions actions2 = new Actions(driver);
        WebElement Age = driver.findElement(By.id("age"));
        Age.clear();
        actions2.moveToElement(Age).click().build().perform();
        actions2.moveToElement(Age).click().sendKeys("34").build().perform();
       // System.out.println(driver.getTitle());

        // Submit Button click
        driver.findElement(By.id("submit")).click();
        //System.out.println("Submitted");
        ////div[@class="rt-tr-group"]/div/div[3]
        Thread.sleep(3000);

        List<WebElement> lists =  driver.findElements(By.xpath("//div[3][@class=\"rt-tr-group\"]/div/div[3]"));
        for (WebElement elements:lists){
            System.out.println(elements.getText());
            // Actual and Expected
//            String ActualTitle = elements.getText();
//            String ExpectedTitle = "34";
//            Assert.assertEquals(ActualTitle,ExpectedTitle);
            Thread.sleep(3000);
            String actualText = elements.getText();
            System.out.println("Actual Age: " + actualText);
            Assert.assertEquals(actualText, "34");

        }









        // quit the browser
        Thread.sleep(10000);
        driver.quit();
    }
}
