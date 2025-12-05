// This class provides methods to interact with the dropdown list.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage extends BasePage {
    private final By dropdownList = By.id("dropdown");

    public DropdownPage(WebDriver driver){
        super(driver);
    }

    // Selects the specified option from the dropdown list.
    public void selectFromDropdown(String option) {
        Select dropdown = findDropdownElement();
        boolean exists = dropdown.getOptions().stream()
                .anyMatch(o -> o.getText().equals(option));
        if (!exists) {
            throw new IllegalArgumentException("Dropdown option not found: " + option);
        }
        dropdown.selectByVisibleText(option);
    }

    // Returns a list of selected options from the dropdown list.
    public List<String> getSelectedOptions() {
        return findDropdownElement()
                .getAllSelectedOptions()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    // Finds and returns the dropdown element as a Select object.
    private Select findDropdownElement() {
        WebElement element = driver.findElement(dropdownList);
        return new Select(element);
    }
} 
