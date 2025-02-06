package Generic_Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	
	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./failedScript3.png");
		
		try {
			FileUtils.copyFile(src, dest);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
					}
				
	}
	
	
}
