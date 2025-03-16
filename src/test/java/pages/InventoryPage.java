package pages;

import library.models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InventoryPage extends BasePage {
    public InventoryPage(WebDriver driver) { super(driver); }

    //Elements
    @FindBy(css = "[data-test='shopping-cart-link']")
    WebElement CheckoutButton;

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

    public void clickCheckoutButton() {
        CheckoutButton.click();
    }

    //Helpers
    private List<Product> SetupProducts() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < AllAddToCartButtons.size(); i++) {
            Product currentProduct = new Product();
            currentProduct.setName(AllProductNames.get(i));
            currentProduct.setDescription(AllProductDescriptions.get(i));
            currentProduct.setPrice(AllProductPrices.get(i));
            currentProduct.setAddCartButton(AllAddToCartButtons.get(i));
            products.add(currentProduct);
        }
        return products;
    }
}

