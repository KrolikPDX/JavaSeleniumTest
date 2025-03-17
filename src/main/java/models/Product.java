package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;

@Setter
@Getter
@AllArgsConstructor
public class Product {
    private WebElement name;
    private WebElement description;
    private WebElement price;
    private WebElement addCartButton;
}