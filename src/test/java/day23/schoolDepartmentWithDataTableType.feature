Feature: School Department

  Background:
    Given I navigate to website "https://test.campus.techno.study/"
    And I login using username:daulet2030@gmail.com and password "TechnoStudy123@"
    And I navigate to department creation menu

  Scenario: Successfully creating and deleting "High School" department
    When I create department with name "High School" and code "HS-1" without saving
    And I create following sections
      | sectionName    | sectionShortName |
      | Section 1      | HS-1-S1          |
      | Junior Classes | Junior           |
      | Senior Classes | Senior           |
    And I click on department save button
    Then I should see success message "School Department successfully created"
    When I delete the department with name "High School" and code "HS-1"
    Then I should see success message "School Department successfully deleted"
