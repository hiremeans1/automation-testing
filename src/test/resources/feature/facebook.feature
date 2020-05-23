Feature: Facebook account create feature

  @FacebookAccountCreate
  Scenario: should create a facebook account
    Given  fill up all the required fields to create an account
    When   click on the sign up button
    Then   should goto facebook account
