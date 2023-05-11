package stepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LoginPage;

import static org.junit.Assert.assertTrue;
import helper.Base;

public class LoginStepPage extends Base {

	LoginPage login = new LoginPage();

	@When("user enter userName")
	public void user_enter_user_name() {
		login.user_enter_user_name();

	}

	@And("user enter passWard")
	public void user_enter_pass_ward() {
		login.user_enter_pass_ward();

	}

	@And("user click login button")
	public void user_click_login_button() {
		login.user_click_to_login();

	}

	@Then("Validate Success Login")
	public void validate_success_login() {
		assertTrue(login.Validate_success_login());

	}

}
