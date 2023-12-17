@sorting
Feature: Sorting product list

  @sorting
  Scenario: As a user, I should be able to log in using correct registered data
    Given user is already on home page
    When user select filter price high to low
    Then compare first product price with second product price
    * user take screenshot "user-sorting-high-to-low-successfully"