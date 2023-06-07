package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample1Page {

    private WebDriver driver;
    private By startButton = By.xpath("//button[.='Start']");
    private By finishText = By.id("finish");
    private By loadingIndicator = By.id("loading");

    public DynamicLoadingExample1Page(WebDriver driver){
        this.driver=driver;
    }

    public void clickStartButton(){
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
    }

    public String getFinishText(){
        return driver.findElement(finishText).getText();
    }
}
