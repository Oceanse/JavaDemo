Feature: task manage

  Scenario: test for finished task
    Given I have total 3 tasks
    When I have finished 1 task
    Then I left 2 tasks that are not finished
