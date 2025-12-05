// This class provides a constructor to initialize the WebDriver instance and contains methods to interact with the page.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HorizontalSliderPage extends BasePage {

    private final By slider = By.cssSelector("input[type='range']");
    private final By range = By.id("range");

    public HorizontalSliderPage(WebDriver driver){
        super(driver);
    }

    // Moves the slider to the right by pressing the right arrow key
    public void moveSlider(Keys direction, int steps) {
        WebElement sliderElement = wait.until(ExpectedConditions.elementToBeClickable(slider));
        for (int i = 0; i < steps; i++) {
            sliderElement.sendKeys(direction);
        }
    }

    // Returns the text value of the range element
    public String getSliderValue() {
        return driver.findElement(slider).getAttribute("value").trim();
    }
}