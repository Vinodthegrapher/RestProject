package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
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
import org.testng.annotations.DataProvider;

public class Utilities {


	@DataProvider(name = "testData")
	public static Object[][] readExcel(String fileName) throws IOException
	{
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\data1.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Sheet1");
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum=sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastCellNum][1];
		HashMap<String,String> hashData;
		for(int i =1; i < lastRowNum; i++){
			hashData=new HashMap<>();
			for (int j= 0; j < lastCellNum; j++) {
			String key= sheet.getRow(0).getCell(j).getStringCellValue();
			String value=sheet.getRow(i).getCell(j).getStringCellValue();
			hashData.put(key, value);
			}
			data[i-1][0]=hashData;
		}

		workbook.close();
		return data;
	}
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
