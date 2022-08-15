package com.crm.uae.Neepro.GenericUtility;

import java.util.Random;
/*
 * --->It is used to generate Random number 
 * return type is int.	
 */
public class JavaUtility {
	public int randomNumber()
	{
		Random r=new Random();
		int num=r.nextInt(2000);
		return num;
	}

}
