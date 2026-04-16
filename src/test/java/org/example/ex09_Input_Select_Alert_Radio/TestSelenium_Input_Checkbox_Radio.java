package org.example.ex09_Input_Select_Alert_Radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestSelenium_Input_Checkbox_Radio {

    @Test
    public void test_select() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
//        select.selectByIndex(1);
//        select.selectByValue("2"); // passing value 2 from Xpath from inspect
//        select.deSelectByContainsVisibleText("Option 1");  // through UnsupportedOperationException
        select.selectByVisibleText("Option 2");

        driver.quit();

    }
}
