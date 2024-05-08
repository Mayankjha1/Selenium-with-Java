package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Checkbox_Handle {
    @Test
    @Description("Handling Checkbox")
    public void Test_Case_Login() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> Check_box = driver.findElements(By.xpath("//form[@id=\"checkboxes\"]"));
        WebElement web = Check_box.get(0);
        web.click();

        driver.quit();
    }
}
