Feature: Login
  As a user not logged in
  I want to be able to log in

  Background: Access the application
  Given Be on the main screen
    And Access the login screen

    @positive
    Scenario: Successfully login
      Given I fill "user" as "automationpratice@qa.team"
      And I fill "password" as "123456"
      When I click on login button
      Then I am logged in

  @negative
  Scenario Outline: Validates login fiels - "<specifiedScenario>"
    Given I fill "user" as "<user>"
    And I fill "password" as "<password>"
    When I click on login button
    Then I receive the error message "<errorMessage>"
    Examples:
      | specifiedScenario | user                      | password | errorMessage    |
      | E-mail incorreto  | abs@                      | 123456   | E-mail inválido. |
      | Senha inválida    | automationpratice@qa.team |          | Senha inválida.  |