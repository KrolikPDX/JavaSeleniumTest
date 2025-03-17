Feature: Checkout Validation

Scenario: Checkout item
  #Step 1: Login, add 1 item to cart, validate cart icon now shows 1 item in cart
  Given user navigates to the login page
  When on login page user enters valid credentials and clicks login
  And on inventory page user clicks add to cart button for "Sauce Labs Backpack"
  Then on inventory page the cart icon displays 1 item in cart

  #Step 2: Click on cart icon, checkout, validate success message
  When on inventory page user clicks on the cart icon
  And on cart page user clicks the checkout button
  And on checkout page user fills the checkout form with valid details
  And on checkout page user clicks the continue button
  And on checkout page user clicks the finish button
  Then on checkout page the success icon is displayed
  And on checkout page the complete header contains "Thank you for your order!"
  And on checkout page the back home button is displayed


