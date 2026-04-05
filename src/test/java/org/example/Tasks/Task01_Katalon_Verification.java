package org.example.Tasks;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task01_Katalon_Verification {
    @Owner("Sudarshan")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("https://katalon-demo-cura.herokuapp.com/")
    @Description("Verify that the user is successfully Login.")
    @Test
    public void Testing_Cura_app() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement appointment = driver.findElement(By.id("btn-make-appointment"));
        appointment.click();

//        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        WebElement login_username = driver.findElement(By.id("txt-username"));
        login_username.sendKeys("John Doe");

        WebElement login_password = driver.findElement(By.id("txt-password"));
        login_password.sendKeys("ThisIsNotAPassword");

        WebElement login_button = driver.findElement(By.id("btn-login"));
        login_button.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
        String h2Makeappointment = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(h2Makeappointment ,"Make Appointment");
        System.out.println("Make Appointment");

        driver.quit();
    }
}
