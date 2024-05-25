package org.example.Data_Driven_Testing;

import io.qameta.allure.Description;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;



import java.io.IOException;

public class data_Driven {

    WebDriver driver;

    @BeforeClass
    // @Description("Open Chrome and initialize WebDriver")
    public void setup() {
        //WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test(dataProvider = "Login Data")
    public void test_Driven(String emails, String Passwords, String Expected_Result) throws InterruptedException {
        driver.get("https://app.vwo.com");

        WebElement email_tests = driver.findElement(By.id("login-username"));
        email_tests.clear();
        email_tests.sendKeys(emails);


        WebElement password_tests = driver.findElement(By.id("login-password"));
        password_tests.clear();
        password_tests.sendKeys(Passwords);

        driver.findElement(By.id("js-login-btn")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (Expected_Result.equalsIgnoreCase("Valid")) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String actualTitle = driver.findElement(By.xpath("//h1[@data-qa=\"page-heading\"]")).getText();
            String ExpectedTitle = "Dashboard";
            Assert.assertEquals(actualTitle, ExpectedTitle);

            Thread.sleep(5000);
            driver.quit();

        } else {
            WebElement errorMessage = driver.findElement(By.xpath("//div[@id=\"js-notification-box-msg\"]"));
            Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be displayed for invalid login.");
        }

    }

//    @DataProvider(name = "Login Data")
//    public Object[][] loginData() {
//        return new Object[][]{
//                {"SomePassword", "validPassword", "Invalid"},
//                {"invalid@example.com", "invalidPassword", "Invalid"},
//                {"empty@example.com", "", "Invalid"},
//                {"valid@example.com", "KvUtCe9@usZG3pZ", "Valid"}
//        };
//    }

    @DataProvider(name = "Login Data")
    public Object[][] testDataExcelFile() throws IOException {
        String excelFileLocation = "src/test/resources/DataTests.xlsx";
        return ExcelUtils.getExcelData(excelFileLocation, "Data");
    }

   // @Description("Close Browser")

}
