package org.example.ex12_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Lab_Windows_Part1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);
        driver.manage().window().maximize();

        String parent_id = driver.getWindowHandle();
        System.out.println(parent_id);
        // 66B4EA9207A91780979AB3CDACE3C68D

        WebElement link_parent = driver.findElement(By.xpath("//a[text()=\"Click Here\"]"));
        link_parent.click();

        Set <String> window_handles_ids = driver.getWindowHandles();
        // 1D338BD81AC274FF43D0698647443AD0
        //98C2024C16C8DACAC182BDDC5D7C6ED9

        for (String window: window_handles_ids) {
            System.out.println(window);
            driver.switchTo().window(window);
            if (driver.getPageSource().contains("New Window")) {
                System.out.println("Test Passed");
            }
        }
        driver.switchTo().window(parent_id);


    }
}
