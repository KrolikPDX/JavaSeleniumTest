package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
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
        loginPage.navigate();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        //Add item to cart, click checkout
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart("Sauce Labs Backpack");
        inventoryPage.clickCheckoutButton();

        //Click checkout button in cart page
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();

        //Enter order details, finish checkout
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterFirstName("asdf");
        checkoutPage.enterLastName("asdf");
        checkoutPage.enterPostalCode("123456");
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishButton();

        //Validate success
        Assert.assertTrue(checkoutPage.successCheckoutImageDisplayed(), "Success checkout image was not displayed");
        Assert.assertEquals("Thank you for your order!", checkoutPage.getThankYouHeaderText(), "Unexpected thank you text found on checkout page");
    }

    @Test
    void validateLoginPageDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();

        Assert.assertTrue(loginPage.pageDisplayed(), "Login page url did not match what's expected");
    }

    @AfterTest
    void AfterTest() {
        driver.close();
    }
}
