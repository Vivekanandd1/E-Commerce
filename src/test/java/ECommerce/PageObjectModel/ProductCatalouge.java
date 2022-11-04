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
 	
 	By products = By.cssSelector(".mb-3");
 	
 	public List<WebElement> GetProductList() {
 		ElementToBeAppear(products);
 		return Products;
 	}
}
