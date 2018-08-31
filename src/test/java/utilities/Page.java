package utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Page {
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void verifyAtPage(WebElement elem){
		Assert.assertTrue("Verify at correct page failed",elem.isDisplayed());
	}
	
	
}
