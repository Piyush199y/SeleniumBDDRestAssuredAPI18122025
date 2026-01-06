Feature: Naukari profile update automation

  @naukari
  Scenario: Update the naukari profile
    Given User lands on naukari login page using "NaukariUrl"
    When User update the summary
    And Upload a new resume
    Then the profile should get updated