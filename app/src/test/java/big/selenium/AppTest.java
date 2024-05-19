package big.selenium;

import org.junit.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import java.net.URL;
import java.util.Collection;
import java.net.MalformedURLException;

import big.selenium.pages.*;

public class AppTest {

    private WebDriver driver;

    private BasePage basePage;
    private LoginPage loginPage;
    private HomePage homePage;
    private AccountPage accountPage;
    private CompressPage compressPage;
    private StaticPage staticPage;

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        this.driver.manage().window().maximize();

        // Configure browser options
        options.addArguments("--headless");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking"); 
    }

    @Test
    public void basicSeleniumTest() throws InterruptedException {

        // Instantiating the pages
        basePage = new BasePage(this.driver);;
        homePage = new HomePage(driver);
        accountPage = new AccountPage(this.driver);
        compressPage = new CompressPage(this.driver);
        staticPage = new StaticPage(driver);

        // Opening the SmallPDF website
        basePage.openMainWebsite();

        // Fill simple form and send -> Login
        loginPage = new LoginPage(this.driver);
        loginPage.login();

        homePage.getPageTitle();
        homePage.hideTrailBanner();
        homePage.openAccountPage();

        if (accountPage.isAccountPage()) {
            
            System.out.println("Current page : Account page");

            // Form sending with user
            accountPage.updateUserName();

            // Update VAT number
            accountPage.updateVatNumber();

            // TODO: Fix the drop down selection
            // Update profile settings
            // accountPage.updateProfileSettings();

        } else {
            System.out.println("Trying to exectue an account method from a different page. Ignoring...");
        }

        // Static page test
        homePage.openCompressPage();

        if (compressPage.isCompressPage()) {
            System.out.println("Current page : Compress page");
        } else {
            System.out.println("Trying to exectue a compress method from a different page. Ignoring...");
        }

        // Multiple static page test
        Collection<String> pageUrls = StaticPage.pageUrls();

        for (String url : pageUrls) {
            staticPage.testPageLoadsCorrectly(url);
        }

        Thread.sleep(1000);

        homePage.hoverOverConvertButton();

        Thread.sleep(1000);

        loginPage.logout();
    }

    @Test
    public void advancedSeleniumTest() {
        // Advanced test
    }

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
} 