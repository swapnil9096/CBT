Feature: Login Page
@Smoke
  Scenario: Verify login fuctionality
    Given User should be on login page
    When Enter <examNum> and <password>
    And Click on login button
    Then User should be navigated to exam dashboard page

  @Regression
  Scenario: Verify when the test taker is on the test start page then click on navigate left arrow after that clear login from test centre admin loader doesn’t close
    Given User should login as Test taker
    When User started the test
    Then Clear the login from test centre
    And User should stop the test
