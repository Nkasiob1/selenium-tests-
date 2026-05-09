package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NegativeLoginTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        System.out.println("=============================");
        System.out.println("   NEGATIVE LOGIN TESTS      ");
        System.out.println("=============================");

        // TEST 1 - Wrong password
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("student");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("wrongpassword");

        WebElement loginButton = driver.findElement(By.id("submit"));
        loginButton.click();

        // Check for error message
        WebElement errorMessage = driver.findElement(By.id("error"));
        if (errorMessage.isDisplayed()) {
            System.out.println("TEST 1 PASSED - Wrong password correctly rejected");
            System.out.println("Error shown: " + errorMessage.getText());
        } else {
            System.out.println("TEST 1 FAILED - Wrong password was not rejected");
        }

        // Close browser
        driver.quit();
        System.out.println("=============================");
        System.out.println("   ALL NEGATIVE TESTS DONE   ");
        System.out.println("=============================");
    }
}