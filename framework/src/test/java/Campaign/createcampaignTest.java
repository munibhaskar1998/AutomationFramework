package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepository.CampLookUpImg;
import ObjectRepository.CreateCampPage;
import ObjectRepository.HomePage;
import ObjectRepository.ValidateCampPage;


@Listeners(Generic_Utilities.ExtentReportImp.class)

public class createcampaignTest extends BaseClass {
	
//	@Test(retryAnalyzer = Generic_Utilities.RetryImp.class)
	
	@Test
//	@Test(groups = "smokeTest")
	public void createcampaignTest() throws Throwable {
		 
		  Java_Utility javuti = new Java_Utility();
		  Excel_Utility excuti = new Excel_Utility();
		  HomePage home = new HomePage(driver);		  

		  home.clickMoreLink();
		  home.clickCampLink();
          CampLookUpImg img = new CampLookUpImg(driver);
          img.ClickCampLookUp();  
          int ranNum = javuti.getRandomNum();
           
          String CampName = excuti.getExcelData("Sheet3", 0 , 0) + ranNum;  
          
// Assert.fail("Failing test script");
          CreateCampPage crecamppage = new CreateCampPage(driver);
          crecamppage.getCampDetails(CampName);
          crecamppage.clickSaveButton();	      
	      ValidateCampPage valCampPage = new ValidateCampPage(driver);
	      String actualData = valCampPage.ValidateCampDetails(driver);
	      Assert.assertEquals(actualData, CampName);
	      System.out.println("Camp is validated");
	      
	      System.out.println("Hi");
	      System.out.println("Hello Bhaskar");
	         
	}

}
