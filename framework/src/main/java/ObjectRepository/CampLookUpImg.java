package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampLookUpImg {
	
	public CampLookUpImg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt=\"Create Campaign...\"]")
	
		private WebElement campLookup;
	
	@FindBy(xpath = "//img[@title=\"Select\"]")
	
	    private WebElement campproLookup;
		
// Getter methods
	
	public WebElement getCampLookup() {
		return campLookup;
	}
	
	public WebElement getCampproLookup() {
		return campproLookup;
	}
	
	//Business Logic
	
	public void ClickCampLookUp()
	{
		campLookup.click();
	}
	
	public void ClickCampProLookUp()
	{
		campproLookup.click();
	}
	
}
