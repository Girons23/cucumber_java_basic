Feature: First task


  Scenario Outline: Enter text instead of the number
    Given Enter task page
    When number I enter "<abc>"
    And I click on submit button
    Then I will see an error "<error>"

    Examples:
      | abc    | error                        |
      | 64     | Square root of 64 is 8.00    |
      | 48     | Number is too small          |
      | 101    | Number is too big            |
      | abc    | Please enter a number        |

  Scenario: Enter text instead of the number
    Given Enter task page

#  @not_working
#    Examples:
#      || number | message                   |
#      || 49     | Square root of 49 is 7.00 |
