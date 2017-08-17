import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class DifferentUIElements {

	WebDriver  oBrowser;
	
	// cannot run first two tests as the site has changed!
	// @Test
	public void  quickApply()  {
		
		
		//1. instantiate a FireFox brwoser 
		oBrowser = new FirefoxDriver ();
		
		// 2. Open the URL
		oBrowser.get ("http://www.deals4loans.com");
		
		// Try out the elemnts in the Qick Apply form
		// 3. Pick an item from a select drop down box
		
		Select uiProduct = new Select(oBrowser.findElement(By.id("Type_loan")));
		
		uiProduct.selectByVisibleText("Home Loan");
		
		// 4. Find element fullname textbox and provide data
		
		oBrowser.findElement(By.id("fullname")).clear();
		oBrowser.findElement(By.id("fullname")).sendKeys("seleniumuser1");
		
		// 5. Enter salary value in the textbox
		
		oBrowser.findElement(By.id("net_salary")).clear();
		oBrowser.findElement(By.id("net_salary")).sendKeys("6789");
		
		// 6. Check box if not already selected
		
		if (!(oBrowser.findElement(By.name("accept")).isSelected()))
			oBrowser.findElement(By.name("accept")).click();
		
		// 7. Click the Getquote button
		// this needs to be located via xpath  
		
		oBrowser.findElement(By.xpath("//input[@type='submit']")).click();
		
	}
	
	// @Test
	
	public void  AboutUs() throws InterruptedException {
		//1. instantiate a FireFox brwoser 
		oBrowser = new FirefoxDriver ();
				
		// 2. Open the URL
		oBrowser.get ("http://www.deals4loans.com");
		
		// 3. Find the link About Us
		// oBrowser.findElement(By.linkText("About Us")).click();
		oBrowser.findElement(By.xpath("//a[@href='About_us.php']")).click();
		
		Thread.sleep(3000);
		
		// 4. verify if the label is displayed
		// labels can be with tags div, span , strong
		
		// oBrowser.findElement(By.xpath("//strong[contains(.,'About Us')]"));
		
		// you can also locate the text para div to ascertain
		oBrowser.findElement(By.xpath("//div[@class ='text11']"));
		
		// 5. click on logo image to go back to home page
		
		oBrowser.findElement(By.id("logoImg")).click();
		
	}
	
	
	@Test
	public void makeMyTrip() {
	    //1. instantiate a FireFox brwoser 
	    oBrowser = new FirefoxDriver ();
						
		// 2. Open the URL
		oBrowser.get ("http://www.makemytrip.com");
			
		// 3. Activate a radio button based on user input
		// locate buttons based partial label values in xpath
		
		String sOption = "Multi City";
		
		if (sOption.equals("One Way"))
			oBrowser.findElement
			(By.xpath("//a[@id='one_way_button1']/span")).click();
		else if (sOption.equals("Round Trip"))
			oBrowser.findElement
			(By.xpath("//a[@id='round_trip_button1']/span")).click();
		else if (sOption.equals("Multi City"))
			oBrowser.findElement
			(By.xpath("//a[@id='multi_city_button']/span")).click();
		
		
	}
	
	
	
	
	
}
