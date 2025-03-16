package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) { super(driver); }

    //Elements
    @FindBy(id = "user-name")
    WebElement UsernameField;

    @FindBy(id = "password")
    WebElement PasswordField;

    @FindBy(id = "login-button")
    WebElement LoginButton;

    //Methods
    public void navigate() { driver.get("https://saucedemo.com"); }

    public boolean pageDisplayed() { return driver.getCurrentUrl().contains("saucedemo.com"); }

    public void enterUsername(String username) {
        UsernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        PasswordField.sendKeys(password);
    }

    public void clickLogin() { LoginButton.click(); }
}
