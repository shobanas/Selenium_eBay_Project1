import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;




public class HandlingMenus {
	WebDriver  oBrowser;
	
	@Test
	public void ebayMenu() throws InterruptedException {
		oBrowser = new FirefoxDriver();
		oBrowser.get("http://www.ebay.com");
		
		// goal is to cause a mouse over action on 'Fasihon' menu
		// and click kids & Baby link submenu item
		
		// Create an instance of Action class
		
		Actions oAct = new Actions(oBrowser);
		
		// mouse over "Fashion" menu item
		oAct.moveToElement(oBrowser.findElement(By.linkText("Fashion"))).build().perform();
		
		Thread.sleep(2000);  // wait for submenu to come up
		
		oBrowser.findElement((By.xpath("//a[contains(.,'Kids & Baby')]"))).click();
		
		
		
		
		
	}
}
