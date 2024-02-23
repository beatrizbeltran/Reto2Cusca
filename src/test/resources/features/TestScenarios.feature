@tag
Feature: Searching a pokemon in web to compare stats and skills against API

  @tag1
  Scenario: Search a pokemon
    Given Than site is available
    And Search field is active
    When I enter the <name> of pokemon
    And I click the pokemon name
    And I review stats agains API
    And I review skills agains API
   
   Examples:
   |name   |
   |Dratini|
   |Kingdra|
   |Bagon  |