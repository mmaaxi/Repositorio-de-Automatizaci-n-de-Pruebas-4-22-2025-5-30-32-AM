Feature: Validate the update of the formula in 'IVA Acumulado'
  As an accountant
  I want to verify the formula in the 'IVA Acumulado' column in Excel
  So that it correctly sums all types of IVA excluding the retained IVA

  Scenario: Check the formula in 'IVA Acumulado' column
    Given I have opened the Excel file with the IVA sheet
    When I review the formula in the 'IVA Acumulado' column
    Then it should sum correctly all types of IVA (IVA 16%, IVA Fronterizo, IVA 0%, IVA Exento) excluding the retained IVA