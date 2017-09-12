package cloudautomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class Signup  {
	HSSFWorkbook workbook;
    HSSFSheet sheet;
    HSSFCell cell;
  @Test
  public void signup() throws InterruptedException, IOException {
	  WebDriver driver=ServerLoader.driver;
	   
		  File src=new File("src/Data.xls");
	  
	  FileInputStream finput = new FileInputStream(src);
	  
      
	  
      // Load he workbook.
 
     workbook = new HSSFWorkbook(finput);
     sheet= workbook.getSheetAt(0);
     
     String email = sheet.getRow(0).getCell(0).toString();
     String Password = sheet.getRow(0).getCell(1).toString();
  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
     
	 Thread.sleep(1000);
	  System.out.println("We are Just Testing");
	  driver.findElement(By.xpath(".//*[@id='cw-app_container']/div/section/div[2]/div[3]/form/div[10]/a[2]")).click();
		 Thread.sleep(100);

	  driver.findElement(By.id("input_3")).sendKeys(email);
	  driver.findElement(By.id("input_4")).sendKeys(Password);
	  driver.findElement(By.xpath(".//*[@id='select_5']")).click();
	  driver.findElement(By.xpath(".//*[@id='select_option_8']")).click();
	  driver.findElement(By.xpath(".//*[@id='cw-app_container']/section/div[1]/div/div/div[3]/form/button")).click();
  }
}
