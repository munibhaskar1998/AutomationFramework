package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
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
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepository.CreateDeletePage;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductLookUpImg;
import ObjectRepository.ValidateDeletePage;
import ObjectRepository.ValidateProductPage;

public class CreateProductAndDeleteProductTest extends BaseClass {
    @Test(groups = "regressionTest")
	public void CreateProductAndDeleteProductTest() throws Throwable {
		
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
	      ValidateProductPage valpropage = new ValidateProductPage(driver);
		  valpropage.ValidateProductDetails(driver);		
		  home.clickPrdLink();
		  
          CreateDeletePage deletebox = new CreateDeletePage(driver);
          Thread.sleep(2000);
          deletebox.selectPrd(driver, PrdName);
          deletebox.ClickDeleteButton();
		  
		  Thread.sleep(2000);
		  wlib.alertAccept(driver);
		  
		  ValidateDeletePage deletepage= new ValidateDeletePage(driver);
		  deletepage.ValidateDeletePageDetails(driver, PrdName);
		  
		  driver.quit();
		  
		  System.out.println("I am working in Tech Mahindra");
		  		  					
		}
	}


