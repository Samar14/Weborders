package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiceHomePage {
	
	private WebDriver driver;
	
	public DiceHomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search-field-keyword")
	public WebElement keyword;
	
	@FindBy(id="search-field-location")
	public WebElement city;
	
	@FindBy(xpath="//button[.='Find Tech Jobs']")
	public WebElement find;
	
	
	public void search(String jobTitle, String location){
		keyword.clear();
		keyword.sendKeys(jobTitle);
		
		city.clear();
		city.sendKeys(location);
		
		find.submit();
	}

}
