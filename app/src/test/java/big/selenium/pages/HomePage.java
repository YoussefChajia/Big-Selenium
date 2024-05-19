package big.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By homeSectionLocator = By.xpath("//div[contains(@class, 'sc-12awoku-3') and text()='Home']");

    // Buttons to navigate to the website pages
    private final By accountButtonLocator = By.xpath("//button[contains(., 'Account')]");
    private final By compressButtonLocator = By.xpath("//button[contains(., 'Compress')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePage() {
        return getElement(homeSectionLocator).isDisplayed();
    }

    public void openAccountPage() throws InterruptedException {
        getClickableElement(accountButtonLocator).click();

        Thread.sleep(1000);
    }

    // Opening static pages
    public void openCompressPage() throws InterruptedException {
        getClickableElement(compressButtonLocator).click();

        Thread.sleep(1000);
    }


}
