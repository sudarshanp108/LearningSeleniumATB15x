package org.example.Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task06_Flipcart_Automation {

    @Test
        public void Test_Flipcart () {

            WebDriver driver = new ChromeDriver();
            driver.get("https://www.flipkart.com/search");
            driver.manage().window().maximize();

        WebElement input_search_data = driver.findElement(By.name("q"));
        input_search_data.sendKeys("macmini");

        WebElement  search = driver.findElement(By.xpath("//button/*[local-name()='svg']"));
        search.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'M1 Chip')]")));

//        List <WebElement> product_list = driver.findElements(By.xpath("//a[contains(@class, \"pIpigb\")] | //div[@class='RGLWAk']/a[3]"));
        List <WebElement> product_list = driver.findElements(By.xpath("//a[@class='pIpigb'] | div/div[@class='hZ3P6w']"));

        for (WebElement list : product_list) {
            System.out.println(list.getText());
        }

        List <WebElement> product_price = driver.findElements(By.xpath("//div[contains(text(),'₹')]"));

        for (WebElement list2 : product_price) {
            System.out.println(list2.getText());
        }

        // Finding minimum price from the list
        int minPrice = Integer.MAX_VALUE;
        for(WebElement price : product_price){
            String fullList = price.getText();
            //  System.out.println(fullList);
            fullList = fullList.replace("₹","").replace(",","");

            int value = Integer.parseInt(fullList);
            if(value < minPrice){
                minPrice = value;
            }
        }
        System.out.println("Min Price: ₹" + minPrice);

        driver.quit();
        }
    }
