package core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	private static RemoteWebDriver driver;

	private DriverFactory() {
	}

	public static WebDriver getDriver() throws MalformedURLException {
		//System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), cap);
		driver.manage().window().maximize();
		driver.navigate().to("http://localhost:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}