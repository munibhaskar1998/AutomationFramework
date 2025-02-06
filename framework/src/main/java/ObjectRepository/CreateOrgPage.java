package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {
	
	public CreateOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgName;
	
	@FindBy(name = "phone")
	private WebElement phnNum;
	
	@FindBy(id = "email1")
	private WebElement mail;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
 
	// Getter methods
	
	public WebElement getOrgName() {
		return orgName;
	}
	public WebElement getPhnNum() {
		return phnNum;
	}
	public WebElement getMail() {
		return mail;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}

	//Business logics
	
	public void getOrgDetails(String OrgName)
	{
		orgName.sendKeys(OrgName);
	}
	public void getPhnDetails(String phnNo)
	{
		phnNum.sendKeys(phnNo);
	}
	public void getMailId(String mailId)
	{
		mail.sendKeys(mailId);
	}
		
	public void clickSaveButton()
	{
		saveButton.click();
	}
	

}
