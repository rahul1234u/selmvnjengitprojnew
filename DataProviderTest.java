package Advance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderTest 

{

	WebDriver driver;
	
	
	@BeforeClass
	
	public void Setprop()
	{
		//Set System properties
		System.setProperty("webdriver.chrome.driver", "D://SeedInfoAut//SeleniumSetup//chromedrivernew//chromedriver_win32//chromedriver.exe");
		
	}
	
	
	
	
	@BeforeTest
	
		public void BeforeLoginTest()
	
			{
				
										
				driver = new ChromeDriver();
						
				driver.manage().window().maximize();
				
				driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
				
			//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
				
				
			}
		
	
		
	
	@Test (groups = {"sanity"} , dataProvider = "getData")
	
	
		public void LoginTest(String username, String password) throws InterruptedException
		
			{
				
				driver.findElement(By.id("txtUsername")).sendKeys(username);
				
				driver.findElement(By.id("txtPassword")).sendKeys(password);
				
				driver.findElement(By.id("btnLogin")).click();
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
	
				driver.findElement(By.linkText("Welcome Admin")).click();
				
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[text()='Logout']")).click();;
			}
	
		
	@DataProvider
	 
		  public Object[][] getData() 
	
			{
			 
			  Object[][] data =  new Object[2][2];
					  
				{
				      data[0][0] = "admin";
				      data[0][1] = "admin123";
				    		      
				      data[1][0] = "admin4";
				      data[1][1] = "admin4";
				   		
				    
				      return data;
		        }
				
			}
	
	
	
	@AfterTest
	
	public void AfterT()
	{
		System.out.println("Test Successful");
	}
	
	
	
	@AfterClass
	
		public void CloseBrowser()
			
			{
				driver.quit();
			}
		
}
