package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) { super(driver); }

    //Elements
    @FindBy(css = "[data-test='firstName']")
    WebElement FirstNameField;

    @FindBy(css = "[data-test='lastName']")
    WebElement LastNameField;

    @FindBy(css = "[data-test='postalCode']")
    WebElement PostalCodeField;

    @FindBy(css = "[data-test='continue']")
    WebElement ContinueButton;

    @FindBy(css = "[data-test='finish']")
    WebElement FinishButton;

    @FindBy(css = "[data-test='complete-header']")
    WebElement ThankYouHeader;

    @FindBy(css = "[data-test='pony-express']")
    WebElement CheckoutImage;

    //Methods
    public void enterFirstName(String firstName) {
        FirstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        LastNameField.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        PostalCodeField.sendKeys(postalCode);
    }

    public void clickContinueButton() {
        ContinueButton.click();
    }

    public void clickFinishButton() {
        FinishButton.click();
    }

    public String getThankYouHeaderText() {
        return ThankYouHeader.getText();
    }

    public boolean successCheckoutImageDisplayed() {
        return CheckoutImage.isDisplayed();
    }
}

