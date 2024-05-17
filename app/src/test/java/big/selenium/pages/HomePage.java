package big.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    // Buttons to navigate to the website pages
    private final By accountButtonLocator = By.xpath("//button[contains(., 'Account')]");
    private final By compressButtonLocator = By.xpath("//button[contains(., 'Compress')]");

    // INFO: Pay attention to the text inside the account icon (it's different depending on the user's name)
    private final By accountIconLocator = By.id("__cond-22");
    private final By logoutButtonLocator = By.xpath("//span[text()='Log out']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openAccountPage() throws InterruptedException {
        getClickableElement(accountButtonLocator).click();

        Thread.sleep(1000);
    }

    public void openCompressPage() throws InterruptedException {
        getClickableElement(compressButtonLocator).click();

        Thread.sleep(1000);
    }

    public void logout() throws InterruptedException {
        getClickableElement(accountIconLocator).click();
        getClickableElement(logoutButtonLocator).click();

        Thread.sleep(1000);
    }
}
