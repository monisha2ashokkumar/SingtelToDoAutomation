@regression @filters
Feature: To verify filter options in todo application

  Background: To launch application and remove existing todo items
    Given Open the application
    And I clear all existing todos

  @clear @singleclear
  Scenario Outline: To ensure clear completed removes a single completed todo from different tabs
    Then I add multiple todos
      | Chase coffee  |
      | Get groceries |
    Then I check on '<todo>'
    When I click on '<filter>'
    When I click on Clear Completed button
    Then Verify '<todo>' is removed from the todo list
    Examples:
      | todo          | filter    |
      | Chase coffee  | all       |
      | Get groceries | completed |

  @clear @bulkclear
  Scenario Outline: To ensure clear completed removes multiple completed todos from different tabs
    Then I add multiple todos
      | Go for travel |
      | Hiking        |
      | Camping       |
      | Running       |
    And I click on 'all'
    And I check on multiple
      | Hiking  |
      | Running |
    And I click on '<filter>'
    And I click on Clear Completed button
    Then Verify multiple todos are removed from the todo list
      | Hiking |
      | Running |
    Examples:
      | filter |
      | all    |
      | completed |

  @toggle
  Scenario Outline: To ensure by selectAll or deselectAll, todos should display according based on filter criteria
    Then I add multiple todos
      | Leading spaces |
      | chase coffee   |
      | hello world    |
      | Trailing gates |
    When I toggle '<checkbox>'
    Then I click on '<filter>'
    Then I should see all todos are displayed
      | Leading spaces |
      | chase coffee   |
      | hello world    |
      | Trailing gates |
    Then I click on 'all'
    Examples:
      | checkbox | filter    |
      | false    | all       |
      | true     | completed |
      | false    | active    |

  @itemscount
  Scenario Outline: To validate item left count based on todo's status
    Then I add a '<todo>'
    And I store items left count
    When I check on '<todo>'
    Then Verify '<todo>' is in '<status>' status
    And Verify items left is reduced by <count>
    Examples:
      | todo           | status    | count |
      | Leading spaces | completed | 1     |


