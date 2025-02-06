package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidateCampPage {
	
	public ValidateCampPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public String ValidateCampDetails(WebDriver driver)
	{
		String actualData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
//        if (actualData.contains(CampName)) {
//		     System.out.println("Campaign name is created");
//		                                      } else {
//		     System.out.println("Campaign name is not created");
//                                                   }
		return actualData;
        
        
	}
}
