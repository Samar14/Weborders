package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	private WebDriver driver;
	
	public SearchResultsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@class='pull-left h1 jobs-page-header-h1']")
	public WebElement resultsLabel;
	
	@FindBy(id="posiCountId")
	public WebElement positionsCount;
	
	
	public boolean verifyResultsLable(String jobTitle, String location){
		
		String resultsText=resultsLabel.getText();
//check if text starts with Jobtitle and ends with Location		
		if(resultsText.startsWith(jobTitle) && resultsText.endsWith(location))
		    return true;
		else 
		    return false;
	}

}
