package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ValidateDeletePage {
		
		public ValidateDeletePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void ValidateDeletePageDetails(WebDriver driver, String PrdName)
		{
			List<WebElement> prdList = driver.findElements(By.xpath("(//table[@class=\"lvt small\"]/tbody/tr//td[3])[position()>1]"));
			  boolean flag=false;
			  for (WebElement PrdData : prdList)
			    {
			    	String data = PrdData.getText();
			    	if(data.contains(PrdName))
			    	{
			    		flag=true;
			    		break;
			    	}
				}
			    if(flag)
			    {
			    	System.out.println("Product name is deleted");
			    }
			    else
			    {
			    	System.out.println("product name is not deleted");	
			    }
		}

}
