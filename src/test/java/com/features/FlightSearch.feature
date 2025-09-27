Feature: Flight Search on MakeMyTrip

  Scenario: User searches for round trip flights from HYD to MAA
    Given the user launches Edge browser and opens MakeMyTrip website
    And the user clicks on Flights tab
    And the user selects Round Trip option
    And the user enters "HYD" as the From location
    And the user enters "MAA" as the To location
    And the user selects departure and return dates
    When the user clicks on the Search button
    Then the flight search results page should be displayed
