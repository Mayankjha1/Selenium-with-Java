package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.List;

public class Make_My_Trip {

    @Test
    @Description("We are going to automate Make My Trip ")
    public void Test_Case_Login() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(3000);
        //Source
        driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]")).click();
        WebElement source = driver.findElement(By.xpath("//input[@id=\"fromCity\"]"));
        Actions Source = new Actions(driver);
        Source.moveToElement(source).click().build().perform();
        Source.moveToElement(source).click().sendKeys("Patna").build().perform();
        Thread.sleep(3000);
        List<WebElement> list_of_Suggestions_Source = driver.findElements(By.xpath("//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]"));
        for (WebElement element:list_of_Suggestions_Source){
            System.out.println(element.getText());
           // Thread.sleep(3000);
            if(element.getText().contains("Patna")){
                element.click();
                break;
            }
        }
        //Destination
        WebElement destination = driver.findElement(By.xpath("//input[@id=\"toCity\"]"));
        Actions Destination = new Actions(driver);
        Destination.moveToElement(destination).click().build().perform();
        Destination.moveToElement(destination).click().sendKeys("New Delhi").build().perform();
        Thread.sleep(3000);
        List<WebElement> list_of_Suggestions_Destination = driver.findElements(By.xpath("//div[@class=\"autoSuggestPlugin hsw_autocomplePopup makeFlex column spaceBetween\"]"));
        for (WebElement element:list_of_Suggestions_Destination){
            System.out.println(element.getText());
            // Thread.sleep(3000);
            if(element.getText().contains("New Delhi")){
                element.click();
                break;
            }
        }

        driver.quit();
    }
}
