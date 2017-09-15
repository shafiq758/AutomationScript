package cloudautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ServerFunction {
  @Test
  public void restart() {
	   WebDriver driver=ServerLoader.driver;
		  JavascriptExecutor javascript = (JavascriptExecutor) driver;

	  driver.findElement(By.xpath(".//*[@id='cw-app_container']/div/div/md-list/md-list-item/div[2]/md-menu[2]/button")).click();
	  driver.findElement(By.xpath(".//*[@id='menu_container_11']/md-menu-content/cw-server-actions/md-menu-item/button[2]")).isEnabled();
	  driver.findElement(By.xpath(".//*[@id='menu_container_11']/md-menu-content/cw-server-actions/md-menu-item/button[2]"));
	  String toenable = "document.getElementById('menu_container_20').removeAttribute('disabled');";
	  javascript.executeScript(toenable);
	  
 Boolean f =  driver.findElement(By.xpath(".//*[@id='menu_container_11']/md-menu-content/cw-server-actions/md-menu-item/button[2]")).isEnabled();
 
 System.out.println(f);

  }
}
