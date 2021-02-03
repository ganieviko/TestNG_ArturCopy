Feature: School Department

  Background:
    Given I navigate to website "https://test.campus.techno.study/"
    And I login using username:daulet2030@gmail.com and password "TechnoStudy123@"
    And I navigate to school location creation menu

  Scenario Outline: Successfully creating and deleting School location
    When I create school location with following data
      | name      | School Location 1 |
      | shortName | SL1               |
      | type      | <locationType>    |
      | capacity  | 20                |
    Then I should see success message "School Location successfully created"
    When I delete the department with name "School Location 1"
    Then I should see success message "School Location successfully deleted"

    Examples:
      | locationType |
      | Classroom    |
      | Laboratory   |
      | Other        |

