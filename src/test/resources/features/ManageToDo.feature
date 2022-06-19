@regression @add @edit @delete
Feature: To perform and verify add, edit and delete operations in todo application

  Background: To launch application
    Given Open the application

  @add
  Scenario Outline: To validate adding todo with different combination of inputs
    When I add a '<todo>'
    Then Verify '<todo>' is added to list
    And Validate items count matches with <count>
    Examples:
      | todo                                        | count |
      | a                                           | 1     |
      | hi hello                                    | 2     |
      | 1324526                                     | 3     |
      | #$#%^#^                                     | 4     |
      | abc456                                      | 5     |
      | abfe**234                                   | 6     |
      | avyuaf gefgey gdwa uhdw iof cheo aicga icgi | 7     |
      | Doctor appointment on 18/07/2023 @ 07:30PM  | 8     |
      | MY ANNIVERSARY ON TOMORROW                  | 9     |
      | WaKe Me UP AT 6                             | 10    |
      | hi hello                                    | 11    |


  @add @inputspace
  Scenario: To validate spaces is not accepted as a valid todo
    Then I clear all existing todos
    When I add a '     '
    Then Verify space is not added to list

  @add @extraspaces
  Scenario Outline: To validate removal of leading, trailing and extra spaces before adding task to the todo list
    Then I clear all existing todos
    When I add a '<todo>'
    Then Verify '<todo>' is added to list
    And Validate displayed todo is same as '<acceptableTodo>' in web page
    Examples:
      | todo               | acceptableTodo  |
      | Leading spaces     | Leading spaces  |
      | Trailing spaces    | Trailing spaces |
      | My       Sun shine | My Sun shine    |

  @add @refresh
  Scenario: When I refresh the page I should see all my todos are preserved
    Given I clear all existing todos
    Then I add multiple todos
      | Leading spaces |
      | chase coffee   |
      | hello world    |
      | Trailing gates |
    When I click on refresh
    Then I should see all todos are displayed
      | Leading spaces |
      | chase coffee   |
      | hello world    |
      | Trailing gates |

  @edit
  Scenario Outline: To replace todo with updated todo task
    Then I clear all existing todos
    Then I add multiple todos
      | Chase coffee  |
      | Get groceries |
    When I replace '<todoToEdit>' with '<replaceValue>'
    Then Verify '<replaceValue>' is available in todo list
    Examples:
      | todoToEdit    | replaceValue |
      | Get groceries | Buy towel    |


  @edit @inputspace
  Scenario Outline: When I edit todo with blank or spaces, respective todo must be removed from the list
    Then I clear all existing todos
    Then I add multiple todos
      | Chase coffee  |
      | Get groceries |
    When I replace '<todoToEdit>' with '<replaceValue>'
    Then Verify '<todoToEdit>' is removed from the todo list
    Examples:
      | todoToEdit    | replaceValue |
      | Chase coffee  |              |
      | Get groceries |              |

  @delete
  Scenario Outline: To delete a todo item
    Then I clear all existing todos
    Then I add multiple todos
      | Chase coffee |
      | Get groceries |
    When I locate '<todo>' and click on delete
    Then Verify '<todo>' is removed from the todo list
    Examples:
      | todo          |
      | Get groceries |

  @nobrokenlinks
  Scenario: To ensure there is no broken links in the application
    Then Verify there is no broken links