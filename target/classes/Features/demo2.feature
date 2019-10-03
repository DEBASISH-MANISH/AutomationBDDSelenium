@tag
Feature: Test PhilipsRTC Dummy
  I want to see the WebRTC App getting openend in Browser parallely

  @tag1
  Scenario Outline: Open PhilipsRTC URL
    Given Launch PhilipsRTC URL in "<browser>"
    When user tries to click Join Button
    Then the scenario is successful
    Examples:
		| browser |		
		| Chrome  |
		| Firefox |

 
 