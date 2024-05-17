package big.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompressPage extends BasePage {

    private final By compressSectionLocator = By.xpath("//div[contains(@class, 'sc-12awoku-3') and text()='Compress']");

    public CompressPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCompressPage() {
        return getElement(compressSectionLocator).isDisplayed();
    }
}
