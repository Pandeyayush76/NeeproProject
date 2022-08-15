package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(dataProvider="dataProvider_bookTicket")
public class DataProviderPractice {
	public void bookTicket(String src,String dest)
	{
		System.out.println("Book ticket from"+src+"to"+dest);
	}
	@DataProvider
	public Object[][] dataProvider_bookTicket()
	{
		Object[][] objArr=new Object[5][2];
		objArr[0][0]="Banglore";
		objArr[0][1]="Lucknow";
		objArr[1][0]="Banglore";
		objArr[1][1]="Delhi";
		objArr[2][0]="Banglore";
		objArr[2][1]="Goa";
		objArr[3][0]="Banglore";
		objArr[3][1]="Kerala";
		objArr[4][0]="Banglore";
		objArr[4][1]="Mumbai";
		
				
		return objArr;
		
	}

}
