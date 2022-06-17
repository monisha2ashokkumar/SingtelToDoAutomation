Feature: Adding todos to my list

  Scenario Outline: To add new todo and validate the todo list is populated with newly added todo
    Given Open the application
    When I enter '<todo>' and press enter key
    Then Verify '<todo>' is added to list
    Examples:
      | todo                 |
      | Pay credit card bill |