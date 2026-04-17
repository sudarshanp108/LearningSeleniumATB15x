package org.example.ex10_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Lab_ActionClass_MakeMyTRIP_Ex {

    @Test
    public void test_makemytrip() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));

        WebElement modal_close = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        modal_close.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-cy=\"mmtLogo\"]")));

        // just to remove the transparent layer.
        WebElement background_element = driver.findElement(By.tagName("body"));
        background_element.click();

        Thread.sleep(2000);

        WebElement origin = driver.findElement(By.id("fromCity"));
        Actions actions = new Actions(driver);

        actions.moveToElement(origin).click().build().perform();
        Thread.sleep(2000);

        actions.moveToElement(origin).click().sendKeys("IXC").build().perform();

        Thread.sleep(2000);

//        List <WebElement> list_auto_complete_dropdown = driver.findElements(By.xpath("//div/ul[@role=\"listbox\"]/li[1]"));
//        list_auto_complete_dropdown.get(0).click();

        // other way of finding fromCity by dropdown
        try {
            List<WebElement> list_auto_complete_dropdown = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
            for (WebElement suggestions : list_auto_complete_dropdown) {
                if (suggestions.getText().contains("Chandigarh")) {
                    suggestions.click();
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Thread.sleep(3000);

        WebElement destination = driver.findElement(By.xpath("//input[@data-cy='toCity']"));
        actions.moveToElement(destination).sendKeys("DEL").build().perform();

        WebDriverWait waitDest = new WebDriverWait(driver, Duration.ofSeconds(10));
//        By suggestionListPath = By.xpath("//div[@role='listbox']/div[1]");
        waitDest.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']/div[1]")));

        try {
            List<WebElement> list_auto_complete = driver.findElements(By.id("toCity"));

            for (WebElement e : list_auto_complete) {
                if (e.getText().contains("New Delhi")) {
                    e.click();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}