package com.hiremeans.automation;

import com.hiremeans.automation.utils.OsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class MultipleTabsTest {


    public static void main(String[] args) throws InterruptedException {

            OsUtils osUtils = new OsUtils();

            if(osUtils.isMacOs()) {
                System.setProperty("webdriver.chrome.driver", "chromedriver-mac");
            }else if(osUtils.isWindowsOS()){
                System.setProperty("webdriver.chrome.driver", "chromedriver-windows.exe");
            }

            WebDriver chromeDriver = new ChromeDriver();

            WebDriverWait wait = new WebDriverWait(chromeDriver,Duration.ofSeconds(35));

            chromeDriver.get("https://www.burkeandherbertbank.com/");

            //enrollNow link
            chromeDriver.findElement(By.xpath("//*[@id=\"modules\"]/div[1]/div/span/a[2]")).click();

            Thread.sleep(1000);

            //sign up button
            wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/article/div/p[4]/a"))).click();

            ArrayList<String> tabs = new ArrayList<>(chromeDriver.getWindowHandles());

            chromeDriver.switchTo().window(tabs.get(1));

             // last 4 digits of ssn
            wait.until(presenceOfElementLocated((By.xpath("//*[@id=\"ctl00_PageContent_SecurityTextBox1\"]")))).sendKeys("5493");

            // account number
            chromeDriver.findElement(By.xpath("//*[@id=\"ctl00_PageContent_SecurityTextBox2\"]")).sendKeys("2478978394");
            // branch
            chromeDriver.findElement(By.xpath("//*[@id=\"ctl00_PageContent_SecurityTextBox3\"]")).sendKeys("Alexandria, VA");

            // date acc was opened
            chromeDriver.findElement(By.xpath("//*[@id=\"ctl00_PageContent_SecurityTextBox4\"]")).sendKeys("02/02/2020");

            // amount of last deposit
            chromeDriver.findElement(By.xpath("//*[@id=\"ctl00_PageContent_SecurityTextBox5\"]")).sendKeys("2000");

            chromeDriver.switchTo().window(tabs.get(0));

            //Online bank agreement
            chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/article/div/p[5]/a[1]")).click();

            // switching back to signUp form tab after 2 secs
             Thread.sleep(2000);
            chromeDriver.switchTo().window(tabs.get(1));

            // clear out account number
            chromeDriver.findElement(By.xpath("//*[@id=\"ctl00_PageContent_SecurityTextBox2\"]")).clear();

            //wait for 2 secs
            Thread.sleep(2000);

            // account number
            chromeDriver.findElement(By.xpath("//*[@id=\"ctl00_PageContent_SecurityTextBox2\"]")).sendKeys("UWEOIRUE$$$%");

            Thread.sleep(2000);

            // click on continue
            chromeDriver.findElement(By.xpath("//*[@id=\"ctl00_PageContent_ContinueButton\"]")).click();

            //switching back to the first tab
            chromeDriver.switchTo().window(tabs.get(0));

            // click on the mobile banking agreement
            chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/article/div/p[5]/a[2]")).click();

            System.out.println(">>> current url : " +chromeDriver.getCurrentUrl());

            //consumer online bill pay agreement
            chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/article/div/p[5]/a[3]")).click();

            //Business online bill pay agreement
            chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/article/div/p[5]/a[4]")).click();

            System.out.println("--------------- stale window tabs no : " +tabs.size());

            // get the latest window handles

            tabs = new ArrayList<>(chromeDriver.getWindowHandles());

            System.out.println("------------------latest window tabs no : "+tabs.size());

            // get the current page title
            String currentPageTitle = chromeDriver.getTitle();

            System.out.println(currentPageTitle);

            Thread.sleep(2000);

            for (String tab : tabs) {

                  chromeDriver.switchTo().window(tab);
                  System.out.println("Url of tab# "+tabs.indexOf(tab)+" is : " + chromeDriver.getCurrentUrl());
                  Thread.sleep(1200);
            }

            for (String tab : tabs) {
                    chromeDriver.switchTo().window(tab);
                    if(chromeDriver.getCurrentUrl().contains(".pdf")){
                            System.out.println(chromeDriver.getPageSource());
                            chromeDriver.close();
                    }
                    Thread.sleep(1200);
            }

           chromeDriver.quit();

           System.exit(0);


    }


}
