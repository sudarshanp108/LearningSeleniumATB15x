package org.example.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestSelenium09_Assersion_TestNG {

    @Test
    public void test_selenium_01() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        // TestNG
//        Assert.assertEquals(driver.getCurrentUrl(), "\"https://www.google.com\"");
//        Assert.assertEquals(driver.getTitle(),"Google");

        // AssertJ
        assertThat(driver.getCurrentUrl()).isNotBlank()
                .isNotEmpty()
                .isNotNull()
                .isEqualTo("google");

        driver.quit();

    }
}
