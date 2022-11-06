package ECommerce.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage extends AbstractComponent {
	WebDriver driver;
	Actions Act;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		Act = new Actions(driver);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement CountrySelection;
	
	@FindBy(xpath ="(//button[contains(@class,'ta-item')])[2]")
	WebElement SelectCountry;
	
	
	
	By Submit = By.cssSelector(".btnn.action__submit.ng-star-inserted");
	By Results = By.cssSelector(".list-group-item");
	
	public void selectCountry(String CountryName) {
		Act.sendKeys(CountrySelection,CountryName).build().perform();
		ElementToBeAppear(Results);
		SelectCountry.click();
	}
	
	public void OrderSubmit() {
		ElementToClickable(Submit);
		try {
		     driver.findElement(Submit).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(Submit));
		  }
	}
	

}
