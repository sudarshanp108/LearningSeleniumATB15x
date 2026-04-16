package org.example.ex09_Input_Select_Alert_Radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium_Input_Checkbox_Radios {

    @Test
    public void test_HTMLTags() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/practice.html");

        WebElement firstname = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        firstname.sendKeys("the testing academy");

        // RADIO Box
        WebElement radiobox = driver.findElement(By.id("sex-1"));
        radiobox.click();

        // CheckBox
        driver.findElement(By.id("tool-1")).click();

        WebElement options = driver.findElement(By.xpath("//select[@id='selenium_commands']/option[1]"));
        options.click();

    }
}
