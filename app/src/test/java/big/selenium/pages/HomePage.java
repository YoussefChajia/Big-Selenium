package big.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class HomePage extends BasePage {

    // Home section locator
    private final By homeSectionLocator = By.xpath("//div[contains(@class, 'sc-12awoku-3') and text()='Home']");
    // Buttons to navigate to the website pages
    private final By accountButtonLocator = By.xpath("//button[contains(., 'Account')]");
    private final By compressButtonLocator = By.xpath("//button[contains(., 'Compress')]");
    private final By convertButtonLocator = By.xpath("//button[contains(., 'Convert')]");
    // Free trail banner
    private final By trailBannerLocator = By.xpath("/html/body/div[1]/div/div[3]/div/div/div[1]");
    // Upload button
    private final By uploadButtonLocator = By.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div/button[1]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePage() {
        return getElement(homeSectionLocator).isDisplayed();
    }

    public void hideTrailBanner() {
        try {
            
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].style.display='none'", getDriver().findElement(trailBannerLocator));
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    public void openAccountPage() {
        try {

            getClickableElement(accountButtonLocator).click();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    public void openCompressPage() {
        try {

            getClickableElement(compressButtonLocator).click();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    public void hoverOverConvertButton() {
        Actions actions = new Actions(getDriver());
        WebElement convertButton = getElement(convertButtonLocator);
        actions.moveToElement(convertButton).perform();
    }

    public void uploadFile() {
        try {

            File uploadFile = new File("/home/selenium/app/src/test/resources/test.pdf");
            WebElement fileInput = getElement(uploadButtonLocator);
            fileInput.sendKeys(uploadFile.getAbsolutePath());

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}
