package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import common.Generic;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/main/resources/Features",
		glue= {"stepdefinitions"},		
		plugin = {
				/*"pretty", "html:target/cucumberHtmlReport",
				"html:target/cucumberHtmlReport",     //  for html result
				"pretty:target/cucumber-json-report.json"   // for json result
				 */
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumberHtmlReport/report.html"},
		monochrome = true
		)

public class testrunner extends Generic{

	@BeforeClass
	public static void ReadExcelData() throws Exception{
		try{
			//class level Hash creation
			ClassHashMap_Creation();
			ReadExcelData_Config();
		}catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
			throw(e);
		}
	}
	
	@AfterClass
	public static void writeExtentReport() throws Exception {
		try{
			//Class level hashmap deletion
			ClassHashMap_Deletion();
			
			//load extent results extra configs
			Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
			Reporter.setSystemInfo("executed by user", System.getProperty("user.name"));
			Reporter.setSystemInfo("os", System.getProperty("os.name") + " 64Bit");        
			Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));        
			Reporter.setSystemInfo("Selenium", "3.14.0");
			Reporter.setSystemInfo("Maven", "3.6.0");
			Reporter.setSystemInfo("Java Version", System.getProperty("java.version"));
			Reporter.setTestRunnerOutput("Designed by Prawin.Kumar@philips.com");
		}catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
			throw(e);
		}
	}
}
