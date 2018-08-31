package tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import pages.ListAllOrderPage;
import pages.LoginPage;
import pages.OrderPage;
import utilities.Config;
import utilities.ExcelUtils;
import utilities.Page;

public class CalculatePriceTest {

	WebDriver driver;
	LoginPage loginPage;
	OrderPage orderPage;
	ListAllOrderPage listAllOrderPage;
	
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
		//driver.close();
	}

	@Test
	public void test() {
		loginPage=new LoginPage(driver);
		loginPage.login(Config.getProperty("username"),
				        Config.getProperty("password"));
		orderPage=new OrderPage(driver);
		Page.verifyAtPage(orderPage.greeting);
//Read values from Excel file
	ExcelUtils.openExcelFile(Config.getProperty("testdataPath"), "TestData");
		int usedRowsCount=ExcelUtils.getUsedRowsCount();
		
		for(int rowNum=1;rowNum<usedRowsCount;++rowNum){
			
			if(!ExcelUtils.getCellData(rowNum, 0).equals("Y")){
				ExcelUtils.setCellData("Skip requested", rowNum, 3);
				continue;
		}
			
			String product=ExcelUtils.getCellData(rowNum, 1);
			String quantity=ExcelUtils.getCellData(rowNum, 2);
			
			
			Select prod=new Select(orderPage.product);
			prod.selectByVisibleText(product);
			
			orderPage.quantity.clear();
			orderPage.quantity.sendKeys(quantity);
			orderPage.calculate.click();
		
			String totalPrice=orderPage.totalPrice.getAttribute("value");
			System.out.println(totalPrice);
		
			ExcelUtils.setCellData(totalPrice, rowNum, 3);
			
			String name=ExcelUtils.getCellData(1,4);
			orderPage.customerName.sendKeys(name);
			
			String str=ExcelUtils.getCellData(1, 5);
			orderPage.street.sendKeys(str);
	
			String ct=ExcelUtils.getCellData(1, 6);
			orderPage.city.sendKeys(ct);
			
			String st=ExcelUtils.getCellData(1, 7);
			orderPage.state.sendKeys(st);
			
			String zi=ExcelUtils.getCellData(1, 8);
			orderPage.zip.sendKeys(zi);	
			
			//String masterCard=ExcelUtils.getCellData(1, 9);
			orderPage.cardType.click();
			
			String cardNum=ExcelUtils.getCellData(1, 10);
			orderPage.cardNumber.sendKeys(cardNum);
			
			String cardDate=ExcelUtils.getCellData(1, 11);
			orderPage.expDate.sendKeys(cardDate);
			
			orderPage.processBtn.click();
			
			String expected="New order has been successfully added.";
			assertTrue(orderPage.message.getText().contains(expected));
			
			orderPage.viewAllOrdersPage.click();
			
//          String fristRow=listAllOrderPage.fristRow.getText();
//          String expecteds=ExcelUtils.getCellData(rowNum, 4);

//           listAllOrderPage=new ListAllOrderPage(driver);
//           System.out.println(listAllOrderPage.firstRow.getText());
//
//           for (int rowNumber = 1; rowNumber < usedRowsCount; rowNumber++) {
//           String Product = ExcelUtils.getCellData(rowNumber, 1);
//           String Quantity = ExcelUtils.getCellData(rowNumber, 2);
//           String Name = ExcelUtils.getCellData(rowNumber, 4);
//           String Street = ExcelUtils.getCellData(rowNumber, 5);
//           String City = ExcelUtils.getCellData(rowNumber, 6);
//           String State = ExcelUtils.getCellData(rowNumber, 7);
//           String Zip = ExcelUtils.getCellData(rowNumber, 8);
//           String CardType = ExcelUtils.getCellData(rowNumber, 9);
//           String CardNumber = ExcelUtils.getCellData(rowNumber, 10);
//           String ExpDate = ExcelUtils.getCellData(rowNumber, 11);


//           listAllOrderPage.verifyFullAddress(Name, Street, City, State, Zip);
//           listAllOrderPage.verifyPayment(Name, CardType, CardNumber, ExpDate);
           //listAllOrderPage.verifyCellDataByNameAndColumn(product, Product);

   //              String productSmart=listAllOrderPage.productInTable.getText();
   //              System.out.println(productSmart);
   //              Assert.assertEquals(Product,productSmart);
       // }
      }

    }
}
