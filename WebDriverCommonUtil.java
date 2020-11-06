package com.comCast.genericlib;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverCommonUtil extends BaseClass 
{
	public static String parentWindowId;
	public static String childWindowId;
	
	 public void waitAndClickElementInGUI(WebElement element) throws Throwable {
		 int count=0;
		 while(count<20) {
			 try {
				 element.click();
				 break;
			 }
		 catch(Exception e) {
			 Thread.sleep(1000);
			 count++;
		 }
	 }
}
public void select(WebElement element,String option) {
	Select sel=new Select(element);
	sel.selectByVisibleText(option);
}
 public void moveMouse(WebElement element) {
	 Actions act= new Actions(driver);
	 act.moveToElement(element).perform();
 }

 public  void waitForElementToPresent(WebElement element) {
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 }
 public void getWindowId()
 {
	 Set<String> set= driver.getWindowHandles();
	 Iterator<String> it=set.iterator();
	 parentWindowId=it.next();
	 childWindowId=it.next();
	 driver.switchTo().window(childWindowId);
 }
 public String handlePopUpOk() {
	 Alert alt=driver.switchTo().alert();
	 String actTitle=alt.getText();
	 alt.accept();
	 return actTitle;
 }
 public String handlePopUpCancel() {
	 Alert alt=driver.switchTo().alert();
	 String actTitle=alt.getText();
	 alt.dismiss();
	 return actTitle;
 }
}