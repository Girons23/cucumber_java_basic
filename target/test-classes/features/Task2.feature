Feature: Second task

  Background:

    Given I am on page

  Scenario Outline: Add a person
    When I press add person button
    Then I add persons "<name>"
    Then I add person "<job>"
    Then I click add button
    Then Peron appears in main list with "<name>"

    Examples:
    |name | job|
    |Girts| Trainee|
    |Roberts| Tester|


  Scenario: Edit a person
    When I press edit button for first person
    And Clear name field
    And Clear job field
    And Change persons name
    And Change persons job
    Then I check if edit is made
    Then Press edit button


    Scenario: remove a person
      When I press remove button to first person
      Then I check if its removed


      Scenario Outline: Reset original list

        When I press add person button
        Then I add persons "<name>"
        Then I add person "<job>"
        Then I click add button
        Then Peron appears in main list with "<name>"
        Then I click reset list button

        Then I press first person edit button
        And Clear name field
        And Clear job field
        And Change persons name
        And Change persons job
        Then Press edit button
        Then I check if edit is made
        Then I click reset list button

        Then I press remove button to first person
        Then I check if its removed
        Then I click reset list button
        Then I check if three persons are in list


        Examples:
          |name | job|
          |Girts| Trainee|



  Scenario Outline: See if clear button works when adding
          When I press add person button
          Then I add persons "<name>"
          Then I add person "<job>"
    And I press clear button
    Then I check if name is removed
    And if job is removed
    Examples:
      |name | job|
      |Girts| Trainee|
      |Roberts| Tester|