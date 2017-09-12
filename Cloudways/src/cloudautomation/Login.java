package cloudautomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Login extends ServerLoader{
	
	HSSFWorkbook workbook;
    HSSFSheet sheet;
    HSSFCell cell;
  @Test
  public void LoginUser() throws IOException {
	   //WebDriver driver=ServerLoader.driver;
	   
File src=new File("C:\\Users\\Shafiq ur Rehman\\Desktop\\Data.xls");
	  
	  FileInputStream finput = new FileInputStream(src);
	  
      
	  
      // Load he workbook.
 
     workbook = new HSSFWorkbook(finput);
     sheet= workbook.getSheetAt(1);
     
     String email = sheet.getRow(0).getCell(0).toString();
     String Password = sheet.getRow(0).getCell(1).toString();
     
     System.out.println(Password);
  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  
  driver.findElement(By.id("input_0")).sendKeys(email);
  driver.findElement(By.id("input_1")).sendKeys(Password);
  driver.findElement(By.xpath(".//*[@id='cw-app_container']/div/section/div[2]/div[3]/form/div[9]/button")).click();
  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

  driver.findElement(By.xpath(".//*[@id='select_13']")).click();
  }
  @Test
  public void step2() throws InterruptedException {
	  
	  //WebDriver driver=ServerLoader.driver;
	 
	  sheet= workbook.getSheetAt(2);
		// Thread.sleep(5000);
	  String app = sheet.getRow(0).getCell(0).toString();
	     String server = sheet.getRow(0).getCell(1).toString();
	     String project = sheet.getRow(0).getCell(2).toString();
	  driver.findElement(By.id("select_option_25")).click();
		 Thread.sleep(1000);

	  driver.findElement(By.id("input_15")).sendKeys(app);
	 driver.findElement(By.id("input_16")).sendKeys(server);
	 driver.findElement(By.id("input_23")).sendKeys(project);
	 Thread.sleep(1000);
	 ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");

	 driver.findElement(By.xpath(".//*[@id='select_value_label_12']")).click();
     driver.findElement(By.xpath(".//*[@id='select_option_58']")).click();	 
	 driver.findElement(By.id("create-server")).click();
  }
}
