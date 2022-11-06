package ECommerce.PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> CartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement RowBtn;
	
	public Boolean VerifyProductDisplay(String Productname ) {
		Boolean Match = CartProducts.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(Productname));
		Assert.assertTrue(Match);
		return Match;
		
	}
}
