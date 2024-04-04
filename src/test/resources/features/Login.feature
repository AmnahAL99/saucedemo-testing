@Test1
Feature: 1. navigate to the link https://www.saucedemo.com
  2. Login page with given username and password
  3.Select item for order
  4.Click Shopping cart icon
  5.Checkout item and finish order
  6.Verify the success message
  7.Click the menu icon and proceed logout

  Background: Same Steps
    Given Open the browser
    When Navigate to saucedemo login page

    @Login
    Scenario: Login functionality exists
      Given Swaglabs logo should exist
      When Login button should exist

    @Sanity
    Scenario Outline: Successful login

      Given I enter valid <uname> and <password>
      When I click on log in button
      Then I should be login
      Examples:
        | uname                   | password     |
        | standard_user           | secret_sauce |
        | problem_user            | secret_sauce |
        | performance_glitch_user | secret_sauce |

      @Regression
      Scenario: Add to cart and logout
        Given  enter username as standard_user and password as secret_sauce
        When  click on log in button
        Then  able to see product page
        And  add an item to cart
        And able to see item in the cart
        And  I click Shopping Cart icon
        And  I Checkout an item and finish the order
        And  click on logout button
        And close browser




