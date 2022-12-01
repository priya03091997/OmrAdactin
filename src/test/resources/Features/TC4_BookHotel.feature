@BookHotel
Feature: Verifying Adactin hotel login details and Booking confirmation

  Scenario Outline: Verifying Adactin Select Hotel page
    Given User is on the Adactin login page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello Sellers1234!"
    And User should search hotels "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotels success message "Select Hotel"
    And User should select hotel name followed by clicking continue button
    Then User should verify after select hotel name success message "Book A Hotel"
    And User should book hotel "<firstName>" , "<lastName>" and "<billingAddress>"
      | creditCardNo     | creditCardType   | expiryMonth | expiryYear | cvvNo |
      | 8909890975678974 | VISA             | December    |       2022 |   678 |
      | 8909890975678974 | American Express | December    |       2022 |   567 |
      | 8909890975678974 | Master Card      | December    |       2022 |   890 |
      | 8909890975678974 | Other            | December    |       2022 |   764 |
    Then User should verify after booking success message "Booking Confirmation" and save Order Id

    Examples: 
      | userName    | password | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName      | lastName | billingAddress |
      | Sellers1234 | Demo@123 | Paris    | Hotel Sunshine | Standard | 2 - Two   | 30/11/2022  | 31/11/2022   | 2 - Two       | 0 - None        | PriyaDharshini | M        | Chennai        |

  Scenario Outline: Verifying Adactin Book a Hotel page without entering any fields click Book Now
    Given User is on the Adactin login page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello Sellers1234!"
    And User should search hotels "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotels success message "Select Hotel"
    And User should select hotel name followed by clicking continue button
    Then User should verify after select hotel name success message "Book A Hotel"
    And User should click book now button
    Then User should verify error message after click book now "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName    | password | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sellers1234 | Demo@123 | Paris    | Hotel Sunshine | Standard | 2 - Two   | 30/11/2022  | 31/11/2022   | 2 - Two       | 0 - None        |
