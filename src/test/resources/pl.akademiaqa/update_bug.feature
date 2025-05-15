Feature: Update bug

  @bug_cleanup
  Scenario: I am able to close bug
    Given Bug already exist
    When I close existing bug
    Then I can read updated bug and see status as closed