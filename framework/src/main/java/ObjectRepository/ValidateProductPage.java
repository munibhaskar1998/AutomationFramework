package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ValidateProductPage {
	
	public ValidateProductPage(WebDriver driver)	
	{		
		PageFactory.initElements(driver, this);		
	}
	
	public String ValidateProductDetails(WebDriver driver)
	{
		String actualData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		return actualData;
		
//		  if (actualData.contains(PrdName)) {
//				  System.out.println("Product Name is created");
//				                        	  } else {
//				  System.out.println("Product Name is not created");
//	                                                 }	
		
		
	}
}
