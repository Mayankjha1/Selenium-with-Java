package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class Spice_jet_Automate {

    @Test
    @Description("We are going to automate Spice Jet")
    public void Test_Case_Login() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        WebElement source = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));
        Actions actions = new Actions(driver);
        //Source
        actions.moveToElement(source).click().build().perform();
        actions.moveToElement(source).click().sendKeys("PAT").build().perform();
        //Destination
        WebElement Destination = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-destination\"]/div/div/input"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(Destination).click().build().perform();
        actions2.moveToElement(Destination).click().sendKeys("BLR").build().perform();
        System.out.println(driver.getTitle());
        driver.quit();


    }
}
