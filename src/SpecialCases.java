

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;





public class SpecialCases {

WebDriver  oBrowser;
	
	// @Test
	public void captureScreenshot() throws IOException{
		oBrowser = new FirefoxDriver();
		oBrowser.get("http://www.ebay.com");
		
		// Programatically capture a screenshot, that is typically
		// done manually through "printscreen" menu
		
		//1. Cast oBrowser object to be of type TakesScreenshot interface.
		TakesScreenshot  oShot = (TakesScreenshot)  oBrowser;
		
	    // 2. use interface methods to get the screen shot into a File var
		File oTempFile1 = oShot.getScreenshotAs(OutputType.FILE);
		
		// 3. Create an empty physical file and copy screenshot file contents 
		
		File oDestFile1 = new File("C:\\selenium-ide-scripts\\ebayScreenshot.jpeg");
		
		FileUtils.copyFile(oTempFile1, oDestFile1);
			
		
	}	
	
	//@Test
	public void handlingAlerts () throws InterruptedException {
		
		// do all the code as in the prev example to fill out
		// the quick apply form from deal4loans.com (site changed!)
		// In the form, put an incorrect 5 didgit mobile number data
		// which will cause a JS alert box to pop up
		
		// our goal in this method is to capture the alert text
		// and to accept or OK the alert message pop up
		
		Thread.sleep(5000);
		
		// change focus of the browser instance to the Alert box
		Alert oAlt = oBrowser.switchTo().alert();
		
		// get the alert text and print it out
		
		String sAlertText  = oAlt.getText();
		
		System.out.println(sAlertText);
		
		// click on the OK to accept the alert
		
		oAlt.accept();
		
		
		
		
		
		
		
		
		
		
		
		
	}

	// @Test
	public void  handlingMultipleBrowserWindows () {
		oBrowser = new FirefoxDriver();
		
		oBrowser.get("http://www.carefirst.com");
		
		oBrowser.findElement(By.linkText("Providers")).click();
		
		// get the current / parent browser tab info
		
		String oParentBrw = oBrowser.getWindowHandle();
		
		// click on the link that creates a new browser tab
		
		oBrowser.findElement(By.linkText("Find a Provider")).click();
		
		// get all the browser tabs info into a string array
		
		Set<String>  oAllBrws = oBrowser.getWindowHandles();
		
		// eliminate the parentBrowser in the list and switch to the new tab
		// this logic works for 2 tabs
		// if you ever have more than 2 tabs, use browser "title'
		// to identify the specific window to switch to
		
		for(String oEachBrw:oAllBrws)
		{
			if (!(oEachBrw.equals(oParentBrw)))
			{
				oBrowser.switchTo().window(oEachBrw);
				break;
			}	
		}
		
		// click the link on the new browser tab
		
		oBrowser.findElement(By.linkText("Medigap Member")).click();
		
	
	}

	@Test
	public void  autoSuggests () {
		oBrowser = new FirefoxDriver();
		
		oBrowser.get("http://www.gmail.com");

		// oBrowser.findElement(By.id("gmail-create-account")).click();
    
		// If there are spaces around linktext, locate using the following method
		
		oBrowser.findElement(By.partialLinkText("Create an account")).click();
		
		// locate the textbox for password entry
		
		oBrowser.findElement(By.id("Passwd")).clear();
		oBrowser.findElement(By.id("Passwd")).sendKeys("abcd");
		
		// locate the pop up suggestion box and capture the text
		
		String sText = oBrowser.findElement(By.id("passwdRating")).getText();
		
		System.out.println(sText);
		
	}

}
