package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ValidateCampWithProductPage {
	
	public ValidateCampWithProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateCampWithProductDetails(WebDriver driver)
	{
		
		String actualProdName = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();   
//        if(actualProdName.contains(PrdName)) {
//	        System.out.println("Product name is not created");
//                                            }  else {
//	        System.out.println("Product name is created");
//                                                    }
		return actualProdName;
		
		
	}

}
