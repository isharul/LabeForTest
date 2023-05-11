package helper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends Base{
	
	@Before
	public void setup() {
		String browserName = pro.getProperty("browser");

		if (browserName.equals("chrome")) { // run on chrome browser

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);

		}

		else if (browserName.equals("Firefox")) { // launch Firefox browser
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--incognito");
			driver = new FirefoxDriver(options);

		}

		else if (browserName.equals("edge")) { // launch edge browser
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--incognito");
			driver = new EdgeDriver(options);
		}

		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // wait for finding webElement
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); // page loading time

	}
	@After
	public void tearDown(Scenario s) {
		if (s.isFailed()) {
			TakesScreenshot tScreenshot= (TakesScreenshot)driver;
			File scFile = tScreenshot.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyDirectory(scFile, new File("screenshort/"+s.getName()+".png"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		driver.quit();
	}

}
