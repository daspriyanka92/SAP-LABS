package com.comCast.genericlib;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.comCast.ObjectRepositorylib.SignUp;
import com.comCast.ObjectRepositorylib.SignUp;


public class BaseClass {
	
	public static WebDriverCommonUtil wblib = new WebDriverCommonUtil();
		public static WebDriver driver;
		public FileLib flib= new FileLib();
		
		@BeforeClass
		public void launchBrowser() throws Throwable
		{ /* get data  from property file*/
			System.out.println("Launch Browser");
			String browsername= flib.getPropertykeyvalue("browser");
			if(browsername.equals("chrome")) {
				driver=new ChromeDriver();
			}
			if(browsername.equals("firefox")) {
				driver= new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			
		}
		@BeforeMethod
		public void loginApp() throws Throwable
		{
			System.out.println("enter url");
		    String URL=flib.getPropertykeyvalue("url");
		   String FIRST=flib.getPropertykeyvalue("FirstName");
		   String LAST=flib.getPropertykeyvalue("LastName");
		   String EMAIL=flib.getPropertykeyvalue("Email");
		   String PASSWORD=flib.getPropertykeyvalue("password");
		   driver.get(URL);
		    SignUp lp=PageFactory.initElements(driver, SignUp.class);
		    Thread.sleep(2000);
		}
		
		@AfterClass
		public void closeBrowser() throws Throwable
		{
			System.out.println(".....CLOSE BROWSER......");
			driver.close();
		}
		
	}

