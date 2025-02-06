package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLookUpImg {
	
	public ProductLookUpImg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[title=\"Create Product...\"]")
	private WebElement productLookUp;

	//Getter methods
	public WebElement getProductLookUp() {
		return productLookUp;
	}

    //Business logics
	
	public void clickProductLookUp()
	{
	  productLookUp.click();
		
	}	
}
