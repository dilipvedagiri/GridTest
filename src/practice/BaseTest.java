package practice;


import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


/**Base Test Containing initializing Extent Report Parameterise Browser and Log the Status of the Test to the report
 * @author dvedagiri
 *
 */
public class BaseTest 
{
	public WebDriver driver;
	public DesiredCapabilities cap;
	Capabilities capabilities;
	String browsername;
	String browserversion;
	String testCaseName;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initTest(String browser) throws Exception 
	{
		URL url= new URL("http://localhost:4444/wd/hub");
		cap= new DesiredCapabilities();
		if(browser.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
					
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			ChromeOptions options= new ChromeOptions();
			options.merge(cap);
			
			driver = new RemoteWebDriver(url,options);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			cap.setCapability("browserName", "firefox");	
			driver = new RemoteWebDriver(url,cap);
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "./Drivers/MicrosoftWebDriver.exe");
			driver= new EdgeDriver();
			capabilities = ((RemoteWebDriver) driver).getCapabilities();
			browsername = capabilities.getBrowserName();
			browserversion=capabilities.getVersion();
		}	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/Register.html");
		/*driver.get("https://ehci-test.fa.us6.oraclecloud.com/");
		LoginPage loginpage= new LoginPage(driver);
		loginpage.Login();	*/
	}
	@AfterMethod
	public void Close_Browser(ITestResult result)
	{	
		driver.quit();
	}
}
