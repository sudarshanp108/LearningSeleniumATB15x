package org.example.Tasks;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task02_TTA_Digital_Bank {
    @Owner("Sudarshan")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("https://tta-bank-digital-973242068062.us-west1.run.app/")
    @Description("Verify that signup and funds transfer is successfully done.")
    @Test
    public void TTA_signup() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Thread.sleep(2000);

       List <WebElement> signup = driver.findElements(By.xpath("//button"));
       signup.get(1).click();

       WebElement input_user_name = driver.findElement(By.xpath("//input[@placeholder='John Doe']"));
       input_user_name.sendKeys("Martin");

       WebElement input_email_address = driver.findElement(By.xpath("//input[@type='email']"));
       input_email_address.sendKeys("demo@123.com");

       WebElement input_password = driver.findElement(By.xpath("//input[@type='password']"));
       input_password.sendKeys("123@tech");

       WebElement create_account = driver.findElement(By.xpath("//button[contains(@class,\"flex w-full\")]"));
       create_account.click();

       WebElement fund_transfer = driver.findElement(By.xpath("//button[text()='Transfer Funds']"));
               fund_transfer.click();

       WebElement input_amount = driver.findElement(By.xpath("//input[@placeholder=\"0.00\"]"));
       input_amount.sendKeys("5000");

       Thread.sleep(3000);

       WebElement continue_button = driver.findElement(By.xpath("//button[contains(@class,'bg-blue-700')]"));
       continue_button.click();

       WebElement confirm_transfer = driver.findElement(By.xpath("//button[text()='Confirm Transfer']"));
       confirm_transfer.click();

        WebElement dashboard = driver.findElement(By.xpath("//button[contains(text(), 'Dashboard')]"));
        dashboard.click();

        WebElement heading_to = driver.findElement(By.xpath("//span[contains(@class,'text-2xl')]"));
        Assert.assertTrue(heading_to.isDisplayed());
        System.out.println("TTA Bank Confirmed");



        driver.quit();
    }
}
