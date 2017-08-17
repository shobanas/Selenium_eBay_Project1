import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Verifications {

	
	// Three ways to verify
	    // 1. By using isDisplayed() method to verify pages
	    // 2. By using getAttribute method to capture output values on page from a property of an elem
	    // 3. By using getText() method to get the displayed text value
	
	@Test
	public void search () {
		
		String eBayUrl = "http://www.ebay.com";
		// 1. Open the browser
		
		 FirefoxDriver  oBrowser = new FirefoxDriver (); 
		
		// System.setProperty("webdriver.chrome.driver", "C:\\selenium-driver\\browser-drivers\\chromedriver.exe");
		// ChromeDriver oBrowser = new ChromeDriver();
		
		
		//System.setProperty("webdriver.ie.driver", "C:\\selenium-driver\\browser-drivers\\IEDriverServer.exe");
		// InternetExplorerDriver oBrowser = new InternetExplorerDriver ();
		
		// this has no UI, runs scripts in background
		// HTMLUnitDriver  oBrowser  = new HTMLUnitDriver();
		
		// 2. launch  ebay.com	
		oBrowser.get(eBayUrl);
		
		// Verify Step 2- check if Search textbox is displayed
		try {
			if (oBrowser.findElement(By.id("gh-ac")).isDisplayed())
				System.out.println("Ebay URL launched successfully");
		}catch (Exception e)
		{
			System.out.println("Ebay site did not launch!");
		}
		 
		// 3. Find search textbox and enter camera in it
		
		oBrowser.findElement(By.id("gh-ac")).clear();
		oBrowser.findElement(By.id("gh-ac")).sendKeys("camera");
		
		// 4. Click the search button
		oBrowser.findElement(By.id("gh-btn")).click();
		
		// Verify if the search results are displayed
		try {
			if (oBrowser.findElement(By.className("rsHdr")).isDisplayed())
			   System.out.println("search results displayed correctly");
		} catch (Exception e)
		{
			System.out.println("Failed TC - search Results were not displayed");
		}
		
		
		// 5. Click the link 'Daily Deals'
		
		oBrowser.findElement(By.linkText("Daily Deals")).click();
		
		// verify if the 'dailyDeals" div appears on page
		
		try {
			if (oBrowser.findElement(By.xpath("//div[contains(text(), 'Daily deals')]")).isDisplayed())
			   System.out.println("DailyDeals link results displayed correctly");
		} catch (Exception e)
		{
			System.out.println("Failed TC - daily deals link results were not displayed");
		}
		
		
		// example 2 - deal4loans , try EMI calculator, provide input and verify output value on page
		// sActualEMI = oBrowser.findElement(By.name("pay")).getAttribute("value");
		// if (sExpected.equals(sActual))
		
		
	}
	
	
	
	
}
