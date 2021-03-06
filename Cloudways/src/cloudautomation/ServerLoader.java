package cloudautomation;

import java.net.MalformedURLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
public class ServerLoader {
	public static WebDriver driver;
	int one= 1;
	int two= 2;
	int Choice;
	  @BeforeTest
  public void beforeTest() throws InterruptedException {
		  System.out.println("Enter Your Choice:"+"\n" +"1: Firefox"+"\n"+"2: Chrome");

		  Scanner scanner = new Scanner (System.in);
		  Choice=scanner.nextInt();


		  if (one==Choice){

		
			
			System.setProperty("webdriver.gecko.driver","src\\Gecko\\geckodriver.exe");
//			FirefoxOptions options = new FirefoxOptions();
		//	options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); //This is the location where you have installed Firefox on your machine

			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(); 

	 //driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);

		driver.manage().window().maximize(); 
		driver.get("https://platform.cloudways.com");
	//	driver.wait(10000);
		Thread.sleep(10000);
  } 

	  else if (two==Choice){

	//	@BeforeTest
	  // public void beforeWebdriver(){
	        System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://platform.cloudways.com");
	        WebDriverWait wait = new WebDriverWait(driver, 60);
	        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    }
		//@AfterMethod defines this method has to run after every @Test methods 
		
	  }

}
