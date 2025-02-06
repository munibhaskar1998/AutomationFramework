package exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
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

import Generic_Utilities.Java_Utility;

public class CreateContactWithOrganisation {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
		
	//	Random ran = new Random();
    //	int ranNum = ran.nextInt(1000);
		
		Java_Utility javuti = new Java_Utility();
		int ranNum = javuti.getRandomNum();
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/File.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		
//---------------------------------------------------------------------------------------------------------
		
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(0);
	    Cell cell = row.getCell(0);
	    String OrgName = cell.getStringCellValue()+ ranNum;
		System.out.println(OrgName);
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//----------------------------------------------------------------------------------------------------------
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Contacts&action=index\"]")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
	    Sheet sheet1 = book.getSheet("Sheet4");
	    Row row1 = sheet1.getRow(0);
	    Cell cell1 = row1.getCell(0);
	    String ContactInfo = cell1.getStringCellValue()+ ranNum;
	    System.out.println(ContactInfo);
	    driver.findElement(By.name("lastname")).sendKeys(ContactInfo);
	    driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
	    
	    Set<String> wrt = driver.getWindowHandles();
	    Iterator<String> it = wrt.iterator();
	   
	    while(it.hasNext()) {
		   String windows = it.next();
		   driver.switchTo().window(windows);
		   if (windows.contains("Accounts&action")) {
			                      break;
		                                            }
	                        }
	    
	    driver.findElement(By.id("search_txt")).sendKeys(OrgName);
	    driver.findElement(By.name("search")).click();
	    driver.findElement(By.xpath("//a[@href=\"javascript:window.close();\"]")).click();
	    
	    Set<String> wrt1 = driver.getWindowHandles();
	    Iterator<String> it1 = wrt1.iterator();
   
        while(it1.hasNext()) {
	        String windows1 = it1.next();
	        driver.switchTo().window(windows1);
	        if(windows1.contains("Contacts&action")) {
		                         break;
	                                              }
	                           }
	    
	   driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
	   
//-------------------------------------------------------------------------------------------------------
	   
	   String actuallastname = driver.findElement(By.xpath("//span[@id=\"dtlview_Last Name\"]")).getText();
       if (actuallastname.contains(ContactInfo)) {
	         System.out.println("Last name of the person is created");
	                                          } else {
		     System.out.println("Last name of the person is not created");
	                                                 }
   
      String actualOrgName = driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=DetailView&record=11\"]")).getText();  
       if(actualOrgName.contains(OrgName)) {
	        System.out.println("Organisation name is created");
                                            }  else {
	        System.out.println("Organisation name is not created");
                                                    } 
       
       driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
       driver.findElement(By.linkText("Sign Out")).click();

	}

}
