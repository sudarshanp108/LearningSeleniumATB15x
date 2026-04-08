package org.example.Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task04_WebTables {

    @Test
    public void test_webtables() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();

        String userdata[][] = {
                {"John", "marin", "john@ma.com", "20", "20000", "Administration"},
                {"Mary", "joy", "mary@joy.com", "22", "25000", "Administration"},
                {"Saman", "bruce", "saman@bruc.com", "25", "28000", "IT"},
                {"Madhu", "gouda", "madhu@gd.com", "28", "30000", "HR"},
                {"Brayn", "demore", "bryan@more.com", "30", "35000", "Legal"}
        };

        for (String[] user: userdata) {
//            WebElement table = driver.findElement(By.xpath("//div[@class=\"web-tables-wrapper\"]"));

            WebElement input_button = driver.findElement(By.xpath("//button[@id=\"addNewRecordButton\"]"));
            input_button.click();

        driver.findElement(By.id("firstName")).sendKeys(user[0]);
        driver.findElement(By.id("lastName")).sendKeys(user[1]);
        driver.findElement(By.id("userEmail")).sendKeys(user[2]);
        driver.findElement(By.id("age")).sendKeys(user[3]);
        driver.findElement(By.id("salary")).sendKeys(user[4]);
        driver.findElement(By.id("department")).sendKeys(user[5]);

        // click submit
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//tr[3]/td[6]"));
        System.out.println("Legal Department");

        driver.findElement(By.id("delete-record-3")).click();
        System.out.println("Row deleted successfully");

        driver.quit();
}
}
