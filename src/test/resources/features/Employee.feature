Feature: Employess info

  @api
  Scenario Outline: Get user by specific id
    When User request user by id <id>
    Then It should be equal to <name> and <last_name>

  Examples:
  | id | name     | last_name |
   | 2 | Janet   | Weaver             |

