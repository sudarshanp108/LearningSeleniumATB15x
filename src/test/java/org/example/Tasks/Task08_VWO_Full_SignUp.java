package org.example.Tasks;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Task08_VWO_Full_SignUp {

        @Test
        public void test_VWO_signup() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();

        // for Managing new window
        String parent_id = driver.getWindowHandle();
        System.out.println(parent_id);

        WebElement free_trial = driver.findElement(By.xpath("//span[contains(text(), 'Start a FREE TRIAL')]"));
        free_trial.click();

        Set <String> window_handle_ids = driver.getWindowHandles();
        for (String window : window_handle_ids) {
            driver.switchTo().window(window);
        }

        // 1st Step
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ft-page-form")));

        // Just for checking proper input  using normal email
        /* handling Assertion for normal email input
        WebElement input_email = driver.findElement(By.id("page-v1-step1-email"));
        input_email.sendKeys("anc@gmail.com");

        String error_msg = driver.getTitle();
        Assert.assertEquals(error_msg, "gmail.com doesn't look like a business domain. Please use your business email.");
        System.out.println(error_msg);  */

        WebElement input_email = driver.findElement(By.id("page-v1-step1-email"));
        input_email.sendKeys("itw33@singleuseemail.site");

        WebElement click_checkbox = driver.findElement(By.id("page-free-trial-step1-cu-gdpr-consent-checkbox"));
        click_checkbox.click();

        WebElement click_free_trial = driver.findElement(By.xpath("//button[contains(text(), 'Create a Free Trial Account')]"));
        click_free_trial.click();

        Thread.sleep(10000);

//        for Closing Modal (sometimes popups)
//        WebElement close_modal = driver.findElement(By.xpath("//button[@aria-label='Close modal']"));
//        close_modal.click();

        WebElement input_Fname = driver.findElement(By.xpath("//input[@id= 'page-v1-fname']"));
        WebElement input_Lname = driver.findElement(By.xpath("//input[@id= 'page-v1-lname']"));
        input_Fname.sendKeys("Mandy");
        input_Lname.sendKeys("Cruce");

        WebElement input_Phno  = driver.findElement(By.xpath("//input[@id= 'page-v1-pnumber']"));
        input_Phno.sendKeys("4342892894");

//        Thread.sleep(10000);

        WebElement create_account = driver.findElement(By.xpath("//button[@class=\"button btn-modal-form-submit W(100%)\"]"));
        create_account.click();

        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement skip_continue = longWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-step='free-trial-thankyou']")));
        skip_continue.click();

        WebElement skip_schedule = driver.findElement(By.xpath("//button[@data-step= 'free-trial-thankyou']"));
        skip_schedule.click();

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(., 'Continue Setup')]")));
        element.click();  // waiting for click element

        // added javascript execute for button to visible for driver
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        WebElement continue_setup = driver.findElement(By.xpath("//button[contains(., 'Continue Setup')]"));
        continue_setup.click();

        Thread.sleep(10000);

        WebElement account_save = driver.findElement(By.xpath("//button[@data-qa= 'boxasuraza']"));
        account_save.click();

        Thread.sleep(10000);

        List <WebElement> insigts_web = driver.findElements(By.xpath("//button[@data-qa = 'cunoxonoxe']//*[local-name()='svg']"));
        insigts_web.get(1).click();

//        WebElement Enter_domain = driver.findElement(By.xpath("//input[@id='platformInfo-url']"));
//        Enter_domain.sendKeys("https://mailnesia.store");

        WebElement Add_domain = driver.findElement(By.xpath("//div[@class= 'D(f) Ai(c) Mstart(a)']/button"));
        Add_domain.click();

        WebElement HTML_tag = driver.findElement(By.xpath("//a[@data-qa=\"citemocewa\" and contains(., \"HTML\")]"));
        HTML_tag.click();

        WebElement copy_code = driver.findElement(By.xpath("//button[@data-qa=\"xugejexijo\"]"));
        copy_code.click();

        Actions actions = new Actions(driver);
        String expected_text = copy_code.getAttribute("textContent"); // gives the full text

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");
        WebElement paste_desc_box = driver.findElement(By.xpath("//*[@name='q']"));
        paste_desc_box.click();

        // pasting copied content
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

        String paste_text = paste_desc_box.getAttribute("value");

        if(paste_text.contains("visualwebsiteoptimizer")) {
            System.out.println("Test exe successfully");
        } else {
            System.out.println("Failed to copy");
        }



    }
}
