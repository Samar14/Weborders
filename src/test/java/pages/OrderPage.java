package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage{
	private WebDriver driver;
	
	public OrderPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(className="login_info")
	public WebElement greeting;
	
	@FindBy(id = "ctl00_logout")
	public WebElement logOut;

	@FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
	public WebElement product;

	@FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
	public WebElement quantity;

	@FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
	public WebElement totalPrice;

	@FindBy(css="input[value='Calculate']")
	public WebElement calculate;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtName")
	public WebElement customerName;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
	public WebElement street;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox3")
	public WebElement city;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox4")
	public WebElement state;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox5")
	public WebElement zip;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_cardList_1")
	public WebElement cardType;

	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox6")
	public WebElement cardNumber;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox1")
	public WebElement expDate;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_InsertButton")
	public WebElement processBtn;
	
	@FindBy(xpath="//strong[contains(text(),'New order has been')]")
	public WebElement message;
	
	@FindBy(linkText="View all orders")
	public WebElement viewAllOrdersPage;
	
//	@FindBy(className="SampleTable")
//	public WebElement table;	
	
}
