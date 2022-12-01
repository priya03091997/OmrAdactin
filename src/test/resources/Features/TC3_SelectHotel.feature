@SelectHotel
Feature: Verifying Adactin hotel login details and Select Hotel

  Scenario Outline: Verifying Adactin select hotel page
    Given User is on the Adactin login page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello Sellers1234!"
    And User should search hotels "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotels success message "Select Hotel"
    And User should select hotel name followed by clicking continue button
    Then User should verify after select hotel name success message "Book A Hotel"

    Examples: 
      | userName    | password | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sellers1234 | Demo@123 | Paris    | Hotel Sunshine | Standard | 2 - Two   | 30/11/2022  | 31/11/2022   | 2 - Two       | 0 - None        |

  Scenario Outline: Verifying Adactin select hotel page by clicking continue without selecting hotel name
    Given User is on the Adactin login page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello Sellers1234!"
    And User should search hotels "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotels success message "Select Hotel"
    And User should click continue button without selecting hotel name
    Then User should verify after click continue button error message "Please Select a Hotel"

    Examples: 
      | userName    | password | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sellers1234 | Demo@123 | Paris    | Hotel Sunshine | Standard | 2 - Two   | 30/11/2022  | 31/11/2022   | 2 - Two       | 0 - None        |
