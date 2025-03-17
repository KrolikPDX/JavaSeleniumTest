package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor to initialize WebDriver
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //Init @FindBy elements in a page file
    }

    //Add global page methods such as navigate or getPageTitle
    public String getPageTitle() {
        return driver.getTitle();
    }
}