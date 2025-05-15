Feature: Delete existing bug

  Scenario: I am able to delete existing bug
    Given Bug already exist
    When I delete existing bug
    Then I should not see deleted bug on bugs list