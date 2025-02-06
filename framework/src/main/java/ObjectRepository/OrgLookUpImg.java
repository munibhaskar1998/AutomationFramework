package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgLookUpImg {
	
	public OrgLookUpImg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[alt='Create Organization...']")
	private WebElement orgLookUp;

	//getter method
	
	public WebElement getOrgLookUp() {
		return orgLookUp;
	}

	
	//Business logic
	public void clickOrgLookUp()
	{
		orgLookUp.click();
	}
	
	

}
