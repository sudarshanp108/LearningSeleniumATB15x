package org.example.ex03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium17_MiniProject_TagNAme {

    @Test
    public void vwo_free_trial_error_verify() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://app.vwo.com");
//
//        WebElement tag_partial_match = driver.findElement(By.partialLinkText("trial"));
//        tag_partial_match.click();

        WebDriver driver = new ChromeDriver();
        driver.get("https://vwo.com/free-trial/");

        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));

        WebElement email = driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("abc");

        WebElement chebox_policy = driver.findElement(By.name("gdpr_consent_checkbox"));
        chebox_policy.click();

        WebElement button_create_account = driver.findElement(By.tagName("button"));
        button_create_account.click();

        //<div
        // class="C(--color-red)
        // Fz(--font-size-12) Trsp(--Op)
        // Trsdu(0.15s) Op(0)
        // invalid-input+Op(1)
        // invalid-reason">
        // A value for this field is required.</div>

        WebElement error_message = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(error_message.getText(), "The email address you entered is incorrect.");

        driver.quit();
    }
}
