
package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	// static webDriver driver; we are define static to variable for store the value
	// in variable
	// and public for global use
	public static WebDriver driver;

	public static Properties pro;

	// static block are used for load all the file before execution or before
	// initiation of driver because they
	// read the file first
	static {
		try {
			FileInputStream file = new FileInputStream("TestData/TestData.properties");
			pro = new Properties();
			pro.load(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	

	public void waitForvisiblityofElement(WebElement ele, int timeout) { // visiblityofElement
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitForAlert(int timout) { // AlertPresent
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timout));
		wait.until(ExpectedConditions.alertIsPresent());

	}

	public void waitForElementClickable(WebElement ele, int timout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timout)); // wait for element to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(ele));

	}

	public void mouseHover(WebElement ele) { // MouseHouver
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
	}

	public void selectAlertPopup(int timeout) {
		waitForAlert(timeout);
		Alert a = driver.switchTo().alert();
		a.accept();

	}

	public void cancelAlertPopup() {
		Alert a = driver.switchTo().alert();
		a.dismiss();

	}

	public void selectDropDownbyVisibleText(WebElement ele, String value) {
		Select s = new Select(ele);
		s.selectByVisibleText(value);

	}

//	public void bootstrapDropDown(WebElement ele, String text) {
//		if(WebElement ele:Text)

//	public void takeScreenShort() { // ScreenShort
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File scFile = ts.getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyDirectory(scFile, new File("ScreenShorts/test.png"));
//			FileUtils.copyDirectory(scFile, new File("screenshort/"+System.currentTimeMillis()+".png"));
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}

	}


