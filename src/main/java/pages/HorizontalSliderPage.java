// This class represents the Horizontal Slider Page of the application.
// It provides a constructor to initialize the WebDriver instance and contains methods to interact with the page.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By slider = By.xpath("//input[@value='0']");
    private By range = By.id("range");

    public HorizontalSliderPage(WebDriver driver){
        this.driver=driver;
    }

    // Moves the slider to the right by pressing the right arrow key
    public void moveSliderRight(int value){
        for (int i=0;i<value;i++){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    // Returns the text value of the range element
    public String getRange(){
        return driver.findElement(range).getText();
    }
}
