@SearchHotel
Feature: Verifying Adactin hotel login details and Search Hotel

  Scenario Outline: Verifying Adactin hotel login with valid credentials
    Given User is on the Adactin login page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello Sellers1234!"
    And User should search hotels "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotels success message "Select Hotel"

    Examples: 
      | userName    | password | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sellers1234 | Demo@123 | Paris    | Hotel Sunshine | Standard | 2 - Two   | 30/11/2022  | 31/11/2022   | 2 - Two       | 0 - None        |

  Scenario Outline: Verifying Adactin hotel login with valid credentials using only mandatory fields
    Given User is on the Adactin login page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello Sellers1234!"
    And User should enter only mandatory fields "<location>","<noOfRooms>","<checkInDate>","<checkOutDate>" and "<adultsPerRoom>"
    Then User should verify after search hotels success message "Select Hotel"

    Examples: 
      | userName    | password | location | noOfRooms | checkInDate | checkOutDate | adultsPerRoom |
      | Sellers1234 | Demo@123 | Paris    | 2 - Two   | 18/11/2022  | 19/11/2022   | 2 - Two       |

  Scenario Outline: Verifying Adactin hotel login with valid credentials and invalid checkin & checkout date
    Given User is on the Adactin login page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello Sellers1234!"
    And User should search hotels "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after entering invalid date error message "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName    | password | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sellers1234 | Demo@123 | Paris    | Hotel Sunshine | Standard | 2 - Two   | 30/11/2023  | 31/11/2022   | 2 - Two       | 0 - None        |

  Scenario Outline: Verifying Adactin hotel login with valid credentials
    Given User is on the Adactin login page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello Sellers1234!"
    And User should click search button
    Then User should verify after clickling search button error message "Please Select a Location"

    Examples: 
      | userName    | password |
      | Sellers1234 | Demo@123 |
