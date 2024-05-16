package big.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import big.selenium.utils.ConfigReader;

public class BasePage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private final By bodyIndicator = By.tagName("body");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public WebElement getElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    public WebElement getClickableElement(By locator) throws InterruptedException {
        // Added for the sake of the demo to be able to see the test execution
        Thread.sleep(500);
        this.wait.until(ExpectedConditions.elementToBeClickable(locator));
        return this.driver.findElement(locator);
    }

    public void openMainWebsite() {
        this.driver.get(ConfigReader.getWebsite());
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(bodyIndicator));
    }
}