Feature: Verify the site pages are returning expected status codes

  @responseCodes
  Scenario Outline: As a tester, I want to see expected status code
    Given "Amjad" sees <home_page> up and running
    When "Amjad" goes to <page>
    And "Amjad" sees the <response_code>

    Examples:
      |home_page|page|response_code|
      | "https://www.w3.org/" | "https://www.w3.org/standards/webofdevices/multimodal" | 200 |
      | "https://www.w3.org/" | "https://www.w3.org/standards/badpage" | 404 |
      | "https://www.w3.org/" | "https://www.w3.org/standards/webdesign/htmlcss" | 200 |
