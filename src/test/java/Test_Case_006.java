import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

//Print all the <a> Tags from the website

public class Test_Case_006 {
    @Test
    @Description("WGoing to Automate the Login Page using Selenium")
    public void Test_Case_Login() {

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");

        // Open Chrome Browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        List<WebElement> all_tags = driver.findElements(By.tagName("a"));
        for(WebElement element:all_tags){
            System.out.println(element.getText());
        }
        driver.quit();

    }
}
