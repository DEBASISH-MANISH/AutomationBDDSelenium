package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.StarterClass;

public abstract class Generic extends StarterClass{


	public boolean JSClickElement(WebDriver driver,String locatortype, String locatorvalue) throws Exception{	
		boolean val = false;
		try {						
			WebElement element = GetWebElement(driver, locatortype, locatorvalue);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);			
			val = true;
		} catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
			throw(e);
		}
		return val;
	}
	public boolean ClickElement(WebDriver driver,String locatortype, String locatorvalue) throws Exception{	
		boolean val = false;
		try {						
			WebElement element = GetWebElement(driver, locatortype, locatorvalue);			
			element.click();
			val = true;
		} catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
			throw(e);
		}
		return val;
	}


	public boolean SetText(WebDriver driver,String locatortype, String locatorvalue,String texttoset) throws Exception {
		boolean val = false;
		try {
			ClickElement(driver, locatortype, locatorvalue);			
			WebElement element = GetWebElement(driver, locatortype, locatorvalue);			
			element.sendKeys(texttoset);
			val = true;
		} catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
			throw(e);
		}
		return val;
	}

	public WebElement GetWebElement(WebDriver driver,String locatortype, String locatorvalue) throws Exception {

		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			switch (locatortype.toString().toLowerCase()) {
			case "xpath":			
				element = browserdriver.findElement(By.xpath(locatorvalue.toString()));				
				break;
			case "id":
				element = browserdriver.findElement(By.id(locatorvalue.toString()));				
				break;
			case "name":
				element = browserdriver.findElement(By.name(locatorvalue.toString()));				
				break;
			case "css":
				element = browserdriver.findElement(By.cssSelector(locatorvalue.toString()));				
				break;
			}			
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Thread.sleep(2000);
		} catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
			throw(e);
		}
		return element;
	}

	public void WaitForElement(WebDriver driver,String locatortype, String locatorvalue) throws Exception {	
		try {		
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement ele = GetWebElement(driver, locatortype, locatorvalue);			
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		} catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
			throw(e);
		}
	}

	public boolean IsElementPresent(WebDriver driver,String locatortype, String locatorvalue) throws Exception {
		boolean val = false;
		try {

			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement ele = null;

			switch (locatortype.toString().toLowerCase()) {
			case "xpath":			
				ele = browserdriver.findElement(By.xpath(locatorvalue.toString()));				
				break;
			case "id":
				ele = browserdriver.findElement(By.id(locatorvalue.toString()));				
				break;
			case "name":
				ele = browserdriver.findElement(By.name(locatorvalue.toString()));				
				break;
			case "css":
				ele = browserdriver.findElement(By.cssSelector(locatorvalue.toString()));				
				break;
			}
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			Thread.sleep(2000);
			val = true;
		} catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
			throw(e);
		}
		return val;
	}

	public void SwitchHandle(WebDriver driver) throws Exception {
		try {
			String parentWindowHandler = browserdriver.getWindowHandle();
			browserdriver.switchTo().window(parentWindowHandler);
		} catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
			throw(e);
		}
	}
}


