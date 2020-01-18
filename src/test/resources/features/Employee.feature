Feature: Employees info

  @api
  Scenario Outline: Get employees by specific id
    When User request user by id "<id>"
    Then It should be equal to "<name>" and "<last_name>"

  Examples:
  | id | name     | last_name   |
  | 5 | Charles   | Morris      |
  | 2 | Janet     | Weaver      |

  @api
  Scenario: Create employee
    When User provides employee data "John" "Programmer"
    Then It should be sucessfully created and contain "John" "Programmer" data


  @api
  Scenario: Remove employee
    When User try to remove user by id "2"
    Then Response should return "204" status code