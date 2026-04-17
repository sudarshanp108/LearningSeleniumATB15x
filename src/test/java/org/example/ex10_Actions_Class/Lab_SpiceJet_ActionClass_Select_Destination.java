package org.example.ex10_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Lab_SpiceJet_ActionClass_Select_Destination {

    @Test
    public void test_spicejet() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

        WebElement origin = driver.findElement(By.xpath("//div/div[@data-testid=\"to-testID-origin\"]/div"));
        WebElement destination = driver.findElement(By.xpath("//div/div[@data-testid=\"to-testID-destination\"]/div"));

        Actions actions = new Actions(driver);
        actions.moveToElement(origin).click().sendKeys("BLR")
                .moveToElement(destination).sendKeys("DEL")
                .build().perform();
    }
}
