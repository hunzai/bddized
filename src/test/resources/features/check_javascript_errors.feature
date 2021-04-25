Feature: Check there are not javascript errors on pages

  @jsErrors
  Scenario Outline: As a tester, I want see no java script errors on the page
    Given "Amjad" sees <home_page> up and running
    When "Amjad" goes to <page>
    Then "Amjad" sees no javascript errors

    Examples:
      |home_page|page|
      | "https://www.w3.org/" | "https://www.w3.org/standards/webdesign/script.html" |
      | "https://www.nasa.gov/" | "https://www.nasa.gov/exploration/commercial/crew/index.html" |
