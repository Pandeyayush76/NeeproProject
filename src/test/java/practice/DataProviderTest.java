package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider="bookTicket_DataProvider")
	public void bookTicket(String src,String dst,int tkt)
	{
		System.out.println("Source"+src+"Destination"+dst+"ticket"+tkt);
	}
	@DataProvider
	public Object[][]bookTicket_DataProvider()
	{
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="Banglore";
		objArr[0][1]="Lucknow";
		objArr[0][2]= 8000;
		objArr[1][0]="Banglore";
		objArr[1][1]="Noida";
		objArr[1][2]=7000;
		objArr[2][0]="Banglore";
		objArr[2][1]="Mumbai";
		objArr[2][2]=5000;
		return objArr;
		
	}

}
