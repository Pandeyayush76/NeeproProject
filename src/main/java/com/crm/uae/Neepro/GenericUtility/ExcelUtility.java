package com.crm.uae.Neepro.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/*
	 * -->It is used to fetch the data from Excel file.To fetch the data from Excel we have to use ApachePoi .Inside ApachePoi there are  .xls file and  .xlsx file
	 * we have to install apachepoiooxml file to read/fetch the data from excel file.
	 * It will also throw FileNotFoundException which need to be handle by Throwable Interface .
	 * Workbook is an interface inside this one method is WorkbookFactory which is coming apache.poi.ss.usermodel.Workbook,which create one file inside 
	 * workbook from FileInputSteam.
	 * Inside an workbook different different sheets are present,to call particular sheet we have to call from Workbook ref.and pass the argument of Sheetname
	 * data type should be String . return type of this sheet is coming from apache.poi.ss.usermodel.Sheet.
	 */
      public String getDataFromExcelFile(String Sheetname,int rowNum,int cellnum) throws Throwable
      {
    	  FileInputStream fis=new FileInputStream("./Data/Practice.xlsx");
    	  Workbook book=WorkbookFactory.create(fis);
    	  Sheet sh=book.getSheet(Sheetname);
    	  DataFormatter format=new DataFormatter();
    	  book.close();
    	return  format.formatCellValue(sh.getRow(rowNum).getCell(cellnum));
    	  
    	 
    	 
      }
      /*
       * -->To fetch the data from last row value and last cell value
       */
      public int getLastRow(String Sheetname,int rowNum,short cellNum) throws Throwable
      {
    	  FileInputStream fis=new FileInputStream("./Data/Practice.xlsx");
    	  Workbook book=WorkbookFactory.create(fis);
    	  Sheet sh=book.getSheet(Sheetname);
    	  book.close();
    	  return sh.getLastRowNum();
    	 
      }
      /*
       * --->Fetch the last cellNum data in any row
       * Return type should be int.
       */
      public int getLastCellNum(String Sheetname,int rowNum) throws Throwable
      {
    	  FileInputStream fis=new FileInputStream("./Data/Practice.xlsx");
    	  Workbook book=WorkbookFactory.create(fis);
    	 Sheet sh= book.getSheet(Sheetname);
    	 Row r = sh.getRow(rowNum);
    	 return r.getLastCellNum();
    	 
      }
      /*
       *--> To write the data in an excel sheet;
       *Workbook is an interface inside this one method is WorkbookFactory which is coming apache.poi.ss.usermodel.Workbook,which create one file inside 
	 * workbook from FileInputSteam. 
	 * Inside an workbook different different sheets are present,to call particular sheet we have to call from Workbook ref.and pass the argument of Sheetname
	 * data type should be String . return type of this sheet is coming from apache.poi.ss.usermodel.Sheet.
	 * After this we have to call the row value and cellValue and one important we have to pass the some value that should be write inside that excel sheet 
	 * -->By using setCellValue() and inside this pass some arguments. 
	 * -->Create object for FileOutputStream to get the output from excel sheet which is present inside java FileOutputStream package and pass the path in argument.
       *-->Then for writing the data we have to call write()and pass the FileOutputStream ref.with the help of Workbook ref.
       *-->Then close the Workbook.
       */
      public void writeDataInExcelSheet(String Sheetname,int rowNum,int cellNum,String data) throws Throwable
      {
    	  FileInputStream fis=new FileInputStream("./Data/Practice.xlsx");
    	  Workbook book=WorkbookFactory.create(fis);
    	  Sheet sh=book.getSheet(Sheetname);
    	  sh.getRow(rowNum).getCell(cellNum).setCellValue(data);
    	  FileOutputStream fos=new FileOutputStream("./Data/Practice.xlsx");
    	  book.write(fos);
    	  fos.flush();
    	  book.close();
      }
}
