package com.qa.pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.Utilities.ReadConfig;


public class TestBase {

	ReadConfig readconfig=new ReadConfig();


	public String baseURL= readconfig.getApplicationURL();
	public String inputdata = readconfig.getTextData();
	public static WebDriver driver;
	public static Logger logger;


	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) throws InterruptedException {

		logger = Logger.getLogger("Weinvest");
		PropertyConfigurator.configure("Log4j.properties");

		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}else if (br.equals("ff")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver = new ChromeDriver();

		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		Thread.sleep(4000);

	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();

	}
	
	public static void pageLoad() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	}



	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}



}
