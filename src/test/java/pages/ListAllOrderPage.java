package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListAllOrderPage {
	private WebDriver driver;
	
	public ListAllOrderPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//*[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td[2]")
    public WebElement firstRow;
	
	@FindBy(xpath = "//*[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td[3]")
	public WebElement productInTable;
	
    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAll;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement unCheckAll;

    @FindBy(xpath = "//*[@id='ctl00_menu']/li[1]/a")
    public WebElement navigateToViewAllOrdersPage;

    @FindBy(xpath = "//*[@id='ctl00_menu']/li[2]/a")
    public WebElement navigateToViewAllProductsPage;

    @FindBy(xpath = "//*[@id='ctl00_menu']/li[3]/a")
    public WebElement navigateToOrderPage;
    
//    public void verifyCellDataByNameAndColumn(String name, String str) {
//
//        try {
//            String xpath = driver.findElement
//            (By.xpath("//table[@class = 'SampleTable']/tbody/tr/td[.='" + name + "']/../td[.='" + str + "']")).getText();
//                assertEquals(str, xpath);
//
//        } catch (NoSuchElementException e) {
//                fail("No Such Element");
//                e.getStackTrace();
//        }
//    }
//
//
//public void verifyFullAddress(String name, String street, String city, String state, String zip) {
//
//        verifyCellDataByNameAndColumn(name, street);
//        verifyCellDataByNameAndColumn(name, city);
//        verifyCellDataByNameAndColumn(name, state);
//        verifyCellDataByNameAndColumn(name, zip);
//    }
//
//public void verifyPayment(String name, String cardType, String cardNumber, String expDate) {
//        verifyCellDataByNameAndColumn(name, cardType);
//        verifyCellDataByNameAndColumn(name, cardNumber);
//        verifyCellDataByNameAndColumn(name, expDate);
//      }   
  }
