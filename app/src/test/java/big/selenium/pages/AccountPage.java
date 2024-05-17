package big.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import big.selenium.utils.ConfigReader;

public class AccountPage extends BasePage {

    // Get this element with class name and text using xpath <div class="sc-12awoku-3 eXHubu">Compress</div>
    private final By accountSectionLocator = By.xpath("//div[contains(@class, 'sc-12awoku-3') and text()='Account']");


    // Updating the user first name and last name
    private final By profileButtonLocator = By.xpath("//button[contains(., 'Profile')]");
    private final By firstNameFieldLocator = By.xpath("(//input[@type='text'])[1]");
    private final By lastNameFieldLocator = By.xpath("(//input[@type='text'])[2]");
    private final By saveButtonLocator = By.xpath("//button[contains(., 'Save changes')]");

    // Sending a form: filling a text field for the VAT number
    private final By companyInfoButtonLocator = By.xpath("//button[contains(., 'Company Information')]");
    private final By addVatNumberButtonLocator = By.xpath("//div[text()='VAT Number']/following-sibling::div[@class='sc-11wj96s-0 ewGVvF']");
    private final By vatNumberFieldLocator = By.xpath("//div[text()='VAT Number']/preceding-sibling::input[@type='text']");
    private final By vatNumberSaveButtonLocator = By.xpath("//button[contains(@class, '__rt9NE') and .//div[text()='Update']]");

    public AccountPage(WebDriver driver) throws InterruptedException {
        super(driver);
    }

    public boolean isAccountPage() {
        return getElement(accountSectionLocator).isDisplayed();
    }

    public void updateUserName() throws InterruptedException {

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


    public void updateVatNumber() throws InterruptedException {
        getClickableElement(companyInfoButtonLocator).click();
        getClickableElement(addVatNumberButtonLocator).click();

        WebElement vatNumberField = getClickableElement(vatNumberFieldLocator);
        
        vatNumberField.click();
        vatNumberField.clear();
        vatNumberField.sendKeys(ConfigReader.getVatNumber());

        getClickableElement(vatNumberSaveButtonLocator).click();

        Thread.sleep(1000);
    }
}
