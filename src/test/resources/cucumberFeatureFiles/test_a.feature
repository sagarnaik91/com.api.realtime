Feature: Login feature
  In order to perform successful login
  As a user
  I have to enter correct username and password
Background:
  Given user navigates to the facesbook website
  When user validates the homepage title
@test1
  Scenario Outline: Login to the facebook website
    Then user enters "<username>" username
    And user enters "<password>" password
    And validate the captcha image "<image1>" and "<image2>"
    And user clicks on the signin button
    Examples:
    |username|password|image1|image2|
    |valid   |valid   |abc   |def   |
    |invalid|invalid  |ghi   |jkl   |
    |valid  |invalid  |mno   |pqr   |
    |invalid|valid    |123   |456   |
@test2
  Scenario Outline: Login to the facebook website
    Then user enters "<username>" username
    And user enters "<password>" password
    And validate the captcha image "<image1>" and "<image2>"
    And user clicks on the signin button
    Examples:
      |username|password|image1|image2|
      |abc   |def   |abc   |def   |
      |ghi|jkl  |ghi   |jkl   |


