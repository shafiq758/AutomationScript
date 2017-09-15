package cloudautomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AddedServer {
	
	HSSFWorkbook workbook;
    HSSFSheet sheet;
    HSSFCell cell;
  @Test
  public void step3() throws InterruptedException, IOException {
	  
	  WebDriver driver=ServerLoader.driver;
File src=new File("src/Data.xls");
	  
	  FileInputStream finput = new FileInputStream(src);
	  
      
	  
      // Load he workbook.
 
     workbook = new HSSFWorkbook(finput);
     sheet= workbook.getSheetAt(3);
		// Thread.sleep(5000);
	 String serv = sheet.getRow(0).getCell(0).toString();
	driver.findElement(By.xpath(".//*[@id='cw-app_container']/div/div/md-list/md-list-item/div[1]/span")).click();
	Thread.sleep(1000);
	
	WebElement searchBtn = driver.findElement(By.xpath(".//*[@id='cw-app_container']/div[3]/ng-include/div/div/md-fab-speed-dial/md-fab-trigger/button"));

	Actions action = new Actions(driver);
	action.moveToElement(searchBtn).perform();
	
	driver.findElement(By.xpath(".//*[@id='cw-app_container']/div[3]/ng-include/div/div/md-fab-speed-dial/md-fab-actions/div[1]/button")).click();
	
	driver.findElement(By.id("select_38")).click();
	driver.findElement(By.id("select_option_54")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("input_40")).sendKeys(serv);
	
	driver.findElement(By.xpath(".//*[@id='cw-app_container']/div[2]/section/md-content/form/button")).click();
  }
}
