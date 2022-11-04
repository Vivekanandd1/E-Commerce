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
		String Productname1 = "ADIDAS ORIGINALss";
		WebDriver driver = new ChromeDriver();
		LoginPage loginPage = new LoginPage(driver);
		ProductCatalouge productCatalouge = new ProductCatalouge(driver);
		WebDriverManager.chromedriver().setup();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
        loginPage.GoTo();
		loginPage.Login("ec.vivekd92@gmail.com", "Rony@11888");
		List<WebElement>Productlists = productCatalouge.GetProductList();
		
		WebElement prod = Productlists.stream().filter(product->
		product.findElement(By.cssSelector("B")).getText().equals(Productname)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> CartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean Match = CartProducts.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(Productname));
		Assert.assertTrue(Match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
	
		Actions A = new Actions(driver);
		A.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list-group-item")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted"))));
		WebElement OrderButton = driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted"));
		/* 1.-> Here we used javaExecutor as Ordbutton get overlaid by Country Dropdown menu (We'll correct that in future Development)*/
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", OrderButton);
		String Confirmation = driver.findElement(By.xpath("//h1[normalize-space()='Thankyou for the order.']")).getText();
		Assert.assertEquals("THANKYOU FOR THE ORDER.", Confirmation);
			
		
		
		Thread.sleep(1500);
		driver.quit();
	}

}