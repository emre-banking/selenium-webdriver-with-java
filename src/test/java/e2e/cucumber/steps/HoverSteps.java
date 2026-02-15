package e2e.cucumber.steps;

import e2e.cucumber.CucumberTestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HoversPage;

import java.util.Map;

public class HoverSteps {

    private HoversPage.FigureCaption figureCaption;

    @When("user hovers over figure {int}")
    public void userHoversOverFigure(int figureIndex) {
        HoversPage hoversPage = CucumberTestContext
                .getHomePage()
                .navigateToHovers();

        figureCaption = hoversPage.hoverOverFigure(figureIndex);
    }

    @Then("hovered figure caption should be:")
    public void hoveredFigureCaptionShouldBe(DataTable dataTable) {
        Map<String, String> expected = dataTable.asMaps().get(0);

        figureCaption.assertCaption(
                expected.get("title"),
                expected.get("linkText"),
                expected.get("linkEnding")
        );
    }
}
