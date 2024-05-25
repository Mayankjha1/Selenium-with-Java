package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.lang.model.util.Elements;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Polluted_City {

    @Test
    @Description("We are going to automate Polluted city")
    public void Test_Case_Login() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        Thread.sleep(5000);

        //Search India
        driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys("India"+ Keys.ENTER);

        // Fetch all the data from the table
        List<WebElement> Table_Data = driver.findElements(By.xpath("//table[@id=\"example\"]/tbody/tr"));
        for(WebElement element: Table_Data){
            System.out.println(element.getText());
            //Thread.sleep(3000);
           // String AQI = driver.findElement(with(By.tagName("p")).toRightOf(element)).getText();
           // String Rank = driver.findElement(with(By.tagName("p")).toLeftOf(element)).getText();

            //System.out.println("AQI " + AQI);
           // System.out.println("Rank " + Rank);
        }


        // Wait for 6 sec and quit the browser
        Thread.sleep(6000);
        driver.quit();


    }
}
