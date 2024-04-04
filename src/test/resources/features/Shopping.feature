@Test2
Feature: 1. Write the script to create orders
  2. Select the Multiple orders
  3. Click Shopping cart icon
  4. Enter the different checkout details (FirstName, LastName, PostalCode) using javafaker
  5. Checkout an Item and finish the order
  6. Verify the success message
  7. Click the menu icon and proceed Logout


  Background: Same Steps---
    Given launch chrome browser
    When open SwagLab Login Page
    Then user is on swaglab login page
    And user give UserName and Password
    And user is able to login

  @smoke
    Scenario: Successfully done  orders
      Given user is on SwagLab Home Page
      When user added multiple products to cart
      Then user able to go to shopping cart page
      And user able to checkout
      When I enter the checkout details with random data
      And finish the order and get order successful message
      And Close the browser

