package big.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import big.selenium.utils.ConfigReader;

public class HomePage extends BasePage {

    // Updating the user first name and last name
    private final By accountButtonLocator = By.xpath("//button[contains(., 'Account')]");
    private final By profileButtonLocator = By.xpath("//button[contains(., 'Profile')]");
    private final By firstNameFieldLocator = By.xpath("(//input[@type='text'])[1]");
    private final By lastNameFieldLocator = By.xpath("(//input[@type='text'])[2]");
    private final By saveButtonLocator = By.xpath("//button[contains(., 'Save changes')]");

    // Logging out
    // INFO: Pay attention to the text inside the account icon (it's different depending on the user's name)
    private final By accountIconLocator = By.xpath("//div[contains(text(), 'YC')]");
    private final By logoutButtonLocator = By.xpath("//span[text()='Log out']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void updateUserName() throws InterruptedException {
        getClickableElement(accountButtonLocator).click();
        getClickableElement(profileButtonLocator).click();

        WebElement firstNameField = getClickableElement(firstNameFieldLocator);
        WebElement lastNameField = getClickableElement(lastNameFieldLocator);

        firstNameField.click();
        firstNameField.clear();
        firstNameField.sendKeys(ConfigReader.getFirstName());

        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys(ConfigReader.getLastName());

        getClickableElement(saveButtonLocator).click();

        Thread.sleep(1000);
    }

    public void logout() throws InterruptedException {
        getClickableElement(accountIconLocator).click();
        getClickableElement(logoutButtonLocator).click();

        Thread.sleep(1000);
    }
}
