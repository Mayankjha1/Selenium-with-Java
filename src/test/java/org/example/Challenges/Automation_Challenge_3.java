package org.example.Challenges;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Automation_Challenge_3 {
    @Test
    @Description("Web tables verification\n")
    public void Test_Case_Login() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/modal-dialogs");
        Thread.sleep(3000);

        // To open Modal
        driver.findElement(By.id("showSmallModal")).click();

        Thread.sleep(2000);

//        // To Verify the Content and print
//            String ActualTitle = driver.findElement(By.xpath("//div[@class=\"modal-body\"]")).getText();
//            System.out.println("ActualTitle ->> "+ ActualTitle);
//            String ExpectedTitle = "This is a small modal. It has very less content";
//            Assert.assertEquals(ActualTitle,ExpectedTitle);


        String ActualTitle = driver.findElement(By.xpath("//div[@class=\"modal-body\"]")).getText();
        System.out.println("ActualTitle ->> " + ActualTitle);
        String ExpectedTitle = "This is a small modal. It has very less content";
        //Assert.assertEquals(ActualTitle, ExpectedTitle);
        org.testng.Assert.assertEquals(ActualTitle, ExpectedTitle);

        // To close the Modal

        driver.findElement(By.id("closeSmallModal")).click();

        // To quit the Driver/ Chrome

        Thread.sleep(5000);
        driver.quit();
    }

}
