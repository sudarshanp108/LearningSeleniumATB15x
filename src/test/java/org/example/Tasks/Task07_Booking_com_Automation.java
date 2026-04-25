package org.example.Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class Task07_Booking_com_Automation {

    @Test
    public void Booking_Website() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a5c71b0007']")));

        WebElement close_modal = driver.findElement(By.xpath("//button[@aria-label=\"Dismiss sign-in info.\"]"));
        close_modal.click();

        WebElement choose_flight_option = driver.findElement(By.xpath("//div/ul/li[2]/a"));
        choose_flight_option.click();

//        Thread.sleep(2000);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.//span[text()='Going to']]")));


        WebElement goingTo = driver.findElement(By.xpath("//button[.//span[text()='Going to']]"));
//        goingTo.click();

        // 2. Wait for the actual INPUT to appear (it's different from the button)
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actualInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Going to']]")));

        // 3. Type slowly (mimic a human)
//        for (char c : "Delhi".toCharArray()) {
//            actualInput.sendKeys(String.valueOf(c));
//            Thread.sleep(100); // Small pause between keys
//        }

//        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(goingTo).click().sendKeys("del").build().perform();

        Thread.sleep(5000);
        List <WebElement> auto_dropdown = driver.findElements(By.id(":Rj6l19dl:"));
        for (WebElement list : auto_dropdown) {
            if (list.getText().contains("DEL")) {
                list.click();
            }
        }

        driver.quit();    }
}
