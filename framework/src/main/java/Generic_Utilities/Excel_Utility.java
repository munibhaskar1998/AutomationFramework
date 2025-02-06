package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

public class Excel_Utility {
	
	public String getExcelData(String sheetname, int rowNum, int cellNum) throws Throwable
	{
		//   FileInputStream fis1 = new FileInputStream("./src/test/resources/File.xlsx");
		     FileInputStream fis1 = new FileInputStream(IpathConstant.excelpath);
		   Workbook book = WorkbookFactory.create(fis1);
		   Sheet sheet = book.getSheet(sheetname);
		   Row row = sheet.getRow(rowNum);
		   Cell cell = row.getCell(cellNum);
		   String excelData = cell.getStringCellValue();
	       System.out.println(excelData);
		   return excelData;
		   	   
	}
	public String readExcelDataUsingFormatter(String sheetname, int rowNum, int cellNum) throws Throwable
	{
		//   FileInputStream fis1 = new FileInputStream("./src/test/resources/File.xlsx");
		     FileInputStream fis1 = new FileInputStream(IpathConstant.excelpath);
		   Workbook book = WorkbookFactory.create(fis1);
		   Sheet sheet = book.getSheet(sheetname);
		   Row row = sheet.getRow(rowNum);
		   Cell cell = row.getCell(cellNum);
		   
		 DataFormatter  format = new DataFormatter();
	     String ExcelData = format.formatCellValue(cell);
		 System.out.println(ExcelData);
		   
		   return ExcelData;
	}

}
