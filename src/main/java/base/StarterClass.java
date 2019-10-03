package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;

public abstract class StarterClass{

	//object declaration
	public static WebDriver browserdriver;	
	public static HashMap<String, String> Class_Hmap;
	public static Hashtable<String, WebDriver> Htable;

	public void TestScenario_Initiation() throws Exception {
		try {
			//scenario level Hash creation	
			HashTable_Creation();			
		} catch (Exception e) {
			throw(e);
		}
	}
	
	public void TestScenario_Completition() throws Exception {
		try {
			tearDown();			
			HashTable_Deletion();			
		} catch (Exception e) {
			throw(e);
		}
	}
		
	/*public void HashMap_Creation() throws Exception {
		Hmap = new HashMap<String, String>();		
	}*/
	
	public static void ClassHashMap_Creation() throws Exception {
		Class_Hmap = new HashMap<String, String>();		
	}

	public void HashTable_Creation() throws Exception {
		Htable = new Hashtable<String, WebDriver>();
	}

	/*public void HashMap_Deletion() throws Exception {
		Hmap.clear();
	}*/
	
	public static void ClassHashMap_Deletion() throws Exception {
		Class_Hmap.clear();
	}

	public void HashTable_Deletion() throws Exception {
		Htable.clear();
	}

	@SuppressWarnings("resource")
	public static void ReadExcelData_Config() throws Exception {
		try {
			// Specify the path of file
			File src=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\TestData.xlsx");
			// load file
			FileInputStream fis=new FileInputStream(src);
			// Load workbook
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			// Load sheet- Here we are loading first sheetonly
			XSSFSheet sh1= wb.getSheetAt(0);

			Class_Hmap.put("env",sh1.getRow(1).getCell(0).getStringCellValue().toString());			
			Class_Hmap.put("provider",sh1.getRow(1).getCell(1).getStringCellValue().toString());
			Class_Hmap.put("tobeexecuted",sh1.getRow(1).getCell(2).getStringCellValue().toString());
			Class_Hmap.put("url",sh1.getRow(1).getCell(3).getStringCellValue().toString());
			Class_Hmap.put("settings",sh1.getRow(1).getCell(4).getStringCellValue().toString());
			Class_Hmap.put("fm_meetingkey",sh1.getRow(1).getCell(5).getStringCellValue().toString());
			Class_Hmap.put("twilio_meetingkey1",sh1.getRow(1).getCell(6).getStringCellValue().toString());
			Class_Hmap.put("twilio_meetingkey2",sh1.getRow(1).getCell(7).getStringCellValue().toString());			
			fis.close();

		} catch (Exception e) {		
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
			throw(e);
		}
	}

	public WebDriver OpenBrowser(WebDriver driver, String BrowserName) throws Exception {		
		try {
			switch (BrowserName.toLowerCase()) {
			case "chrome":
			case "ch":
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
				browserdriver = new ChromeDriver();				
				browserdriver.manage().window().maximize();
				break;
			case "firefox":
			case "ff":
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\geckodriver.exe");
				browserdriver = new FirefoxDriver();				
				browserdriver.manage().window().maximize();
				break;			
			}
		} catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
			throw(e);
		}
		return driver;
	}

	public void tearDown()  {
		try {	
			Htable.get("driver1").quit();
			Thread.sleep(2000);
			Htable.get("driver2").quit();
		} catch (Exception e) {
			
		}		
	}

	public void OpenURL(WebDriver driver) throws Exception {
		try {			
			browserdriver.get(Class_Hmap.get("url"));
		} catch (Exception e) {
			String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
			String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
			ErrorReporter(exception_classname, exception_methodname, e);
			throw(e);
		}
	}

	public void AddScreenshot(Scenario scenario) throws Exception {		
		for (int i = 1; i < 3; i++) {
			if(i==1) {
				browserdriver = Htable.get("driver1");
			}else {
				browserdriver = Htable.get("driver2");
			}
			if (scenario.isFailed())
			{
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				try
				{
					File sourcePath = ((TakesScreenshot) browserdriver).getScreenshotAs(OutputType.FILE);
					File destinationPath = new File(System.getProperty("user.dir")+"\\target\\screenshots\\"+ screenshotName+".png");
					FileUtils.copyFile(sourcePath, destinationPath);   
					Reporter.addScreenCaptureFromPath(destinationPath.toString());
				} 
				catch (IOException e)
				{
					String exception_classname = new Object(){}.getClass().getName().replace("$", "");			
					String exception_methodname = new Object(){}.getClass().getEnclosingMethod().getName();
					ErrorReporter(exception_classname, exception_methodname, e);
					throw(e);
				}
			}
		}

	}

	public static void ErrorReporter(String classname, String methodname, Exception e) throws Exception {		
		try {
			classname = removeLastChar(classname);
			Class_Hmap.put("exception_class", classname);		
			Class_Hmap.put("exception_method", methodname);		
			Reporter.addStepLog("Exception occured in class : "+Class_Hmap.get("exception_class").trim()+" and in method : "+Class_Hmap.get("exception_method").trim().replace("$", ""));		
			Reporter.addStepLog("Exception Message : "+e.getMessage());
		} catch (Exception e1) {
			throw(e1);
		}
	}
	

	public static String removeLastChar(String str) throws IOException {
		return str.substring(0, str.length() - 1);
	}
}


