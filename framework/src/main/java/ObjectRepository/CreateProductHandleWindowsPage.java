package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductHandleWindowsPage {
	
	public CreateProductHandleWindowsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "search_txt")
	public WebElement searchtxt;
	
	@FindBy(name = "search")
	public WebElement searchfield;
	
	@FindBy(xpath = "//a[@href=\"javascript:window.close();\"]")
	public WebElement clickfield;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	public WebElement saveButton;

	//Getter methods
	
	public WebElement getSearchtxt() {
		return searchtxt;
	}	
	public WebElement getSearchfield() {
		return searchfield;
	}
	public WebElement getClickfield() {
		return clickfield;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business logics
	
	public void getsearchtext(String PrdName)
	{
		searchtxt.sendKeys(PrdName);
	}
	public void ClickSearchField()
	{
		searchfield.click();
	}
	public void ClickField()
	{
		clickfield.click();
	}
	public void ClickSaveButton()
	{
		saveButton.click();
	}
	
	
	
	

}
