package MyPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./Data/Practice.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("TestCase");
		sh.createRow(0).createCell(1).setCellValue("Jhakas");
		FileOutputStream fos=new FileOutputStream("./Data/Practice.xlsx");
		book.write(fos);
		fos.flush();
		System.out.println("pass");
		book.close();
		
		

	}

}
