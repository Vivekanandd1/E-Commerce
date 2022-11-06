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
	
	@FindBy(css=".btn.btn-custom[routerlink='/dashboard/cart']")
	WebElement RowBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Buy Now']")
	WebElement BuyBtn;
	
	public Boolean VerifyProductDisplay(String Productname ) {
		Boolean Match = CartProducts.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(Productname));
//		String vd  = CartProducts.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(Productname)).
		return Match;
			
	}
	
	public void GoToCheckout() {
		RowBtn.click();
		BuyBtn.click();
	}
}
