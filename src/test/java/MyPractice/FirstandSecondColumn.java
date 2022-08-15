package MyPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstandSecondColumn {

	public static void main(String[] args) throws Throwable {
	WebDriverManager.chromedriver().setup();
	FileInputStream fis=new FileInputStream("./Data/Practice.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet("TestCase");
	int r=sh.getLastRowNum();
	for(int i=0;i<r;i++)
	{
		Row k=sh.getRow(i);
		String col1=k.getCell(0).getStringCellValue();
		String col2=k.getCell(1).getStringCellValue();
		System.out.println(col1+"\t"+col2);
	}

	}

}
