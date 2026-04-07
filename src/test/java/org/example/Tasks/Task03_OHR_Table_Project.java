package org.example.Tasks;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task03_OHR_Table_Project {
    @Owner("Sudarshan")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("https://awesomeqa.com/hr/web/index.php/auth/login")
    @Description("Verify that the user is successfully Login and able to delete 1st terminated employee.")
    @Test
    public void test_OHR_table() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("Hacker@4321");
        driver.findElement(By.xpath("//button")).click();

        Thread.sleep(3000);
        List<WebElement> terminated_emp = driver.findElements(By.xpath("//div[contains(text(),'Terminated')]"));
        WebElement terminated_emp_name =driver.findElement(By.xpath("//div[contains(text(),'Terminated')]/../preceding-sibling::div[3]"));
        WebElement delete_1st_employee = driver.findElement(By.xpath("(.//div[text()='Terminated']/ancestor::div[@role='row']//i[contains(@class,'trash')])[1]"));

        System.out.println(terminated_emp_name.getText());
        WebElement DeleteFirst_terminatedEmp = driver.findElement(By.xpath( "//div[text()=\"Terminated\"]/following::i[1]"));
        DeleteFirst_terminatedEmp.click();


        WebElement deletePopup=driver.findElement(By.xpath("//p[@class=\"oxd-text oxd-text--p oxd-text--card-body\"]"));
        Thread.sleep(2000);
        String Delete_Popup=deletePopup.getText();
        Assert.assertEquals(Delete_Popup,"The selected record will be permanently deleted. Are you sure you want to continue?");

        driver.quit();
    }
}
