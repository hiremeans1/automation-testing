package com.hiremeans.automation;

import com.hiremeans.automation.utils.OsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class AsifAutomationProject {

    public static void main(String[] args) {

        OsUtils osUtils = new OsUtils();

        if (osUtils.isMacOs()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver-mac");
        } else if (osUtils.isWindowsOS()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver-windows.exe");
        }

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.get("https://www.napster.com/");

            driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[1]/header/div/div/div[2]/div/a[4]")).click();

            wait.until((presenceOfElementLocated(By.xpath("//*[@id=\"username\"]")))).sendKeys("Asifmusa");

            //driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Asifmusa");

            driver.findElement(By.cssSelector("#password")).sendKeys("Project");

            driver.findElement(By.xpath("//*[@id=\"login\"]/form/button")).click();


        } finally {

        }
    }

}
