package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel1 {
//To fetch all data from excelsheet
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./Data/Practice.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("TestCase");
		int lastrow=sh.getLastRowNum();
		for(int i=0;i<=lastrow;i++)
		{
			Row row=sh.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				DataFormatter format=new DataFormatter();
				String s=format.formatCellValue(row.getCell(j));
				System.out.print(s+"\t");
			}
		System.out.println();
		}
		

	}

}
