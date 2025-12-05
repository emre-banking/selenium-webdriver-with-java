// This class provides a constructor to initialize the WebDriver instance and contains methods to interact with the page.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HoversPage extends BasePage{
    private final By figureBox = By.className("figure");
    private final By boxCaption = By.className("figcaption");

    public HoversPage(WebDriver driver){
        super(driver);
    }

    // Performs a hover action on the specified figure element
    public FigureCaption hoverOverFigure(int index){
        WebElement figure = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(figureBox)).get(index - 1);
        new Actions(driver).moveToElement(figure).perform();
        return new FigureCaption(figure.findElement(boxCaption));
    }

    public class FigureCaption {
        private final WebElement caption;
        private final By header = By.tagName("h5");
        private final By link = By.tagName("a");

        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        // Checks if the caption is displayed
        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }

        // Returns the text of the header element within the caption
        public String getTitle(){
            wait.until(ExpectedConditions.visibilityOf(caption));
            return caption.findElement(header).getText().trim();
        }

        // Returns the href attribute value of the link element within the caption
        public String getLink(){
            return caption.findElement(link).getAttribute("href");
        }

        // Returns the text of the link element within the caption
        public String getLinkText(){
            return caption.findElement(link).getText().trim();
        }
    }
}
