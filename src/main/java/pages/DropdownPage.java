// This class represents the Dropdown Page of the application.
// It provides methods to interact with the dropdown list.
// The constructor takes a WebDriver instance to interact with the browser.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;
    private By dropdownList = By.id("dropdown");

    public DropdownPage(WebDriver driver){
        this.driver=driver;
    }

    // Selects the specified option from the dropdown list.
    public void selectFromDropdown(String option){
        findDropdownElement().selectByVisibleText(option);
    }

    // Returns a list of selected options from the dropdown list.
    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements =
                findDropdownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    // Finds and returns the dropdown element as a Select object.
    private Select findDropdownElement(){
        return new Select(driver.findElement(dropdownList));
    }


}
