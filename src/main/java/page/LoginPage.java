package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

public class LoginPage extends Base {
	public void user_enter_user_name() {
		
		   WebElement userName =driver.findElement(By.xpath("//input[@id='user-name']"));
		   userName.sendKeys("standard_user");
		    
		}


		public void user_enter_pass_ward() {
			WebElement passWard = driver.findElement(By.xpath("//input[@id='password']"));
			passWard.sendKeys("secret_sauce");
		   
		}


		public void user_click_to_login() {
			WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
			loginBtn.click();
		   
		}
		
		public boolean Validate_success_login() {
			return driver.findElement(By.xpath("//span[@class='title']")).isDisplayed();
			
			   
		}

	

}
