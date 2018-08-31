package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
//whenever we created new Object for this class, we call this cunstractor	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
		//If I don't put PageFactory, it not gonna be visible to our driver
		//PageFacotry works with Selenium it saying whenever you use POM you use this PageFactory			
//you are basically saying 'hey PageFactory initialize all this(this^) elements 		
	}
	
	@FindBy(id="ctl00_MainContent_status")
	public WebElement loginError;
	
	@FindBy(id="ctl00_MainContent_username")
	public WebElement usernameInputBox;
	
	@FindBy(id = "ctl00_MainContent_password")
	public WebElement passwordInputBox;
	
	@FindBy(id = "ctl00_MainContent_login_button")
	public WebElement loginButton;
	
	@FindBy(xpath="//label[.='Username:']")
	public WebElement userNameLabel;
	
	@FindBy(xpath="//label[.='Password:']")
	public WebElement passwordLabel;

//usuable method to login	
	public void login(String userName,String password){
  //this.driver sending keys		
		usernameInputBox.sendKeys(userName);
		passwordInputBox.sendKeys(password);
		loginButton.click();
	}
	
}
