package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDeletePage {
	
	public CreateDeletePage(WebDriver driver)	
	{		
		PageFactory.initElements(driver, this);		
	}
	
	public void selectPrd(WebDriver driver, String PrdName)
	{
		 driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+ PrdName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
	}
	
	@FindBy(xpath = "//input[@value=\"Delete\"]")
	private WebElement deleteButton;

	
	public WebElement getDeleteButton() {
		return deleteButton;
	}

    //Business logics
	
	public void ClickDeleteButton()
	{
		deleteButton.click();
	}
	
	

}
