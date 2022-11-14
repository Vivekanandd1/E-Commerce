package ECommerce.PageObjectModel;

import java.io.IOException;
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
import org.testng.annotations.Test;

import ECommerce.BaseTest.BaseTestComponent;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneMainStepDefs extends BaseTestComponent {
	
	@Test
	public static void SubmitOrderTest() throws InterruptedException, IOException {
		String Productname = "ADIDAS ORIGINAL";
		String CountryName  = "india";
		String ActualText = "THANKYOU FOR THE ORDER.";
	
	
		
		
		LoginPage loginPage = Launch();
//		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login("ec.vivekd92@gmail.com", "Rony@11888");
		ProductCatalouge productCatalouge = new ProductCatalouge(driver);
	
		
		
		List<WebElement>Productlists = productCatalouge.GetProductList();	
		productCatalouge.AddProductToCart(Productname);
		CartPage  cartPage = productCatalouge.GotoCartPage();
		Boolean Match = cartPage.VerifyProductDisplay(Productname);
//		Assert.assertTrue(Match);
		
		CheckOutPage checkoutPage = cartPage.GoToCheckout();
		checkoutPage.selectCountry(CountryName);
		checkoutPage.OrderSubmit();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		String Confirmation = confirmationPage.ConfirmationText();		
		Assert.assertEquals(ActualText, Confirmation);
		Thread.sleep(1500);
		driver.quit();
	}

}
