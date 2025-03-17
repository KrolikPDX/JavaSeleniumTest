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

//Original test setup - Moved to feature files
public class CheckoutTest {
    WebDriver driver = null;

    @BeforeTest
    void BeforeTest() {
        driver = new ChromeDriver();
    }

    @Test
    void validateLoginPageDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();

        Assert.assertTrue(loginPage.pageDisplayed(), "Login page url did not match what's expected");
    }

    @Test
    void validateCheckout() {
        //Login to page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        //Add item to cart, click checkout
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart("Sauce Labs Backpack");
        inventoryPage.clickCartButton();

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
        Assert.assertEquals(checkoutPage.getThankYouHeaderText(),"Thank you for your order!", "Unexpected thank you text found on checkout page");
    }

    @AfterTest
    void AfterTest() {
        driver.close();
    }
}
