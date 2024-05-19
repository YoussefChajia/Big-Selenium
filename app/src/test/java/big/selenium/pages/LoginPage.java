package big.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import big.selenium.utils.ConfigReader;


public class LoginPage extends BasePage {
    
    private WebDriver driver;

    private final By loginLinkIndicator = By.cssSelector("button.sc-11drgl3-0.sc-5esrdz-1.ireDIG.gCzPow");
    private final By emailIndicator = By.cssSelector("input[type='email']");
    private final By passwordIndicator = By.cssSelector("input[type='password']");
    private final By loginButtonIndicator = By.xpath("//button[contains(., 'Log in')]");

    // private final By loginSuccessIndicator = By.xpath("//div[@class='sc-12awoku-3 eXHubu']");
    // private final By loginFailIndicator = By.xpath("//div[@class='sc-9efc1w-0 jdTgrN']");

    private final By homeTextLocator = By.xpath("//div[contains(@class, 'sc-12awoku-3') and text()='Home']");
    private final By accountButtonLocator = By.xpath("//*[@id='__cond-33']/div/div[1]/div/div");
    private final By logoutButtonLocator = By.xpath("//span[text()='Log out']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void login() throws InterruptedException {

        getClickableElement(loginLinkIndicator).click();
        getElement(emailIndicator).sendKeys(ConfigReader.getUsername());
        getElement(passwordIndicator).sendKeys(ConfigReader.getPassword());
        getClickableElement(loginButtonIndicator).click();

        getClickableElement(accountButtonLocator).click();

        Thread.sleep(9000);

        if (this.driver.findElements(homeTextLocator).size() > 0) {
            System.out.println("Login successful");
        } else {
            throw new AssertionError("Login failed");
        }
    }

    public void logout() throws InterruptedException {
        getClickableElement(accountButtonLocator).click();
        getClickableElement(logoutButtonLocator).click();

        if (this.driver.findElements(homeTextLocator).size() > 0) {
            throw new AssertionError("Logout failed");
        } else {
            System.out.println("Logout successful");
        }

        Thread.sleep(1000);
    }
}
