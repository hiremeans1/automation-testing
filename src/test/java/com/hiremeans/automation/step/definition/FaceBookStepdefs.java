package com.hiremeans.automation.step.definition;

import com.hiremeans.automation.utils.OsUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class FaceBookStepdefs {

    OsUtils osUtils = new OsUtils();

    WebDriver driver = new ChromeDriver();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @Given("fill up all the required fields to create an account")
    public void enterAllTheRequiredInformationToCreateAnAccount() {

        if(osUtils.isMacOs()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver-mac");
        }else if(osUtils.isWindowsOS()){
            System.setProperty("webdriver.chrome.driver", "chromedriver-windows.exe");
        }

        driver.get("https://www.facebook.com/"); // Facebook site
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
        monthSelector.selectByValue("8");

        WebElement dayElement = driver.findElement(By.cssSelector("#day"));
        Select daySelector = new Select(dayElement);
        daySelector.selectByValue("10");

        WebElement yearElement = driver.findElement(By.cssSelector("#year"));
        Select yearSelector = new Select(yearElement);
        yearSelector.selectByValue("1985");

        //selecting the gender radio
        driver.findElement(By.xpath("//*[@id=\"u_0_z\"]/span[2]/label")).click();




    }

    @When("click on the sign up button")
    public void clickOnTheSignUpButton() {
    }

    @Then("should goto facebook account")
    public void shouldGotoFacebookAccount() {
    }
}
