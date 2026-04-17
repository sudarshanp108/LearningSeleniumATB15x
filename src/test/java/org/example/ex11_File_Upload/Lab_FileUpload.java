package org.example.ex11_File_Upload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Lab_FileUpload {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/selenium/upload.html");

        WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));
        String user_dir_path = System.getProperty("user.dir");
        System.out.println(user_dir_path);

        // if not able to upload file use File.seperator + path
        uploadFileInput.sendKeys(user_dir_path + "/src/test/java/org/example/ex11_File_Upload/data.json");
        driver.findElement(By.name("submit")).click();
    }
}
