package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CheckoutPage;

public class CheckoutPageSteps {
    private final CheckoutPage checkoutPage = new CheckoutPage(Hooks.driver);

    @When("on checkout page user fills the checkout form with valid details")
    public void onCheckoutPageUserFillsTheCheckoutFormWithValidDetails() {
        checkoutPage.enterFirstName("FirstName");
        checkoutPage.enterLastName("LastName");
        checkoutPage.enterPostalCode("123456");
    }

    @When("on checkout page user clicks the continue button")
    public void onCheckoutPageUserClicksTheContinueButton() {
        checkoutPage.clickContinueButton();
    }

    @When("on checkout page user clicks the finish button")
    public void onCheckoutPageUserClicksTheFinishButton() {
        checkoutPage.clickFinishButton();
    }

    @Then("on checkout page the success icon is displayed")
    public void onCheckoutPageTheSuccessIconIsDisplayed() {
        Assert.assertTrue(checkoutPage.successCheckoutImageDisplayed(), "Success icon was not displayed on checkout page");
    }

    @Then("on checkout page the complete header contains {string}")
    public void onCheckoutPageTheCompleteHeaderContains(String headerText) {
        Assert.assertEquals(checkoutPage.getThankYouHeaderText(), headerText, "Confirmation header text did not match what's expected");
    }

    @Then("on checkout page the back home button is displayed")
    public void onCheckoutPageTheBackHomeButtonIsDisplayed() {
        Assert.assertTrue(checkoutPage.backHomeButtonDisplayed(), "Back home button was not displayed on checkout page");
    }
}
