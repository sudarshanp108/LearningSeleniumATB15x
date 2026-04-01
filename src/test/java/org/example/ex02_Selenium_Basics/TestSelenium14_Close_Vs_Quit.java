package org.example.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium14_Close_Vs_Quit {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");


        Thread.sleep(10000); // must add throws InterruptedException to main method


//         driver.close();

        //        driver.close();
//        // Close - will close the current tab, not the session (not the all tabs)
//        // session id != null

        driver.quit();
        // It will close all the tabs. - session id == null
    }
}
