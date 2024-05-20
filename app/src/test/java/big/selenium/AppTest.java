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
        // Configure the Chrome browser
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
    public void smallPdfSeleniumTest() throws InterruptedException {

        try {

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

            // Getting the page title and hiding the free trail banner
            homePage.getPageTitle();
            homePage.hideTrailBanner();

            // Navigating to the account page
            homePage.openAccountPage();

            // Account page tests
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

            // Navigating to a static page
            homePage.openCompressPage();

            // Checking if the compress page loads correctly
            if (compressPage.isCompressPage()) {
                System.out.println("Current page : Compress page");
            } else {
                System.out.println("Trying to exectue a compress method from a different page. Ignoring...");
            }

            // Hover over the convert button test
            homePage.hoverOverConvertButton();

            Thread.sleep(2000);

            // Loading multiple static page test and performing a history test
            Collection<String> pageUrls = StaticPage.pageUrls();

            for (String url : pageUrls) {
                staticPage.testPageLoadsCorrectly(url);
            }

            // Logging out
            loginPage.logout();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
} 