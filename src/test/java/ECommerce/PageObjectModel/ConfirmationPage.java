package ECommerce.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends AbstractComponent {
	
	WebDriver driver;
	Actions Act;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		Act = new Actions(driver);
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Thankyou for the order.']")
	WebElement ConfirmText;
	
	public String ConfirmationText() {
		return ConfirmText.getText();
		
		
	}

	
	
}
