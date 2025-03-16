package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutTest {
    WebDriver driver = null;

    @BeforeTest
    void BeforeTest() {
        driver = new ChromeDriver();
    }

    @Test
    void ValidateCheckout() {
        //Login to page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo("https://saucedemo.com");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.AddToCart("Sauce Labs Backpack");
    }

    @Test
    void ValidatePageLoad() {

    }

    @AfterTest
    void AfterTest() {
        driver.close();
    }
}
