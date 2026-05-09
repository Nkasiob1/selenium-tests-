package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {

    public static void main(String[] args) {

        // Start Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open the practice login website
        driver.get("https://practicetestautomation.com/practice-test-login/");

        System.out.println("Browser opened - navigating to login page");

        // Find the username field and type into it
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("student");

        System.out.println("Username entered");

        // Find the password field and type into it
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password123");

        System.out.println("Password entered");

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.id("submit"));
        loginButton.click();

        System.out.println("Login button clicked");

        // Check if login was successful
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("logged-in-successfully")) {
            System.out.println("TEST PASSED - Login successful!");
        } else {
            System.out.println("TEST FAILED - Login did not succeed");
        }

        // Close browser
        driver.quit();

        System.out.println("Browser closed - test complete");
    }
}