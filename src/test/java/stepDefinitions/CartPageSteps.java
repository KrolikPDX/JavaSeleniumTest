package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.InventoryPage;

public class CartPageSteps {
    private final CartPage cartPage = new CartPage(Hooks.driver);

    @When("on cart page user clicks the checkout button")
    public void onCartPageUserClicksTheCheckoutButton() {
        cartPage.clickCheckoutButton();
    }
}
