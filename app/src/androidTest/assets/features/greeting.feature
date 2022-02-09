Feature: The greeting feature displays the user name according to the user selection

  Scenario Outline: Display lower case greeting
    Given I start the application
    When I click the name text box
    And I enter <name>
    And I click the display lower button
    Then I expect to see a message with <name> in lower case

    Examples:
      | name |
      | Goldy |
      | Joan |

