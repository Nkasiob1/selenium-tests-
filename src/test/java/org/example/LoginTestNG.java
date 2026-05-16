package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestNG {

    WebDriver driver;

    // This runs BEFORE every test
    // Sets up the browser
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        System.out.println("Browser opened");
    }

    // TEST 1 - Valid login
    @Test
    public void testValidLogin() {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        WebElement loginBtn = driver.findElement(By.id("submit"));
        loginBtn.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("logged-in-successfully"),
                "Login failed - URL did not change");

        System.out.println("TEST 1 PASSED - Valid login successful");
    }

    // TEST 2 - Wrong password
    @Test
    public void testWrongPassword() {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("wrongpassword");

        WebElement loginBtn = driver.findElement(By.id("submit"));
        loginBtn.click();

        WebElement error = driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed(),
                "Error message not shown for wrong password");

        System.out.println("TEST 2 PASSED - Wrong password correctly rejected");
    }

    // This runs AFTER every test
    // Closes the browser
    @AfterMethod
    public void tearDown() {
        driver.quit();
        System.out.println("Browser closed");
    }
}
