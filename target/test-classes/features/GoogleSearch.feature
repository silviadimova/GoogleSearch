Feature: Google search

  Scenario: Cars in London search
    Given As a user on Google Search page
    When I perform search about Cars in London
    And I verify the number of all Gumtree links found
    Then I select only Gumtree links and see their title and results