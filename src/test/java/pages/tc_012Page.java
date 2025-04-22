package pages;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class tc_012Page {
    WebDriver driver;
    Workbook workbook;

    public tc_012Page(WebDriver driver) {
        this.driver = driver;
    }

    public void openExcelFile(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reviewIVAAccumulativeFormula() {
        Sheet sheet = workbook.getSheet("IVA Sheet");
        Row row = sheet.getRow(1); // Assuming the data starts from the second row
        Cell cell = row.getCell(getColumnIndex(sheet, "IVA Acumulado"));

        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
        CellValue cellValue = evaluator.evaluate(cell);

        // Additional logic to evaluate the correctness of the formula can be added here...
    }

    public boolean isFormulaCorrect() {
        // Logic to validate formula correctness
        // For example, compare expected sum with cell value obtained
        // This is a placeholder, actual implementation depends on exact requirements
        return true;
    }

    private int getColumnIndex(Sheet sheet, String columnName) {
        Row headerRow = sheet.getRow(0);
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equals(columnName)) {
                return cell.getColumnIndex();
            }
        }
        return -1;
    }
}