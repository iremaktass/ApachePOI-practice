
  Feature: Google search functionality
    User Story: As a user, when I am on the google search page,
    I should be able to search whatever I want, and see relevant information.

    @googleSearch
    Scenario: User search title verification
      Given user is on google home page
      When user searches SDET
      Then user should see SDET in title

      @google_multiple
    Scenario:  User searches for multiple items
      Given user is on google home page
      Then user should be able to search for following:
      |java|
      |selenium|
      |cucumber|
      |QA automation|

     @google_scenario
    Scenario Outline: Google capital city search
      Given user is on google home page
      When user searches for "<country>" capital
      Then user should see "<capital>" in the result
      Examples:
      |country | capital |
      |USA     | Washington, D.C. |
      |Turkey  | Ankara       |
      |China   | Beijing  |
      | Ukraine | Kyiv  |
      |Tajikistan | Dushanbe|