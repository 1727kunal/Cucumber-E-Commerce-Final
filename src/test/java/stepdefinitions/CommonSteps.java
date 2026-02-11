package stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.MyAccountPage;
import testbase.TestBase;

public class CommonSteps extends TestBase {
	HomePage homePageObj;
	MyAccountPage myAccountPageObj;
	
	public CommonSteps() {
		homePageObj = new HomePage(driver);
		myAccountPageObj = new MyAccountPage(driver);
	}
	
	@Given("User should land on the homepage")
	public void user_should_land_on_the_homepage() {
		Assert.assertEquals(homePageObj.getHomePageTitle(), "Your Store");
	}

	@When("User clicks on MyAccount button")
	public void user_clicks_on_my_account_button() {
		homePageObj.clickMyAccountButton();
	}

	@Then("User should land on the my account page")
	public void user_should_land_on_the_my_account_page() {
		Assert.assertEquals(myAccountPageObj.getMyAccountPageTitle(), "My Account");
	}
}
