package org.example.ex07_Selenium_Waits;

import org.example.CommonToAll;
import org.example.WaitHelpers;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.example.WaitHelpers.checkVisibility;
import static org.example.WaitHelpers.waitImplicitWait;

public class TestSeleniumExplicit_MiniProject5 extends CommonToAll {


    @Description("Verify  makemytrip opens with modal")
    @Test
    public void testCloseModal() {
        WebDriver driver = new ChromeDriver();
        openBrowser(driver,"https://www.makemytrip.com/");
        waitForVisibility(driver,"//textarea", "//span[@data-cy='closeModal']");
        clickElementFound("//span[@data-cy='closeModal']");

        // static -
        WaitHelpers.waitJVM(10000);
        closeBrowser(driver);
    }



}
