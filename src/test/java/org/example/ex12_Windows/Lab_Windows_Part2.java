package org.example.ex12_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Lab_Windows_Part2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        String URL = "https://app.vwo.com/#/login";
//        driver.get(URL);
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();

        String parent_id = driver.getWindowHandle();
//        System.out.println(parent_id);

        WebElement link_parent = driver.findElement(By.xpath("//li/a/span[contains(text(), 'Start a FREE TRIAL')]"));
//        WebElement link_parent = driver.findElement(By.partialLinkText("Start a free trial"));
        link_parent.click();

        Set <String> window_handle_ids = driver.getWindowHandles();

        for (String window: window_handle_ids) {
//            System.out.println(window);
            if (!window.equalsIgnoreCase(parent_id)) {
                driver.switchTo().window(window);
            }
        }
    }
}
