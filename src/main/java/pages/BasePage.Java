package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import constants.HomeLinks;

public class BasePage {

    // yeni yorum
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    private static final Duration TIMEOUT = Duration.ofSeconds(5);

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    protected void clickLink(String linkText){
        By locator = By.xpath("//a[normalize-space()='" + linkText + "']");
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(locator));
        assert link != null;
        link.click();
    }

    protected <T> T navigateTo(HomeLinks link, Class<T> pageClass){
        clickLink(link.toString());
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to create page: " + pageClass.getSimpleName(), e);
        }
    }
}