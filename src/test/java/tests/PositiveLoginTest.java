package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pages.LoginPage;
import pages.OrderPage;
import utilities.Config;
import utilities.Page;

public class PositiveLoginTest {
	WebDriver driver;
//we need to Object to use LoginPage's login method, 'cos it's not static method	
	LoginPage loginPage;
	OrderPage orderPage;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty(Config.getProperty("webdriver") ,
				Config.getProperty("driverpath"));
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Config.getProperty("url"));
	}
	

	
	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
//now we have to instatiate LoginPage //creating new Object 'cos all the elem.inside the LoginPage class. 
	                     //this driver coming from LoginPage and see all those elements
		loginPage=new LoginPage(driver);
		//calling login method
		loginPage.login(Config.getProperty("username"),
				        Config.getProperty("password"));
		orderPage=new OrderPage(driver);
		Page.verifyAtPage(orderPage.greeting);
		
	}

}
