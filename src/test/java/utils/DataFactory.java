package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataFactory {
	
	
	public static String getCellData(int rowNum, int colNum, int sheetNum) throws IOException {
		File file = new File("./src/test/resources/mystoreTask3Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(sheetNum);
		
	    XSSFRow row = sheet.getRow(rowNum);
	    XSSFCell cell = row.getCell(colNum);
	    String cellData = getCellValue(cell);
	    workbook.close();
	    fis.close();
	    return cellData;
	    
	  
	    
		
		
	}
	
	public static Object[][] getExcelData(String filepath, int sheetNum) throws IOException{
	
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(sheetNum);
		
		int rowCount = sheet.getPhysicalNumberOfRows() -1;
		
		int cellDataCount = sheet.getRow(1).getPhysicalNumberOfCells();
		
		
		Object[][] data = new Object[rowCount][cellDataCount];
		
		for(int i = 1 ; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			int cellCount = row.getPhysicalNumberOfCells();
			for(int j = 0 ; j < cellCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i-1][j] =getCellValue(cell);
			}
		}
		
		workbook.close();
		fis.close();
		
		
		return data;
		
		
	}
	
	
	//String converter
	public static String getCellValue(XSSFCell cell) {
		switch (cell.getCellType()) {
		case NUMERIC:
			if(cell.getNumericCellValue()%1 ==0) {
				return String.valueOf((int) cell.getNumericCellValue());
			}
			return String.valueOf((int)cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		default:
			return cell.getStringCellValue();
		}
	}

}
