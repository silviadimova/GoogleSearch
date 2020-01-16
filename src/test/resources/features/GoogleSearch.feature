Feature: Google search

  Scenario: Cars in London search
    Given As a user on Google Search page
    When I perform search about Cars in London
    Then I verify the number of all Gumtree links found
    When I select only Gumtree links
    Then I see their title and results