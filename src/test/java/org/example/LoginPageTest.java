package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Create the page object
        loginPage = new LoginPage(driver);
        System.out.println("Browser opened");
    }

    @Test
    public void testValidLogin() {
        // Using page object - clean and readable
        loginPage.login("student", "Password123");

        Assert.assertTrue(
                loginPage.getCurrentUrl().contains("logged-in-successfully"),
                "Valid login failed"
        );
        System.out.println("TEST 1 PASSED - Valid login successful");
    }

    @Test
    public void testWrongPassword() {
        loginPage.login("student", "wrongpassword");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(
                error.contains("Your password is invalid"),
                "Error message not shown"
        );
        System.out.println("TEST 2 PASSED - Wrong password rejected");
        System.out.println("Error message: " + error);
    }

    @Test
    public void testWrongUsername() {
        loginPage.login("wronguser", "Password123");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(
                error.contains("Your username is invalid"),
                "Error message not shown for wrong username"
        );
        System.out.println("TEST 3 PASSED - Wrong username rejected");
        System.out.println("Error message: " + error);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        System.out.println("Browser closed");
    }
}