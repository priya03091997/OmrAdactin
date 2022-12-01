@Login
Feature: Verifying Adactin hotel login details

  Scenario Outline: Verifying Adactin hotel login valid
    Given User is on the Adactin login page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello Sellers1234!"

    Examples: 
      | userName    | password |
      | Sellers1234 | Demo@123 |

  Scenario Outline: Verifying Adactin hotel using Enter
    Given User is on the Adactin login page
    When User should perform login "<userName>" and "<password>" with Enter key
    Then User should verify after login success message "Hello Sellers1234!"

    Examples: 
      | userName    | password |
      | Sellers1234 | Demo@123 |

  Scenario Outline: Verifying Adactin hotel login invalid credentials
    Given User is on the Adactin login page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login with invalid credential error message contains "Invalid Login details or Your Password might have expired."

    Examples: 
      | userName    | password  |
      | Sellers1234 | Demo@1234 |
