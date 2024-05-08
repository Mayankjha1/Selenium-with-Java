package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

// This is the Mini project to make a appoinment and after appoinment print match the Expected result with actual result
// If match then print the Receipt with Confirm...
public class Make_appoinment {

    @Test
    @Description("We are going to Automate the Ebay [Search Mac and Print all the Title]")
    public void Test_Case_Login() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(By.xpath("//a[@id=\"btn-make-appointment\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"txt-username\"]")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@id=\"txt-password\"]")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[@id=\"btn-login\"]")).click();
        // Drop down menu select
        WebElement dropdown = driver.findElement(By.id("combo_facility"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        //Select the check box
        List<WebElement> Check_box = driver.findElements(By.xpath("//input[@id=\"chk_hospotal_readmission\"]"));
        WebElement web = Check_box.get(0);
        web.click();
        // Select radio button
        //input[@id="radio_program_medicaid"]
        driver.findElement(By.xpath(" //input[@id=\"radio_program_medicaid\"]")).click();
        // select date
        //input[@id="txt_visit_date"]
        driver.findElement(By.xpath("//input[@id=\"txt_visit_date\"]")).sendKeys("08/05/2024");
        // comment
        //Thread.sleep(3000);
        driver.findElement(By.id("txt_comment")).click();
        //textarea[@id="txt_comment"]
        driver.findElement(By.id("txt_comment")).sendKeys("This is a Comment");
        // Button click appoinment
        //button[@id="btn-book-appointment"]
        driver.findElement(By.id("btn-book-appointment")).click();

        // Verify the Booking Appoinment is done
       // String ActualTitle = String.valueOf(driver.findElement(By.xpath("//p[@id=\"comment\"]")));
        String ActualTitle = driver.findElement(By.tagName("h2")).getText();
        String ExpectedTitle = "Appointment Confirmation";
        Assert.assertEquals(ExpectedTitle, ActualTitle);

        // Print the Receipt
        List<WebElement> Appoinment = driver.findElements(By.xpath("//div[@class=\"row\"]"));
        for (WebElement element:Appoinment){
            System.out.println(element.getText());
        }

        System.out.println("Successfully Executed !!!");
        // Browser Quit
        driver.quit();





    }
}
