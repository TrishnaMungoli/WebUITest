/*package com.framework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	
	public FileOutputStream fileOut=null;
	public  String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	
	
	public ExcelReader(String path)  {	
				this.path=path;

	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public String[][] getDataFromSheet(String sheetName,String excelName)
	{
		String DataSet[][]=null;
		try {
			fis = new FileInputStream(path);
			workbook= new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
            //Will get a sheet from excel workbook
			XSSFSheet sheet =workbook.getSheet(sheetName);
			//count total active row
			int totalRow =sheet.getLastRowNum() +1;
			//total columns
			int totalCol= sheet.getRow(0).getLastCellNum();
			DataSet= new String[totalRow-1][totalCol];
	         for(int i=1;i<totalRow;i++){
	        	 XSSFRow rows=sheet.getRow(i);
	          for(int j=0;j<totalCol;j++){
	        	  XSSFCell cell=rows.getCell(j);
	        	  if(cell.getCellType()==cell.CELL_TYPE_STRING)
	        	  {
	        		  DataSet[i-1][j]=cell.getStringCellValue();
	        	  }
	        	  else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
	        	  {
	        		  String cellText= String.valueOf(cell.getNumericCellValue());
	        		  DataSet[i-1][j]= cellText;
	        	  }
	        	  else
	        	  {
	        		  DataSet[i-1][j]=String.valueOf(cell.getNumericCellValue());
	        	  }
	        	 }
	          
	         }
	         return DataSet;
	}
	
	public String[][] getData(String excelName, String sheetName) throws IOException {
		
		String[][] data = getDataFromSheet(sheetName, excelName);
		return data;
	}

	
}



*/