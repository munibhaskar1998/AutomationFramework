package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidateOrgPage {
	
	public ValidateOrgPage(WebDriver driver) 
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateOrgDetails(WebDriver driver)
	{
		String actualData = driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText();
//	      if (actualData.contains(OrgName)) 
//	        System.out.println("Organization name is created");
//	    	else
//	    	System.out.println("Organization name is not created");
		return actualData;
		
		
		
	}

}
