package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import ObjectRepository.CreateProductHandleWindowsPage;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductLookUpImg;
import ObjectRepository.ValidateCampPage;
import ObjectRepository.ValidateCampWithProductPage;
import ObjectRepository.ValidateProductPage;

@Listeners(Generic_Utilities.ExtentReportImp.class)

public class createcampwithproductTest extends BaseClass {
	@Test
//	@Test(retryAnalyzer = Generic_Utilities.RetryImp.class)
 //   @Test(groups = "smokeTest")
	public void createcampwithproductTest()  throws Throwable {
		
		  Java_Utility javuti = new Java_Utility();
		  Excel_Utility excuti = new Excel_Utility();
		  WebDriver_Utility wlib = new WebDriver_Utility();
		  	  
		  HomePage home = new HomePage(driver);
		  home.clickPrdLink();  
		  ProductLookUpImg proimg = new ProductLookUpImg(driver);
		  proimg.clickProductLookUp();
		  int ranNum = javuti.getRandomNum();
          String PrdName = excuti.getExcelData("Sheet2", 0 , 0) + ranNum;
	      
	      CreateProductPage crepropage = new CreateProductPage(driver);
	      crepropage.getProDetails(PrdName);
	      crepropage.clickSaveButton();		
		  home.clickMoreLink();
		  home.clickCampLink();	  
		  CampLookUpImg img = new CampLookUpImg(driver);
          img.ClickCampLookUp();
		  String CampName = excuti.getExcelData("Sheet3", 0 , 0) + ranNum;
 		  
 		 CreateCampPage crecamppage = new CreateCampPage(driver);
         crecamppage.getCampDetails(CampName);
         img.ClickCampProLookUp();
         	    
         wlib.windowSwitching(driver, "Products&action");
	     CreateProductHandleWindowsPage cphw = new CreateProductHandleWindowsPage(driver);
	     cphw.getsearchtext(PrdName);
	     cphw.ClickSearchField();
	     cphw.ClickField(); 
	     wlib.windowSwitching(driver, "Campaigns&action");
	     cphw.ClickSaveButton();
         
         ValidateCampPage valCampPage = new ValidateCampPage(driver);
	    String actualData = valCampPage.ValidateCampDetails(driver);
	     Assert.assertEquals(actualData, CampName);
	      System.out.println("Camp is validated");
   
         ValidateCampWithProductPage vcwpp = new ValidateCampWithProductPage(driver);
	    String actualProdName = vcwpp.ValidateCampWithProductDetails(driver);
	    Assert.assertEquals(actualProdName, PrdName);
	    System.out.println("Product is validated");
	    
	    System.out.println("I am an engineer");
        
	}
    
 
}