Feature: Update new employee

  @employee_cleanup
  Scenario: I am able to update existing employee
    Given I read all employees
    And Employee already exist
    When I update existing employee
    Then I see updated employee data