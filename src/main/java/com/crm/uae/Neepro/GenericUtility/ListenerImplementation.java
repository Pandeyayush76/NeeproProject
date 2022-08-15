package com.crm.uae.Neepro.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener
{
	private ExtentReports r;
	private ExtentTest test;
	

	@Override//@BeforeMethod
	public void onTestStart(ITestResult result) {
		test=r.createTest(result.getMethod().getMethodName());
		
	}

	@Override//@AM
	public void onTestSuccess(ITestResult result) {
		/*
		 String testName=result.getMethod().getMethodName();
		 TakesScreenshot ts=(TakesScreenshot)BaseClass.listenerdriver;
		 File src= ts.getScreenshotAs(OutputType.FILE);
		 String date=new Date().toString().replace(":","_");
		 File trg=new File("./Vtiger/"+testName+date+".png");
		 
		 try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	
		//company work structure
		test.pass(result.getMethod().getMethodName()+" pass test");
		
		
	}
	
		

	@Override
	public void onTestFailure(ITestResult result) 
	{
		/*
	 String testName=result.getMethod().getMethodName();
	 TakesScreenshot ts=(TakesScreenshot)BaseClass.listenerdriver;
	 File src= ts.getScreenshotAs(OutputType.FILE);
	 File trg=new File("./Vtiger/"+testName+".png");
	 
	 try {
		FileUtils.copyFile(src, trg);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/
		//test.fail(null)
		
		//for failing syntax
		String extent=result.getMethod().getMethodName();
	TakesScreenshot ts=(TakesScreenshot)BaseClass.listenerdriver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File trg=new File("./ExtentReportFolder/"+extent+".png");
	try {
		FileUtils.copyFile(src, trg);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 test.fail(result.getMethod().getMethodName()+"failed test case");
	 test.fail(result.getThrowable());
	 test.addScreenCaptureFromPath(trg.getAbsolutePath());
	 
	}

	@Override//@BM
	public void onTestSkipped(ITestResult result) {
/*
		TakesScreenshot ts1=(TakesScreenshot)BaseClass.listenerdriver;
		 File src= ts1.getScreenshotAs(OutputType.FILE);
		 File trg=new File("./Vtiger/Campaign1.png");
		 try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	*/
		//generic method for company skipping
		test.skip(result.getMethod().getMethodName()+"Skipped test");
		test.skip(result.getThrowable());
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override//@BT
	public void onStart(ITestContext context) {
		//creating report
		
				ExtentSparkReporter reports=new ExtentSparkReporter("./Extent_report/ProjectReport.html");
				
				//creating title
				reports.config().setDocumentTitle("Reports");
				
				//set reporter name
				reports.config().setReportName("Regression");
				
				//adjusting theme
				reports.config().setTheme(Theme.DARK);
				
				//provide folder structure of report, create an object of extent reports and provide
			    r=new ExtentReports();
				r.attachReporter(reports);
				r.setSystemInfo("Reporter name","Ayush");
				r.setSystemInfo("Platform", "Windows 11");
				r.setSystemInfo("Browser","Chrome");
				
		
	}

	@Override//@AT
	public void onFinish(ITestContext context) {
		r.flush();
		
	}

}
