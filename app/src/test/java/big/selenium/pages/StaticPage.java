package big.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Arrays;
import java.util.Collection;

public class StaticPage extends BasePage {

    private final By bodyIndicator = By.tagName("body");

    public StaticPage(WebDriver driver) {
        super(driver);
    }

    public static Collection<String> pageUrls() {
        return Arrays.asList(
            "https://smallpdf.com/pdf-converter#r=convert",
            "https://smallpdf.com/merge-pdf#r=organize-merge",
            "https://smallpdf.com/edit-pdf#r=annotate",
            "https://smallpdf.com/sign-pdf#r=app",
            "https://smallpdf.com/ai-pdf#r=app",
            "https://smallpdf.com/#s=documents"
        );
    }

    public void testPageLoadsCorrectly(String url) throws InterruptedException {
        getDriver().get(url);

        WebElement bodyElement = getElement(bodyIndicator);

        if (!bodyElement.isDisplayed()) {
            throw new AssertionError("The body element is not displayed on " + url);
        }

        getPageTitle();

        Thread.sleep(1000);

        getDriver().navigate().back();
    }
}
