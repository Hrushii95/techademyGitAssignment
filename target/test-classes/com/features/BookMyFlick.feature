Feature: Book My Flick Service

Scenario: Search and book a movie
  Given user is on the movie search page
  When user searches for "Homebound"
  And selects the movie and proceeds to payment
  Then booking should be confirmed
