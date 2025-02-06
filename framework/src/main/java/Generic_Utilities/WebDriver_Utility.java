package Generic_Utilities;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility {
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	}

	public void moveToElement(WebDriver driver, WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().perform();		
	}
	public void windowSwitching (WebDriver driver, String partialValue)
	{
		Set<String> all = driver.getWindowHandles();
	    Iterator<String> it = all.iterator();
	   
	    while(it.hasNext()) {
		   String windows = it.next();
		   driver.switchTo().window(windows);
		   if (windows.contains(partialValue)) {
			                      break;
		                                            }
	                        } }
	    
	 public void alertAccept (WebDriver driver)
	    {
            driver.switchTo().alert().accept();
		}
	 
	 public static String takeScreenShotEx(WebDriver driver, String screenShotName) throws Throwable {
			
			TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
			File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
			File dst = new File("./ScreenShots/" + screenShotName +".png");
			FileUtils.copyFile(src, dst);
			return dst.getAbsolutePath();
		} 

	}

