package crm.crm.vtiger.genericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.vtiger.objectRepo.HomePage;
import com.crm.vtiger.objectRepo.LoginPage;

public class BaseClass 
{
	
	public WebDriver driver;
	public static WebDriver sdriver;
	/*Creating Lib Obj*/
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	
	@BeforeSuite
	public void configBS()
	{
		System.out.println("====Database Connection Established====");
	}
	
	
	@BeforeClass
	public void configBC() throws Throwable
	{
		if(fLib.getPropertyKeyValue("browser").equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(fLib.getPropertyKeyValue("browser").equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.err.println("Invalid Browser");
		}
		sdriver=driver;
	}
	
	@BeforeMethod
	public void configBM() throws Throwable
	{
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		/*LOGIN*/
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}
	
	
	@AfterMethod
	public void configAM()
	{
		/*LOGOUT*/
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass
	public void configAC()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("====Closing DataBase Connection====");
	}
}
