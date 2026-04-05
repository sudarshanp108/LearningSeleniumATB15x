package org.example.ex04_XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium18_MiniProject {

    @Test
    public void test_OHRM_login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

        try {
        Thread.sleep(2000);
        } catch (InterruptedException e) {
        throw new RuntimeException(e);
         }


    WebElement input_username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        WebElement input_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement button = driver.findElement(By.xpath("//Button"));
//        WebElement button = driver.findElement(By.xpath("//button[@type="submit"]"));

        input_username.sendKeys("admin");
        input_password.sendKeys("Hacker@4321");
        button.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();


    }
}
