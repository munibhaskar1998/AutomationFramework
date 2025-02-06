package organisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepository.CreateOrgPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrgLookUpImg;
import ObjectRepository.ValidateOrgPage;

public class CreateOrganisationTest extends BaseClass {
	
	
    @Test(groups = { "regressionTest", "smokeTest"})
	public void CreateOrganisationTest() throws Throwable {
		
		  Java_Utility javuti = new Java_Utility();
		  Excel_Utility excuti = new Excel_Utility();
	  
		  HomePage home = new HomePage(driver);		 
		  home.clickOrgLink();		  
		  OrgLookUpImg img = new OrgLookUpImg(driver);
	      img.clickOrgLookUp();	      
		  int ranNum = javuti.getRandomNum();
		  CreateOrgPage creOrgPage = new CreateOrgPage(driver);
		
		  String OrgName = excuti.getExcelData("Sheet1", 0 , 0) + ranNum;
		  creOrgPage.getOrgDetails(OrgName);

		  String phnNum = excuti.readExcelDataUsingFormatter("Sheet1", 1, 0);
	      creOrgPage.getPhnDetails(phnNum);

	      String email = excuti.readExcelDataUsingFormatter("Sheet1", 2, 0);
          creOrgPage.getMailId(email);

		  creOrgPage.clickSaveButton();  
	      ValidateOrgPage val = new ValidateOrgPage(driver);
	     String actualData = val.validateOrgDetails(driver);
	     Assert.assertEquals(actualData, OrgName);
	      System.out.println("Org is validated");
	      
	}
}   
	    
	    
	    
	


