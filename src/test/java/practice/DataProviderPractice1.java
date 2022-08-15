package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice1 {
	@Test(dataProvider="dataProviderTest")
	public void dataProviderTest(String src,String dest,int tkt)
	{
		System.out.println("book ticket from"+src+"to"+dest+"ticketprice"+tkt);
	}
	@DataProvider
	public Object[][]dataProviderTest()
	{
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="Lucknow";
		objArr[0][1]="Banglore";
		objArr[0][2]=7000;
		objArr[1][0]="Banglore";
		objArr[1][1]="Kerala";
		objArr[1][2]=4500;
		objArr[2][0]="Kerala";
		objArr[2][1]="Mumbai";
		objArr[2][2]=10000;
		
		return objArr;
	}

}
