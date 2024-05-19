package big.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {

    private final By homeSectionLocator = By.xpath("//div[contains(@class, 'sc-12awoku-3') and text()='Home']");

    // Buttons to navigate to the website pages
    private final By accountButtonLocator = By.xpath("//button[contains(., 'Account')]");
    private final By compressButtonLocator = By.xpath("//button[contains(., 'Compress')]");
    private final By convertButtonLocator = By.xpath("//button[contains(., 'Convert')]");

    private final By trailBannerLocator = By.xpath("/html/body/div[1]/div/div[3]/div/div/div[1]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePage() {
        return getElement(homeSectionLocator).isDisplayed();
    }

    public void hideTrailBanner() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].style.display='none'", getDriver().findElement(trailBannerLocator));

        Thread.sleep(3000);
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

    public void hoverOverConvertButton() {
        Actions actions = new Actions(getDriver());
        WebElement convertButton = getDriver().findElement(convertButtonLocator);
        actions.moveToElement(convertButton).perform();
    }

}
