package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.DiceHomePage;
import pages.SearchResultsPage;
import utilities.Config;

public class DiceSearchTest {

	WebDriver driver;
	DiceHomePage diceHomePage;
	SearchResultsPage searchResultsPage;

	@Before
	public void setUp() throws Exception {
		System.setProperty(Config.getProperty("webdriver"), Config.getProperty("driverpath"));
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(Config.getProperty("diceUrl"));
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		String jobTitle="Automation Engineer";
		String location="Chicago, IL";
		
		diceHomePage=new DiceHomePage(driver);
//		WebDriverWait wait=new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOf(searchResultsPage.positionsCount));
		
		assertEquals("Tech Jobs | US Contract and Permanent IT Jobs | Dice.com", driver.getTitle());
		
		diceHomePage.search(jobTitle, location);
		
		searchResultsPage=new SearchResultsPage(driver);
		
		
		//this do the same like sendkeys. 
//		public static void setAttribute(WebElement element, String attributeName, String value) {
//		WrapsDriver wrappedElement = (WrapsDriver) element;
//
//		JavascriptExecutor driver = (JavascriptExecutor)wrappedElement.getWrappedDriver();
//
//		driver.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",
//				                                    element, attributeName, value);
//       }

	
		
		
		
		
	}

}
