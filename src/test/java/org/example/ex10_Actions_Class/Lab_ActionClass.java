package org.example.ex10_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class Lab_ActionClass {

    @Test
    public void test_Actions() {
        WebDriver driver = new ChromeDriver();
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(By.name("firstname"));

        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT).sendKeys(firstName, "Sudarshan")
                .keyUp(Keys.SHIFT).build().perform();



    }
}
