package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.tc_012Page;

public class tc_012Steps {
    WebDriver driver;
    tc_012Page ivaPage;

    @Given("I have opened the Excel file with the IVA sheet")
    public void openExcelFile() {
        ivaPage = new tc_012Page(driver);
        ivaPage.openExcelFile("path/to/file.xlsx");
    }

    @When("I review the formula in the 'IVA Acumulado' column")
    public void reviewFormulaInIVAColumn() {
        ivaPage.reviewIVAAccumulativeFormula();
    }

    @Then("it should sum correctly all types of IVA (IVA 16%, IVA Fronterizo, IVA 0%, IVA Exento) excluding the retained IVA")
    public void validateCorrectSum() {
        boolean isFormulaCorrect = ivaPage.isFormulaCorrect();
        assert isFormulaCorrect : "The formula in the 'IVA Acumulado' column did not calculate correctly.";
    }
}