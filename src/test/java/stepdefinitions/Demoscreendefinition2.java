package stepdefinitions;


import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import common.Generic;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import objects.Pageobjects;

public class Demoscreendefinition2 extends Generic{

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

	
	@When("^user tries to click Join Button$")
	public void ClickJoinButton() throws Exception {		
		try {
			for (int i = 1; i < 3; i++) {
				if(i==1) {
					browserdriver = Htable.get("driver1");
				}else {
					browserdriver = Htable.get("driver2");
				}	
				if(!IsElementPresent(browserdriver, "xpath", Pageobjects.button_JoinMeeting)) {
					Reporter.addStepLog("Join Meeting button not present");					
				}
			}			
		} catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
			throw(e);
		}
	}

	
}


