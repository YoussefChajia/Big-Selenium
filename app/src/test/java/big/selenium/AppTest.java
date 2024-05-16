package big.selenium;

import org.junit.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
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

        new BasePage(this.driver).openMainWebsite();;

        new LoginPageTest(this.driver).loginTest();

        HomePage homePage = new HomePage(this.driver);
        homePage.updateUserName();
        homePage.logout();
    }

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
