package big.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import big.selenium.utils.ConfigReader;


public class LoginPage extends BasePage {
    
    private WebDriver driver;

    private final By loginLinkIndicator = By.cssSelector("button.sc-11drgl3-0.sc-5esrdz-1.ireDIG.gCzPow");
    private final By emailIndicator = By.cssSelector("input[type='email']");
    private final By passwordIndicator = By.cssSelector("input[type='password']");
    private final By loginButtonIndicator = By.xpath("//button[contains(., 'Log in')]");

    // private final By loginSuccessIndicator = By.xpath("//div[@class='sc-12awoku-3 eXHubu']");
    // private final By loginFailIndicator = By.xpath("//div[@class='sc-9efc1w-0 jdTgrN']");

    private final By accountButtonLocator = By.xpath("/html/body/div[1]/div[1]/div[1]/header/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div[1]/div/div[1]/div/div");
    private final By logoutButtonLocator = By.xpath("/html/body/div[1]/div[1]/div[1]/header/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div[4]/div[2]/div[2]/ul/li[3]/div/span");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void login() throws InterruptedException {

        Thread.sleep(3000);

        getClickableElement(loginLinkIndicator).click();
        getElement(emailIndicator).sendKeys(ConfigReader.getUsername());
        getElement(passwordIndicator).sendKeys(ConfigReader.getPassword());
        getClickableElement(loginButtonIndicator).click();

        Thread.sleep(3000);
    }

    public void logout() throws InterruptedException {
        getClickableElement(accountButtonLocator).click();
        getClickableElement(logoutButtonLocator).click();

        Thread.sleep(3000);
    }
}
