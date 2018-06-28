package practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DemoGridTTest
{
	@Test
	public void testGrid() throws MalformedURLException
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\GridProject\\drivers\\chromedriver.exe");
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		ChromeOptions options= new ChromeOptions();
		options.merge(cap);
		URL url= new URL("http://localhost:4444/wd/hub");
		
		WebDriver driver = new RemoteWebDriver(url,options);
		driver.get("https://www.google.com/");
		String title=driver.getTitle();
		System.out.println(title);
		driver.quit();
	}

}
