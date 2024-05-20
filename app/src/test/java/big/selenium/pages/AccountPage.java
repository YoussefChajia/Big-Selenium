package big.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import big.selenium.utils.ConfigReader;

public class AccountPage extends BasePage {

    private final By accountSectionLocator = By.xpath("//div[contains(@class, 'sc-12awoku-3') and text()='Account']");

    // Updating the user first name and last name
    private final By profileButtonLocator = By.xpath("//button[contains(., 'Profile')]");
    private final By firstNameFieldLocator = By.xpath("(//input[@type='text'])[1]");
    private final By lastNameFieldLocator = By.xpath("(//input[@type='text'])[2]");
    private final By nameSaveButtonLocator = By.xpath("//div[@class='sc-19ykhrs-2 hSGgpJ']//button[.//div[contains(text(), 'Save changes')]]");

    // Sending a form: filling a text field for the VAT number
    private final By companyInfoButtonLocator = By.xpath("//button[contains(., 'Company Information')]");
    private final By addVatNumberButtonLocator = By.xpath("//div[text()='VAT Number']/following-sibling::div[@class='sc-11wj96s-0 ewGVvF']");
    private final By vatNumberFieldLocator = By.xpath("//div[text()='VAT Number']/preceding-sibling::input[@type='text']");
    private final By vatNumberSaveButtonLocator = By.xpath("//button[contains(@class, '__rt9NE') and contains(., 'Update')]");

    // Updating the profile settings
    public static final By iNeedSmallDropDownLocator = By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div[1]/button");
    public static final By mainUseDropDownLocator = By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div[2]/button");
    public static final By industryDropDownLocator = By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div[3]/button");
    public static final By departmentDropDownLocator = By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div[4]/button");
    public static final By companySizeDropDownLocator = By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div[5]/button");
    private final By profileSaveButtonLocator = By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div[6]/button");
    
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountPage() {
        return getElement(accountSectionLocator).isDisplayed();
    }

    public void updateUserName() {

        try {

            getClickableElement(profileButtonLocator).click();

            WebElement firstNameField = getClickableElement(firstNameFieldLocator);
            WebElement lastNameField = getClickableElement(lastNameFieldLocator);

            firstNameField.click();
            firstNameField.clear();
            Thread.sleep(1000);
            firstNameField.sendKeys(ConfigReader.getFirstName());

            lastNameField.click();
            lastNameField.clear();
            Thread.sleep(1000);
            lastNameField.sendKeys(ConfigReader.getLastName());

            getClickableElement(nameSaveButtonLocator).click();

            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateVatNumber() {

        try {

            getClickableElement(companyInfoButtonLocator).click();
            getClickableElement(addVatNumberButtonLocator).click();

            WebElement vatNumberField = getClickableElement(vatNumberFieldLocator);
            
            vatNumberField.click();
            vatNumberField.clear();
            Thread.sleep(1000);
            vatNumberField.sendKeys(ConfigReader.getVatNumber());

            getClickableElement(vatNumberSaveButtonLocator).click();

            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProfileSettings() {

        try {

            getClickableElement(profileButtonLocator).click();

            selectDropDownOption(iNeedSmallDropDownLocator, "My own business");
            selectDropDownOption(mainUseDropDownLocator, "Quickly process files for administrative tasks");
            selectDropDownOption(industryDropDownLocator, "Education");
            selectDropDownOption(departmentDropDownLocator, "Design");
            selectDropDownOption(companySizeDropDownLocator, "Only me");

            getClickableElement(profileSaveButtonLocator).click();

            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
