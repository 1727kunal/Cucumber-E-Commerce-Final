package stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.TestBase;

public class LoginSteps extends TestBase{
	
	HomePage homePageObj;
	LoginPage loginPageObj;
	MyAccountPage myAccountPageObj;
	
	public LoginSteps() {
		homePageObj = new HomePage(driver);
		loginPageObj = new LoginPage(driver);
		myAccountPageObj = new MyAccountPage(driver);
	}

	@When("User clicks on Login link")
	public void user_clicks_on_login_link() {
		homePageObj.clickLoginLink();
	}

	@Then("User should land on the login page")
	public void user_should_land_on_the_login_page() {
		Assert.assertEquals(loginPageObj.getLoginPageTitle(), "Account Login");
	}

	@When("User enters the email as {string}")
	public void user_enters_the_email_as(String emailAddress) {
		loginPageObj.enterEmail(emailAddress);
	}

	@And("password as {string}")
	public void password_as(String password) {
		loginPageObj.enterPassword(password);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		loginPageObj.clickLoginButton();
	}

	@Then("User should see the {string}")
	public void userShouldSeeThe(String expectedLoginStatus) {
		if (expectedLoginStatus.equalsIgnoreCase("my account page"))
			Assert.assertEquals(myAccountPageObj.getMyAccountPageTitle(), "My Account");
		else if (expectedLoginStatus.equalsIgnoreCase("error message"))
			Assert.assertEquals(loginPageObj.getLoginPageTitle(), "Account Login");
	}
}
