Feature: School Department

  Background:
    Given I navigate to website "https://test.campus.techno.study/"
    And I login using username:daulet2030@gmail.com and password "TechnoStudy123@"
    And I navigate to department creation menu

  Scenario Outline: Successfully creating and deleting "High School" department
    When I create department with name <departmentName> and code <departmentCode>
    Then I should see success message "School Department successfully created"
    When I delete the department with name <departmentName> and code <departmentCode>
    Then I should see success message "School Department successfully deleted"

    Examples:
      | departmentName   | departmentCode |
      | random           | random         |
      | random           | random         |
      | "College School" | "CS-1"         |
#      | "University School" | "US-1"         |
#      | "Middle School"     | "MS-1"         |
