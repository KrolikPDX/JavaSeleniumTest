package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.InventoryPage;

public class InventoryPageSteps {
    private final InventoryPage inventoryPage = new InventoryPage(Hooks.driver);

    @When("on inventory page user clicks add to cart button for {string}")
    public void onInventoryPageUserClicksAddToCartButtonFor(String productName) {
        inventoryPage.addToCart(productName);
    }

    @When("on inventory page user clicks on the cart icon")
    public void onInventoryPageUserClicksOnTheCartIcon() {
        inventoryPage.clickCartButton();
    }

    @Then("user is redirected to the inventory page")
    public void userIsRedirectedToTheInventoryPage() {
        Assert.assertTrue(inventoryPage.pageDisplayed());
    }

    @Then("on inventory page the cart icon displays {int} item in cart")
    public void onInventoryPageTheCartIconDisplaysItemInCart(int count) {
        Assert.assertEquals(inventoryPage.getCartCount(), count, "Cart icon count number did not match what's expected");
    }
}
