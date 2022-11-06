package ECommerce.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalouge extends AbstractComponent {
	WebDriver driver;
    	
     public ProductCatalouge(WebDriver driver) {
    	 super(driver);
    	 this.driver=driver;
    	 PageFactory.initElements(driver,this);
     }
    
 	@FindBy(css=".mb-3")
 	List<WebElement> Products;

 	@FindBy(css=".ng-animating")
 	WebElement Animation;
 	
 	By products = By.cssSelector(".mb-3");
 	By AddToCart = By.cssSelector(".card-body button:last-of-type");
 	By ToastMessage = By.cssSelector("#toast-container");
 
 	
 	public List<WebElement> GetProductList() {
 		ElementToBeAppear(products);
 		return Products;
 	}
 	
 	public WebElement GetProductByName(String Productname) {
 		
 		WebElement prod = GetProductList().stream().filter(product->
		product.findElement(By.cssSelector("B")).getText().equals(Productname)).findFirst().orElse(null);
 		return prod;
 	}
 	
 	public void AddProductToCart(String Productname) throws InterruptedException {
 		WebElement prod = GetProductByName(Productname);
 		prod.findElement(AddToCart).click();
 		ElementToBeAppear(ToastMessage);
 		ElementToBeDisappear(Animation);
 	}
}
