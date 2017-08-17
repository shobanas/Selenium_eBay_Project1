import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class eBayTest1 {

	@Test
	public void search () {
		
		String eBayUrl = "http://www.ebay.com";
		// 1. Open the browser
		
		/* FirefoxDriver  oBrowser = new FirefoxDriver (); */
		
		// System.setProperty("webdriver.chrome.driver", "C:\\selenium-driver\\browser-drivers\\chromedriver.exe");
		// ChromeDriver oBrowser = new ChromeDriver();
		
		
		System.setProperty("webdriver.ie.driver", "C:\\selenium-driver\\browser-drivers\\IEDriverServer.exe");
		InternetExplorerDriver oBrowser = new InternetExplorerDriver ();
		
		// this has no UI, runs scripts in background
		// HTMLUnitDriver  oBrowser  = new HTMLUnitDriver();
		
		// 2. launch  ebay.com
		
				
		oBrowser.get(eBayUrl);
		
		// 3. Find search textbox and enter camera in it
		
		oBrowser.findElement(By.id("gh-ac")).clear();
		oBrowser.findElement(By.id("gh-ac")).sendKeys("camera");
		
		// 4. Click the search button
		oBrowser.findElement(By.id("gh-btn")).click();
		
		// 5. Click the link 'Daily Deals'
		
		oBrowser.findElement(By.linkText("Daily Deals")).click();
		
	}
	
	
	
}
