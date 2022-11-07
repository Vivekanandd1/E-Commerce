package ECommerce.PageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneMainStepDefs {
	
	public static void main(String[] args) throws InterruptedException {
		String Productname = "ADIDAS ORIGINAL";
		String CountryName  = "india";
		String ActualText = "THANKYOU FOR THE ORDER.";
		WebDriver driver = new ChromeDriver();
		LoginPage loginPage = new LoginPage(driver);
		CartPage  cartPage = new CartPage(driver);
		CheckOutPage checkoutPage = new CheckOutPage(driver);
		ProductCatalouge productCatalouge = new ProductCatalouge(driver);
		WebDriverManager.chromedriver().setup();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
        loginPage.GoTo();
		loginPage.Login("ec.vivekd92@gmail.com", "Rony@11888");
		
		
		List<WebElement>Productlists = productCatalouge.GetProductList();
		
		productCatalouge.AddProductToCart(Productname);
		
		Boolean Match = cartPage.VerifyProductDisplay(Productname);
	
//		Assert.assertTrue(Match);
		
		cartPage.GoToCheckout();
		checkoutPage.selectCountry(CountryName);
		checkoutPage.OrderSubmit();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		
	
		String Confirmation = confirmationPage.ConfirmationText();
				
		Assert.assertEquals(ActualText, Confirmation);
			
		
		
		Thread.sleep(1500);
		driver.quit();
	}

}
