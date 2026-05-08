package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {

    public static void main(String[] args) {

        // This starts Chrome browser automatically
        WebDriver driver = new ChromeDriver();

        // This opens Google
        driver.get("https://www.google.com");

        // This prints the page title
        System.out.println("Page title is: " + driver.getTitle());

        // This closes the browser
        driver.quit();

        System.out.println("TEST COMPLETE - Browser opened and closed successfully");
    }
}