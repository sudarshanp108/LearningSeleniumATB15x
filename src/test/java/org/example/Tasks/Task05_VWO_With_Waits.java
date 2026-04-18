package org.example.Tasks;

import org.example.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task05_VWO_With_Waits extends CommonToAll {

    @Test
    public void test_VWO() {
        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://app.vwo.com/#/login");

        WebElement input_email = driver.findElement(By.id("login-username"));
        WebElement input_password = driver.findElement(By.id("login-password"));
        WebElement signin = driver.findElement(By.id("js-login-btn"));

        input_email.sendKeys("admin@admin.com");
        input_password.sendKeys("admin");
        signin.click();

//        waitForAlert(driver, 10);
        waitForVisibility(driver, "//div[@class=\"notification-box-description\"]", "Your email, password, IP address or location did not match");

//        closeBrowser(driver);
        driver.quit();
    }
}
