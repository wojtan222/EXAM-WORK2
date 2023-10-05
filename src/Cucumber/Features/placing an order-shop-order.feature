Feature: Placing an Order

  Scenario: User Can Place an Order
    Given the user opens a web browser and navigates to the main page
    When the user logs in with their email and password
    And the user searches for the desired product
    And the user selects the product's size and quantity
    And the user adds the product to the shopping cart
    And the user proceeds to the checkout section
    And the user verifies the shipping address
    And the user selects the payment and delivery method
    Then I take a screenshot of order details
    And the user closes the web browser
