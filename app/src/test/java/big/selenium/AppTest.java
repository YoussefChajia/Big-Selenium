package big.selenium;

import org.junit.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import java.net.URL;
import java.net.MalformedURLException;

import big.selenium.pages.*;

public class AppTest {

    private WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        this.driver.manage().window().maximize();
    }

    @Test
    public void smallPdfTest() throws InterruptedException {

        // Opening the SmallPDF website
        new BasePage(this.driver).openMainWebsite();;
        // 1. Fill simple form and send -> Login
        new LoginPageTest(this.driver).loginTest();

        HomePage homePage = new HomePage(driver);
        AccountPage accountPage = new AccountPage(this.driver);
        CompressPage compressPage = new CompressPage(this.driver);

        homePage.openAccountPage();

        if (accountPage.isAccountPage()) {
            System.out.println("Current page : Account page");
            // 2. Form sending with user
            accountPage.updateUserName();
            // 3. Update VAT number
            accountPage.updateVatNumber();
        } else {
            System.out.println("Trying to exectue an account method from a different page. Ignoring...");
        }

        homePage.openCompressPage();

        if (compressPage.isCompressPage()) {
            System.out.println("Current page : Compress page");
        } else {
            System.out.println("Trying to exectue a compress method from a different page. Ignoring...");
        }

        homePage.logout();
    }

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}