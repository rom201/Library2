Feature: As an authorized user, I should able to access Book page and manage books information


  @AC4_student
  Scenario: User should be able to sort records on the page
    Given I am at the Books Management page
    When I click column "ISBN"
    Then records should be sorted in "ascending" order by column "ISBN"