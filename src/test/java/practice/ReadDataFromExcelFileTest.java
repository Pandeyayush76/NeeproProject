package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFileTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./Data/Practice.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("TestCase");
		DataFormatter format=new DataFormatter();
		String s=format.formatCellValue(sh.getRow(0).getCell(2));
		System.out.println(s);

	}

}
