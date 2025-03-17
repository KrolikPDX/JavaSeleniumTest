package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) { super(driver); }

    @FindBy(css = "[data-test='checkout']")
    WebElement CheckoutButton;

    public void clickCheckoutButton() {
        CheckoutButton.click();
    }
}

