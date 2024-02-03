package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static String getDataFromExcelSheet(String filePath,String sheetName, int rowNo, int cellNo) throws IOException 
	{
		String data = "";
		FileInputStream file = new FileInputStream(filePath);
		
	     Workbook workbook = WorkbookFactory.create(file);
	     Sheet sheet = workbook.getSheet(sheetName);
	      Row row = sheet.getRow(rowNo);
		  Cell cell = row.getCell(cellNo);
		try
		{
			data = cell.getStringCellValue();
		}
		
		catch(IllegalStateException e)
		{
			double value = cell.getNumericCellValue();
			String  doubleToString = String.valueOf(value);
			data = doubleToString;
		}
		
		catch(NullPointerException e)
		{
			System.out.println("Cell is Blank");
		}
		
		workbook.close();
		return data;
		
	}
	
	public static  void captureScreenshot(WebDriver driver, String filePath,String testID) throws IOException
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH mm ss");  
		   LocalDateTime now = LocalDateTime.now();
		
		File dest = new File(filePath+"//"+testID+dtf.format(now)+".jpeg");
		
		FileHandler.copy(src, dest);
	}

	public static String readProperties(String key, String fileName) throws IOException {
		FileInputStream fi= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Properties\\"+fileName+".properties");
		Properties prop= new Properties();
		prop.load(fi);
		String value=prop.getProperty(key);
		System.out.println("reading data from "+ fileName + " is successfully completed and we have fetched value of " + key);
		return value;
	}

}
