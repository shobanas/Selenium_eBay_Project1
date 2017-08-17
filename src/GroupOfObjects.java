

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GroupOfObjects {
	public WebDriver  oBrowser;
	
	// @Test
	public void samplePrint() {
		oBrowser = new FirefoxDriver();
		oBrowser.get("http://www.ebay.com");
		
		// enter camera on the search texbox
		oBrowser.findElement(By.id("gh-ac")).clear();
		oBrowser.findElement(By.id("gh-ac")).sendKeys("camera");
		
		// click the search button
		oBrowser.findElement(By.id("gh-btn")).click();
		
		// find the group of elements that relate to the price info
		
		List<WebElement> uiPrices = oBrowser.findElements(By.className("bold"));
		
		// make a for loop to iterate through the array / list and print price
		
		for(WebElement uiSinglePrice:uiPrices) {
			
			System.out.println(uiSinglePrice.getText());
		}
		
	}
		
	 @Test
		public void sampleWriteToFile() throws FileNotFoundException {
			oBrowser = new FirefoxDriver();
			oBrowser.get("http://www.ebay.com");
			
			// enter camera on the search texbox
			oBrowser.findElement(By.id("gh-ac")).clear();
			oBrowser.findElement(By.id("gh-ac")).sendKeys("camera");
			
			// click the search button
			oBrowser.findElement(By.id("gh-btn")).click();
			
			// find the group of elements that relate to the price info
			
			List<WebElement> uiPrices = oBrowser.findElements(By.className("bold"));
			
			
			// the objective is to capture the prices list into a notepad file
			
			// create a file instance
			File oInputFile = new File("C:\\selenium-ide-scripts\\eBayPrices.txt");
			
			PrintWriter oPW = new PrintWriter(oInputFile);
			
			String sText;
			
			// make a for loop to iterate through the array / list and print price
			
			for(WebElement uiSinglePrice:uiPrices) {
				sText = uiSinglePrice.getText();
				System.out.println(sText);
				oPW.println(sText);
			}
			oPW.flush();  //save the buffer data to file
			oPW.close();  // close the file connection
		}
			
	
	
	
	
		
		
	
}
