package com.orangeHRM.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;


public class ScreenshotListener implements ITestListener,IRetryAnalyzer,IAnnotationTransformer{
	//WebDriver driver=null;
	int counter = 0;
	int Limit = 3;
	
	public static void takesnapshot(WebDriver driver, File FileName) throws IOException
	{
		File SrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(SrcFile, FileName);
			
	}
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase that failed is :"+result.getName());
		String screenshotDirectory = System.getProperty("screenshotDirectory", "target/screenshots");
		String screenshotAbsolutePath = screenshotDirectory + File.separator + System.currentTimeMillis() + "_"
				+ result.getName() + ".png";
		File screenshot = new File(screenshotAbsolutePath);
		WebDriver driver1 = (WebDriver)result.getTestContext().getAttribute("driver");
		try {
			takesnapshot(driver1, screenshot);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" test case started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase that passed is :"+result.getName());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase that Skipped is :"+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
	}


	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
	{
		annotation.setRetryAnalyzer(ScreenshotListener.class);
		
	}


	@Override
	public boolean retry(ITestResult result) {
		if(counter < Limit)
		{
			counter++;
			return true;
		}
		return false;
	}

	

}
