package e2e.cucumber.steps;

import e2e.cucumber.CucumberTestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.HorizontalSliderPage;

public class HorizontalSliderSteps {

    private HorizontalSliderPage sliderPage;

    @When("user moves horizontal slider right by 6 steps")
    public void userMovesHorizontalSliderRightBy6Steps() {
        sliderPage = CucumberTestContext
                .getHomePage()
                .navigateToHorizontalSlider();

        sliderPage.moveSlider(Keys.ARROW_RIGHT, 6);
    }

    @Then("horizontal slider value should be {string}")
    public void horizontalSliderValueShouldBe(String expectedValue) {
        sliderPage.assertSliderValue(expectedValue);
    }
}
