@tag
Feature: Test PhilipsRTC URL Navigation
  I want to see the WebRTC App getting openend in Browser

  @tag1
  Scenario Outline: Open PhilipsRTC URL
    Given Launch PhilipsRTC URL in "<browser>"  
    When I see the Login Button
    Then the scenario is successful
    Examples:
		| browser |		
		| Chrome  |
		| Firefox |

 
 @tag2
  Scenario Outline: Open PhilipsRTC URL
    Given Launch PhilipsRTC URL in "<browser>" 
    And I see the Login Button
    And users makes the changes in settings
    When user1 enters username as "Test111" and meetingid as "111111" and meetingkey
    And user2 enters username as "Test222" and meetingid as "111111" and meetingkey
    When user clicks JoinMeeting 
		Then user should be able to login successfully
		Examples:
		| browser |		
		| Chrome  |
		| Firefox |
		