package ECommerce.PageObjectModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponent {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//WebElement UserEmail = driver.findElement(By.id("userEmail"));
	@FindBy(id="userEmail")
	WebElement UserEmail;
	
	@FindBy(id="userPassword")
	WebElement UserPassword;
	
	
	
	@FindBy(id="login")
	WebElement LoginBtn;
	
	public void GoTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	public void Login(String Email,String Password) {
		UserEmail.sendKeys(Email);
		UserPassword.sendKeys(Password);
		LoginBtn.click();
		
		}
	
	
}
