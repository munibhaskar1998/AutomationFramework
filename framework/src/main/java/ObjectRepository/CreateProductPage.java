package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	public CreateProductPage(WebDriver driver)
	{
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	private WebElement proname;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	//Getter methods
	public WebElement getProname() {
		return proname;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business logics
	
	public void getProDetails(String PrdName)
	{
	       proname.sendKeys(PrdName);
	}
	
	public void clickSaveButton()
	{
		saveButton.click();
	}
	

}
