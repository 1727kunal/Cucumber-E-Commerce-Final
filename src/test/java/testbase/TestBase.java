package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	
	public static void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=common/home");
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
