package library.models;

import org.openqa.selenium.WebElement;

public class Product {
    private WebElement name;
    private WebElement description;
    private WebElement price;
    private WebElement addCartButton;

    public WebElement getName() {
        return name;
    }

    public void setName(WebElement element) {
        this.name = element;
    }

    public WebElement getDescription() {
        return description;
    }

    public void setDescription(WebElement description) {
        this.description = description;
    }

    public WebElement getPrice() {
        return price;
    }

    public void setPrice(WebElement price) {
        this.price = price;
    }

    public WebElement getAddCartButton() {
        return addCartButton;
    }

    public void setAddCartButton(WebElement addCartButton) {
        this.addCartButton = addCartButton;
    }
}