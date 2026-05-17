package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    // The browser driver
    WebDriver driver;

    // PAGE ELEMENTS - where things are on the page
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.id("submit");
    By errorMessage = By.id("error");

    // Constructor - receives the driver when created
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // PAGE ACTIONS - what you can do on the page
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(errorMessage).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Combined action - fill and submit login form
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}