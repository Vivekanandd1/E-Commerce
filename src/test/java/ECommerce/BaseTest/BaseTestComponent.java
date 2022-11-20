package ECommerce.BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ECommerce.PageObjectModel.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestComponent {
	public WebDriver driver;
	public LoginPage loginPage;
	
	public  WebDriver DriverInitialisation() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\GloabalData.properties");
		prop.load(fis);
		String Browsername = prop.getProperty("browser");
		if (Browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
		}
		else if (Browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
       else if (Browsername.equalsIgnoreCase("firefox")) {
    	   WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod
	public LoginPage Launch() throws IOException {
		driver = DriverInitialisation();
		loginPage = new LoginPage(driver);
		 loginPage.GoTo();
		 return loginPage;
	}
	
	@AfterMethod
	public void Teardown() throws InterruptedException {
		Thread.sleep(1500);
		driver.quit();
	}
	

}
