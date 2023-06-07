// This class represents the Hovers Page of the application.
// It provides a constructor to initialize the WebDriver instance and contains methods to interact with the page.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
    private WebDriver driver;
    private By figureBox = By.className("figure");
    private By boxCaption = By.className("figcaption");

    public HoversPage(WebDriver driver){
        this.driver=driver;
    }

    // Performs a hover action on the specified figure element
    public FigureCaption hoverOverFigure(int index){
        WebElement figure = driver.findElements(figureBox).get(index - 1);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();
        return new FigureCaption(figure.findElement(boxCaption));
    }

    public class FigureCaption {
        private WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");

        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        // Checks if the caption is displayed
        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }

        // Returns the text of the header element within the caption
        public String getTitle(){
            return caption.findElement(header).getText();
        }

        // Returns the href attribute value of the link element within the caption
        public String getLink(){
            return caption.findElement(link).getAttribute("href");
        }

        // Returns the text of the link element within the caption
        public String getLinkText(){
            return caption.findElement(link).getText();
        }
    }
}
