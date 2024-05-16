package big.selenium.pages;

import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import big.selenium.utils.ConfigReader;


public class LoginPageTest extends BasePage {
    
    private WebDriver driver;

    private final By loginLinkIndicator = By.cssSelector("button.sc-11drgl3-0.sc-5esrdz-1.ireDIG.gCzPow");
    private final By emailIndicator = By.cssSelector("input[type='email']");
    private final By passwordIndicator = By.cssSelector("input[type='password']");
    private final By loginButtonIndicator = By.xpath("//button[contains(., 'Log in')]");

    private final By loginSuccessIndicator = By.xpath("//div[@class='sc-12awoku-3 eXHubu']");
    private final By loginFailIndicator = By.xpath("//div[@class='sc-9efc1w-0 jdTgrN']");

    public LoginPageTest(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void loginTest() throws InterruptedException {

        getClickableElement(loginLinkIndicator).click();
        getElement(emailIndicator).sendKeys(ConfigReader.getUsername());
        getElement(passwordIndicator).sendKeys(ConfigReader.getPassword());
        getClickableElement(loginButtonIndicator).click();

        // Wait for 3 seconds to see the home page
        Thread.sleep(3000);

        if (this.driver.findElements(loginFailIndicator).size() > 0) {
            Assert.assertTrue(this.driver.findElement(loginFailIndicator).getText().equals("Wrong email or password"));
            System.out.println("Login Failed");
        } else {
            Assert.assertTrue(this.driver.findElement(loginSuccessIndicator).getText().equals("Home"));
            System.out.println("Login Successful");
        }
    }
}
