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

import ECommerce.PageObjectModel.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestComponent {
	public static WebDriver driver;
	
	public static WebDriver DriverInitialisation() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\GloabalData.properties");
		prop.load(fis);
		String Browsername = prop.getProperty("browser");
		if (Browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (Browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
       else if (Browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		return driver;
	}
	
	public static LoginPage Launch() throws IOException {
		driver = DriverInitialisation();
		LoginPage loginPage = new LoginPage(driver);
		 loginPage.GoTo();
		 return loginPage;
	}
	

}
