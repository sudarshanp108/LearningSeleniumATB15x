package org.example.ex08_SVG_Elements;

import io.qameta.allure.Description;
import org.example.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Lab_SVG {
    @Description("Verify that on search results with svg icon are visible")
    @Test
    public void test_flipcart_svg_icon() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/search");
        driver.manage().window().maximize();

        WebElement input_search = driver.findElement(By.name("q"));
        input_search.sendKeys("macmini");

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));
        svgElements.get(0).click();

        WaitHelpers.checkVisibility(driver,By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));

        List <WebElement> titleresults = driver.findElements(By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MP')]/div/a[2]"));
        for (WebElement title : titleresults) {
            System.out.println(title.getText());
        }

        WaitHelpers.waitJVM(5000);
        driver.quit();
    }
}
