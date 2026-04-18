package org.example.ex13_Iframe;

import org.example.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestFrame2{
    @Test
    public void test_frame() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");

        IframeUtils frameUtils = new IframeUtils();

        frameUtils.switchToFrame("result");
        driver.findElement(By.id("username")).sendKeys("Pramod");
        frameUtils.switchToDefault();
    }
}
