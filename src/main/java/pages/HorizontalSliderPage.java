// This class provides a constructor to initialize the WebDriver instance and contains methods to interact with the page.

package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Objects;

public class HorizontalSliderPage extends BasePage {

    private final By slider = By.cssSelector("input[type='range']");

    public HorizontalSliderPage(WebDriver driver){
        super(driver);
    }

    // Moves the slider to the right by pressing the right arrow key
    public void moveSlider(Keys direction, int steps) {
        Allure.step("Move slider " + steps + " steps using direction: " + direction.name(), () -> {
            WebElement sliderElement = wait.until(ExpectedConditions.elementToBeClickable(slider));
            for (int i = 0; i < steps; i++) {
                assert sliderElement != null;
                sliderElement.sendKeys(direction);
            }
        });
    }

    public void assertSliderValue(String expectedValue) {
        Allure.step("Verify slider value is " + expectedValue, () ->
                Assert.assertEquals(
                        getSliderValue(),
                        expectedValue,
                        "Slider value mismatch."
                )
        );
    }

    // Returns the text value of the range element
    private String getSliderValue() {
        return Objects.requireNonNull(driver.findElement(slider).getAttribute("value")).trim();
    }
}