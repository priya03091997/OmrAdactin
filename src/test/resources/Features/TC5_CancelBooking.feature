@CancelBooking
Feature: Verifying Adactin Hotel login and Cancel Booking

  Scenario Outline: Verifying Adactin Hotel login and Cancel Booking
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
    And User should cancel Order Id
    Then User should verify after cancel Order Id success message "The booking has been cancelled."

    Examples: 
      | userName    | password | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName      | lastName | billingAddress |
      | Sellers1234 | Demo@123 | Paris    | Hotel Sunshine | Standard | 2 - Two   | 30/11/2022  | 31/11/2022   | 2 - Two       | 0 - None        | PriyaDharshini | M        | Chennai        |

  Scenario Outline: Verifying Adactin Hotel login and cancel booking with existing Order Id
    Given User is on the Adactin login page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello Sellers1234!"
    And User should cancel booking the existing "<Order Id>"
    Then User should verify after cancel Order Id success message "The booking has been cancelled."

    Examples: 
      | userName    | password | Order Id   |
      | Sellers1234 | Demo@123 | T52Z16YT4S |
