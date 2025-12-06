// This class provides a constructor to initialize the WebDriver instance and contains methods to interact with the page.

package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HoversPage extends BasePage{
    private final By figureBox = By.className("figure");
    private final By boxCaption = By.className("figcaption");

    public HoversPage(WebDriver driver){
        super(driver);
    }

    public FigureCaption hoverOverFigure(int index) {
        return Allure.step("Hover over figure at index: " + index, () -> {
            WebElement figure = wait
                    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(figureBox))
                    .get(index - 1);
            new Actions(driver).moveToElement(figure).perform();
            return new FigureCaption(figure.findElement(boxCaption));
        });
    }

    public class FigureCaption {
        private final WebElement caption;
        private final By header = By.tagName("h5");
        private final By link = By.tagName("a");

        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        public void assertCaption(String expectedTitle, String expectedLinkText, String expectedLinkEnding) {
            Allure.step("Verify figure caption details", () -> {
                Assert.assertTrue(
                        isCaptionDisplayed(),
                        "Caption is not displayed."
                );
                Assert.assertEquals(
                        getTitle(),
                        expectedTitle,
                        "Caption title mismatch."
                );
                Assert.assertEquals(
                        getLinkText(),
                        expectedLinkText,
                        "Caption link text mismatch."
                );
                Assert.assertTrue(
                        getLink().endsWith(expectedLinkEnding),
                        "Caption link URL is incorrect."
                );
            });
        }

        // Checks if the caption is displayed
        private boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }

        // Returns the text of the header element within the caption
        private String getTitle(){
            wait.until(ExpectedConditions.visibilityOf(caption));
            return caption.findElement(header).getText().trim();
        }

        // Returns the href attribute value of the link element within the caption
        private String getLink(){
            return caption.findElement(link).getAttribute("href");
        }

        // Returns the text of the link element within the caption
        private String getLinkText(){
            return caption.findElement(link).getText().trim();
        }
    }
}
