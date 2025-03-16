package pages;

import library.models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) { super(driver); }

    @FindBy(css = "[data-test='checkout']")
    WebElement CheckoutButton;

    public void clickCheckoutButton() {
        CheckoutButton.click();
    }
}

