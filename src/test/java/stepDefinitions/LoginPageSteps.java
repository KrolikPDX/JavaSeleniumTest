package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginPageSteps {
    private final LoginPage loginPage = new LoginPage(Hooks.driver);

    @Given("user navigates to the login page")
    public void userNavigatesToLoginPage() {
        loginPage.navigate();
    }

    @When("on login page user enters valid credentials and clicks login")
    public void userOnLoginPageEntersValidCredentialsAndClicksLogin() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }
}
