package pages;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InventoryPage extends BasePage {
    WebDriverWait wait; //Used to wait for elements to get displayed

    public InventoryPage(WebDriver driver) { super(driver); this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); }

    //Elements
    @FindBy(css = "[data-test='shopping-cart-link']")
    WebElement CartButton;

    @FindBy(css = "[data-test='shopping-cart-badge']")
    WebElement ShoppingCartBadge; //Only displayed if >= 1 item added to cart

    @FindBys(value = @FindBy(css = "[data-test='inventory-item-name']"))
    List<WebElement> AllProductNames;

    @FindBys(value = @FindBy(css = "[data-test='inventory-item-desc']"))
    List<WebElement> AllProductDescriptions;

    @FindBys(value = @FindBy(css = "[data-test='inventory-item-price']"))
    List<WebElement> AllProductPrices;

    @FindBys(value = @FindBy(css = "[data-test*='add-to-cart']"))
    List<WebElement> AllAddToCartButtons;

    public Stream<Product> AllProducts = SetupProducts().stream();

    //Methods
    public void addToCart(String productName) {
        Product product = AllProducts.filter(x -> x.getName().getText().contains(productName)).toList().getFirst();
        product.getAddCartButton().click();
    }

    public void clickCartButton() {
        CartButton.click();
    }

    public boolean pageDisplayed() {
        return driver.getCurrentUrl().contains("inventory.html");
    }

    public int getCartCount() {
        try {
            wait.until(ExpectedConditions.visibilityOf(ShoppingCartBadge)); //Wait until element is displayed
            return Integer.parseInt(ShoppingCartBadge.getText());
        } catch(Exception _) { }
        return 0;
    }

    //Helpers
    private List<Product> SetupProducts() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < AllAddToCartButtons.size(); i++) {
            Product currentProduct = new Product(
                    AllProductNames.get(i),
                    AllProductDescriptions.get(i),
                    AllProductPrices.get(i),
                    AllAddToCartButtons.get(i));
            products.add(currentProduct);
        }
        return products;
    }
}

