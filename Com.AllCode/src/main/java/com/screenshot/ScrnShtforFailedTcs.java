package com.screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrnShtforFailedTcs {
	public static WebDriver driver;
	@Test
	public void TestCase1_Open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
	}

	@Test
   public void TestCase2_() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Assert.assertTrue(false);
	}

	@AfterMethod
  public void TestCase3_(ITestResult result) throws IOException, InterruptedException {
	if(ITestResult.FAILURE == result.getStatus()) {
		 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // FileUtils.copyFile(screenshotFile, new File("C:\\JavaWorkPlace\\Com.AllCode\\screenshot\\Sample.png") );
		 
		 FileUtils.copyFile(screenshotFile, new File("C:\\JavaWorkPlace\\Com.AllCode\\screenshot\\" +result.getName() +".png") );
         Thread.sleep(3000);
		
	}
	driver.close();
	
	
  }
	
}
