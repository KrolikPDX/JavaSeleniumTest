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
    //Init
    public InventoryPage(WebDriver driver) {
        super(driver);  // Calling BasePage's constructor
    }

    //region Elements + Selectors
    @FindBys(value = @FindBy(css = "[data-test='inventory-item-name']"))
    List<WebElement> allProductNames;

    @FindBys(value = @FindBy(css = "[data-test='inventory-item-desc']"))
    List<WebElement> allProductDescriptions;

    @FindBys(value = @FindBy(css = "[data-test='inventory-item-price']"))
    List<WebElement> allProductPrices;

    @FindBys(value = @FindBy(css = "[data-test*='add-to-cart']"))
    List<WebElement> allAddToCartButtons;

    Stream<Product> AllProducts = SetupProducts().stream();
    //endregion

    //region Methods
    public void AddToCart(String productName) {
        AllProducts.filter(x -> x.getName().getText().contains(productName)).findFirst().get().getAddCartButton().click();
    }
    //endregion


    //region Helper
    public List<Product> SetupProducts() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < allAddToCartButtons.size(); i++) {
            Product currentProduct = new Product();
            currentProduct.setName(allProductNames.get(i));
            currentProduct.setDescription(allProductDescriptions.get(i));
            currentProduct.setPrice(allProductPrices.get(i));
            currentProduct.setAddCartButton(allAddToCartButtons.get(i));
            products.add(currentProduct);
        }
        return products;
    }
    //endregion
}

