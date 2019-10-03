$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("demo.feature");
formatter.feature({
  "line": 2,
  "name": "Test PhilipsRTC URL Navigation",
  "description": "I want to see the WebRTC App getting openend in Browser",
  "id": "test-philipsrtc-url-navigation",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    }
  ]
});
formatter.before({
  "duration": 869062457,
  "status": "passed"
});
formatter.before({
  "duration": 164990905,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Open PhilipsRTC URL",
  "description": "",
  "id": "test-philipsrtc-url-navigation;open-philipsrtc-url",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Launch PhilipsRTC URL",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I see the Login Button",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "the scenario is successful",
  "keyword": "Then "
});
formatter.match({
  "location": "Demoscreendefinition.LaunchURL()"
});
formatter.result({
  "duration": 25007136005,
  "status": "passed"
});
formatter.match({
  "location": "Demoscreendefinition.UserFieldsVisible()"
});
formatter.result({
  "duration": 4128566259,
  "status": "passed"
});
formatter.match({
  "location": "Demoscreendefinition.JoinButtonVisible()"
});
formatter.result({
  "duration": 4115355992,
  "status": "passed"
});
formatter.after({
  "duration": 1631717031,
  "status": "passed"
});
formatter.after({
  "duration": 2116925,
  "status": "passed"
});
formatter.before({
  "duration": 27113048,
  "status": "passed"
});
formatter.before({
  "duration": 24599405,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Open PhilipsRTC URL",
  "description": "",
  "id": "test-philipsrtc-url-navigation;open-philipsrtc-url",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@tag2"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "Launch PhilipsRTC URL",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "I see the Login Button",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "users makes the changes in settings",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "user1 enters username as \"Test111\" and meetingid as \"111111\" and meetingkey",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "user2 enters username as \"Test222\" and meetingid as \"111111\" and meetingkey",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "user clicks JoinMeeting",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "user should be able to login successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "Demoscreendefinition.LaunchURL()"
});
formatter.result({
  "duration": 32075732575,
  "status": "passed"
});
formatter.match({
  "location": "Demoscreendefinition.UserFieldsVisible()"
});
formatter.result({
  "duration": 4099253005,
  "status": "passed"
});
formatter.match({
  "location": "Demoscreendefinition.user_makes_the_changes_in_settings()"
});
formatter.result({
  "duration": 13279932127,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Test111",
      "offset": 26
    },
    {
      "val": "111111",
      "offset": 53
    }
  ],
  "location": "Demoscreendefinition.user1_enters_username_as_and_meetingid_as_and_meetingkey(String,String)"
});
formatter.result({
  "duration": 17022461968,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Test222",
      "offset": 26
    },
    {
      "val": "111111",
      "offset": 53
    }
  ],
  "location": "Demoscreendefinition.user2_enters_username_as_and_meetingid_as_and_meetingkey(String,String)"
});
formatter.result({
  "duration": 17093538948,
  "status": "passed"
});
formatter.match({
  "location": "Demoscreendefinition.user_clicks_JoinMeeting()"
});
formatter.result({
  "duration": 4395149863,
  "status": "passed"
});
formatter.match({
  "location": "Demoscreendefinition.user_should_be_able_to_login_successfully()"
});
formatter.result({
  "duration": 107898,
  "status": "passed"
});
formatter.after({
  "duration": 2048954707,
  "status": "passed"
});
formatter.after({
  "duration": 1208206,
  "status": "passed"
});
formatter.uri("demo2.feature");
formatter.feature({
  "line": 2,
  "name": "Test PhilipsRTC Dummy",
  "description": "I want to see the WebRTC App getting openend in Browser parallely",
  "id": "test-philipsrtc-dummy",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    }
  ]
});
formatter.before({
  "duration": 33291925,
  "status": "passed"
});
formatter.before({
  "duration": 23031814,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Open PhilipsRTC URL",
  "description": "",
  "id": "test-philipsrtc-dummy;open-philipsrtc-url",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Launch PhilipsRTC URL",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user tries to click Join Button",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "the scenario is successful",
  "keyword": "Then "
});
formatter.match({
  "location": "Demoscreendefinition.LaunchURL()"
});
formatter.result({
  "duration": 24339125201,
  "status": "passed"
});
formatter.match({
  "location": "Demoscreendefinition2.ClickJoinButton()"
});
formatter.result({
  "duration": 8352587776,
  "status": "passed"
});
formatter.match({
  "location": "Demoscreendefinition.JoinButtonVisible()"
});
formatter.result({
  "duration": 16525409252,
  "status": "passed"
});
formatter.after({
  "duration": 1333024274,
  "status": "passed"
});
formatter.after({
  "duration": 1150771,
  "status": "passed"
});
});