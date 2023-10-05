Feature: Placing an Order

  Scenario : User Can Place an Order
    Given  user opens a web browser and navigates to the main page
    When the user enters their email and password
    And the user locates the desired product
    And the user selects the size and quantity of the product
    And the user adds the product to the shopping cart
    And the user proceeds to the checkout section
    And the user verifies the shipping address
    And the user chooses the payment and delivery method
    Then the order is confirmed
    And a screenshot is taken
    And the user closes the web browser
