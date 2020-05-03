package com.hiremeans.automation;

import com.hiremeans.automation.utils.OsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.InputStream;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class FirstAutomationTest {

    public static void main(String[] args) {

        OsUtils osUtils = new OsUtils();

        if(osUtils.isMacOs()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver-mac");
        }else if(osUtils.isWindowsOS()){
            System.setProperty("webdriver.chrome.driver", "chromedriver-windows.exe");
        }

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.get("https://www.facebook.com/");
            //firstName
            driver.findElement(By.xpath("//*[@id=\"u_0_m\"]")).sendKeys("Hire");
            //lastName
            driver.findElement(By.cssSelector("#u_0_o")).sendKeys("Means");
            //email
            driver.findElement(By.xpath("//*[@id=\"u_0_r\"]")).sendKeys("somename@hiremeans.com");
            //re-enter email
            wait.until((presenceOfElementLocated(By.cssSelector("#u_0_u")))).sendKeys("somename@hiremeans.com");
             //password
            driver.findElement(By.cssSelector("#u_0_w")).sendKeys("Welcome12");
            //month
            WebElement monthElement = driver.findElement(By.cssSelector("#month"));
            Select monthSelector = new Select(monthElement);
            monthSelector.selectByValue("7");

            WebElement dayElement = driver.findElement(By.cssSelector("#day"));
            Select daySelector = new Select(dayElement);
            daySelector.selectByValue("10");

            WebElement yearElement = driver.findElement(By.cssSelector("#year"));
            Select yearSelector = new Select(yearElement);
            yearSelector.selectByValue("1944");

            //selecting the gender radio
            driver.findElement(By.xpath("//*[@id=\"u_0_z\"]/span[1]/label")).click();

            //sign up
            driver.findElement(By.xpath("//*[@id=\"u_0_13\"]")).click();
            //WebElement firstResult = wait.until(presenceOfElementLocated(By.id("yui_3_10_0_1_1588433605258_242")));
           // System.out.println(firstResult);
           // driver.findElement(By.xpath("//*[@id=\"yui_3_10_0_1_1588433605258_240\"]/li[6]/div/div[1]/h3/a")).click();

        } finally {
            //driver.quit();
        }
    }
}
