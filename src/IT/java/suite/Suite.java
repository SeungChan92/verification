package suite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Suite {
	protected WebDriver webDriver = null;
	
	@Before
	public void setUp() {
		if (webDriver == null)
			setup_webDriver();
	}
	@After
	public void finish() {
		webDriver.close();
	}
	
	private void setup_webDriver() {
			
		// # make
//		// ## [for] local test
//				System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
//				System.setProperty("webdriver.ie.driver", "driver/IEDriverServer.exe");
//				webDriver = new InternetExplorerDriver();
		// ## [for] remote
		try {
			webDriver = new RemoteWebDriver(
					new URL("http://127.0.0.1:9515"),
			        DesiredCapabilities.chrome());
//			webDriver = new RemoteWebDriver(
//					new URL("http://127.0.0.1:5555"),
//			        DesiredCapabilities.internetExplorer());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		// # configure
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
	}
}