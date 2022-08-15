package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadSecondDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./Data/Practice.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("TestCase");
		int r=sh.getLastRowNum();
		for(int i=0;i<r;i++)
		{
			
			Row row=sh.getRow(i);
			String col1=row.getCell(0).getStringCellValue();
			String col2=row.getCell(1).getStringCellValue();
			System.out.println(col1+"\t"+col2);
		}
		

	}

}
