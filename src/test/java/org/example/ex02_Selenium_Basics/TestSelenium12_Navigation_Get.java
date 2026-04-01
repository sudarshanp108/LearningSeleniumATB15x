package org.example.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium12_Navigation_Get {
    @Test
    public void test_selenium01() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        //  Use Navigation Commands
        // driver.get("url") -> Navigate to a URL
        driver.navigate().to("https://firefox.com");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
    }
}
