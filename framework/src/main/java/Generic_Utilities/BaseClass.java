package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sdriver;
    
	@BeforeSuite(groups = {"smokeTest", "regressionTest"})
	public void BS()
	{
		System.out.println("DataBase connection");
	}
	
	@BeforeTest(groups = {"smokeTest", "regressionTest"})
	public void BT()
	{
		System.out.println("Parallel execution start");
	}
	
//	@Parameters("Browser")
	@BeforeClass(groups = {"smokeTest", "regressionTest"})
//	public void BC(String Browser) {
	
	public void BC() throws Throwable
	{	
		File_Utility flib = new File_Utility();
		String Browser = flib.getKeyAndValuePair("browser");
	
		 if (Browser.equalsIgnoreCase("chrome")) 
				driver = new ChromeDriver();
	          else if (Browser.equalsIgnoreCase("edge")) 
				driver = new EdgeDriver();
	          else if (Browser.equalsIgnoreCase("firefox")) 
				driver = new FirefoxDriver();
			  else 
				driver = new EdgeDriver();
		sdriver=driver;
		System.out.println("Launch the browser");
	}
	
	@BeforeMethod(groups = {"smokeTest", "regressionTest"})
	public void BM() throws Throwable
	{
		  File_Utility flib = new File_Utility();
		  String Url = flib.getKeyAndValuePair("url");
		  String Username = flib.getKeyAndValuePair("username");
		  String Password = flib.getKeyAndValuePair("password");
		  
		  HomePage home = new HomePage(driver);	
		  WebDriver_Utility wlib = new WebDriver_Utility();
		  wlib.maximizeWindow(driver);
		  wlib.waitForPageToLoad(driver);
		  
		  driver.get(Url);		  
		  LoginPage login = new LoginPage(driver);
		  login.loginToApp(Username, Password);
		  	
		System.out.println("Login into app");
	}
	
	@AfterMethod(groups = {"smokeTest", "regressionTest"})
	public void AM()
	{
		 HomePage home = new HomePage(driver);
		 home.logOut();
		System.out.println("Logout from App");
	}
	
	@AfterClass(groups = {"smokeTest", "regressionTest"})
	public void AC()
	{
		driver.quit();
		System.out.println("Close the browser");
	}
	
	@AfterTest(groups = {"smokeTest", "regressionTest"})
	public void AT()
	{
		System.out.println("Parallel Execution close");
	}
	
	@AfterSuite(groups = {"smokeTest", "regressionTest"})
	public void AS()
	{
		System.out.println("DataBase connection close");
	}

}
