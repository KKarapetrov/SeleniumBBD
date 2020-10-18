Feature: Customer side(Frontend) and Admin side(Backend) Tests

  @AdminArea @Positive
Scenario: The admin attempts a Marketing Coupon Creation

  Given the admin on the main page of shop.pragmatic.bg admin log in screen
  When he enters "admin" as a username
  And he enters "parola123!" as a password
  And he navigates to the Marketing section of the admin dashboard
  And creates a coupon with coupon name "Coupon123"
  And enters as coupon code "Coupon123"
  And enters discount amount "10"
  And enters total discount amount "10"
  And presses the save button
  Then ensure that the coupon was created with message "Success: You have modified coupons"

  @CustomerArea @Negative
Scenario: Purchasing a product with less than the minimum order quantity

  Given the user is on the product page with URL "http://shop.pragmatic.bg/index.php?route=product/product&product_id=43"
  When enters quantity "1" which is less than the specified minimum ordering quantity
  And adds the product to their cart
  And goes to their shopping cart
  Then ensure that the warning message "Minimum order amount for MacBook is 2!"

    @CustomerArea @Positive
Scenario: Customer wants to change displayed currency on shop.pragmatic.bg
      
  Given the user is on the main page of "http://shop.pragmatic.bg/"
  When the user selects the "EUR" option on the currency component
  Then ensure that the currency has been changed to "€ Currency"

    @AdminArea @Negative
Scenario: The admin attempts a Duplicate Marketing Coupon Creation

  Given the admin on the main page of shop.pragmatic.bg admin log in screen
  When he enters "admin" as a username
  And he enters "parola123!" as a password
  And he navigates to the Marketing section of the admin dashboard
  And creates a coupon with coupon name "-10% Discount"
  And enters as coupon code "2222"
  And enters discount amount "10.0000"
  And enters total discount amount "0.0000"
  And presses the save button
  Then ensure error message "Coupon code is already in use!" warning there is already such a coupon

