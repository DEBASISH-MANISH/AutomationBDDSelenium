package stepdefinitions;


import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import common.Generic;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objects.Pageobjects;

public class Demoscreendefinition extends Generic{

	public static WebDriver driver1;
	public static WebDriver driver2;
	
	@Before
	public void BeforeScenario() throws Exception   {
		TestScenario_Initiation();		
	} 	

	@After
	public void AfterScenario(Scenario scenario) throws Exception{		
		AddScreenshot(scenario);
		TestScenario_Completition();			
	}	

	
	@Given("^Launch PhilipsRTC URL in \\\"([^\\\"]*)\\\"$")
	public void LaunchPhilipsRTCURL(String browser) throws Exception {
		try {
			for (int i = 1; i < 3; i++) {
				if(i==1) {	
					OpenBrowser(driver1,browser);
					Htable.put("driver1", browserdriver);
				}else if(i==2){		
					OpenBrowser(driver2,browser);
					Htable.put("driver2", browserdriver);
				}				
				OpenURL(browserdriver);
				WaitForElement(browserdriver, "xpath", Pageobjects.button_JoinMeeting);
			}			
		} catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
			throw(e);
		}
	}

	@When("^I see the Login Button$")
	public void UserFieldsVisible() throws Exception {		
		try {
			for (int i = 1; i < 3; i++) {
				if(i==1) {
					browserdriver = Htable.get("driver1");
				}else {
					browserdriver = Htable.get("driver2");
				}				
				if(!IsElementPresent(browserdriver, "xpath", Pageobjects.text_username)) {
					Reporter.addStepLog("Username Field is not Present");
				}			
			}			
		} catch (Exception e) {			
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
			throw(e);
		}
	}

	@Then("^the scenario is successful$")
	public void JoinButtonVisible() throws Exception {		
		try {
			for (int i = 1; i < 3; i++)
			{
				if(i==1) {
					browserdriver = Htable.get("driver1");
				}else {
					browserdriver = Htable.get("driver2");
				}	
				if(!IsElementPresent(browserdriver, "xpath", Pageobjects.button_JoinMeeting)) {
					Reporter.addStepLog("Join Meeting Button is not visible");
				}
			}
		} catch (Exception e) {			
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
		}
	}

	@And("^users makes the changes in settings$")
	public void user_makes_the_changes_in_settings() throws Exception {
		try {
			for (int i = 1; i < 3; i++) {
				if(i==1) {
					browserdriver = Htable.get("driver1");
				}else {
					browserdriver = Htable.get("driver2");
				}	
				if(!ClickElement(browserdriver, "xpath", Pageobjects.button_settingsicon)){
					Reporter.addStepLog("Setting Button not clicked");
				}
				if(!IsElementPresent(browserdriver, "xpath", Pageobjects.link_update)){					
					Reporter.addStepLog("Setting Overlay not getting populated");					
				}else {
					if(!ClickElement(browserdriver, "xpath", Pageobjects.link_update)) {
						Reporter.addStepLog("Update Link not clicked");
					}
				}		
			}
		} catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
		}
	}

	@When("^user1 enters username as \"([^\"]*)\" and meetingid as \"([^\"]*)\" and meetingkey$")
	public void user1_enters_username_as_and_meetingid_as_and_meetingkey(String username, String meetingid) throws Throwable{
		try {		
			browserdriver = Htable.get("driver1");
			if(!SetText(Htable.get("driver1"), "xpath", Pageobjects.text_username, username)) {
				Reporter.addStepLog("Username not set");
			}
			if(!SetText(Htable.get("driver1"), "xpath", Pageobjects.text_meetingid, meetingid)) {
				Reporter.addStepLog("MeetingID not set");
			}
			if(!Class_Hmap.get("provider").toLowerCase().contains("twilio")) {
				if(!SetText(Htable.get("driver1"), "xpath", Pageobjects.text_meetingtoken, Class_Hmap.get("fm_meetingkey"))) {
					Reporter.addStepLog("MeetingKey not set");
				}
			}else {
				if(!SetText(Htable.get("driver1"), "xpath", Pageobjects.text_meetingtoken, Class_Hmap.get("twilio_meetingkey1"))) {
					Reporter.addStepLog("MeetingKey not set");
				}
			}
			
		} catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
		}
	}

	@When("^user2 enters username as \"([^\"]*)\" and meetingid as \"([^\"]*)\" and meetingkey$")
	public void user2_enters_username_as_and_meetingid_as_and_meetingkey(String username, String meetingid) throws Throwable{
		try {

			browserdriver = Htable.get("driver2");
			if(!SetText(Htable.get("driver2"), "xpath", Pageobjects.text_username, username)) {
				Reporter.addStepLog("Username not set");
			}
			if(!SetText(Htable.get("driver2"), "xpath", Pageobjects.text_meetingid, meetingid)) {
				Reporter.addStepLog("MeetingID not set");
			}
			if(!Class_Hmap.get("provider").toLowerCase().contains("twilio")) {
				if(!SetText(Htable.get("driver2"), "xpath", Pageobjects.text_meetingtoken, Class_Hmap.get("fm_meetingkey"))) {
					Reporter.addStepLog("MeetingKey not set");
				}
			}else {
				if(!SetText(Htable.get("driver2"), "xpath", Pageobjects.text_meetingtoken, Class_Hmap.get("twilio_meetingkey2"))) {
					Reporter.addStepLog("MeetingKey not set");
				}
			}
		} catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
		}
	}

	@When("^user clicks JoinMeeting$")
	public void user_clicks_JoinMeeting() throws Exception{
		try {
			for (int i = 1; i < 3; i++) {
				if(i==1) {
					browserdriver = Htable.get("driver1");
				}else {
					browserdriver = Htable.get("driver2");
				}
				if(!ClickElement(browserdriver, "xpath", Pageobjects.button_JoinMeeting)) {
					Reporter.addStepLog("Join Meeting Button not clicked");
				}
			}

		} catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
			throw(e);
		}
	}

	@Then("^user should be able to login successfully$")
	public void user_should_be_able_to_login_successfully(){
		System.out.println("User is able to login");
	}

}

