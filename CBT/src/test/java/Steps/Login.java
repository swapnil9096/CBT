package Steps;

import org.testng.Assert;

import TestTakerPages.BasePage;
import TestTakerPages.DashBoard;
import TestTakerPages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends BasePage{
	
	LoginPage login = null;//=new LoginPage();
	DashBoard dash = null;
	
	
	@Before
	public void setUp()
	{
		login = new LoginPage();
		dash = new DashBoard();
	}
	
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Given("User should be on login page")
	public void user_should_be_on_login_page() {
		
		initialize();
	
	}

	@When("Enter <examNum> and <password>")
	public void enter_exam_num_and_password() {

		login.enterUserName(prop.getProperty("examNumber"));
		login.enterPassword(prop.getProperty("password"));
	
	}

	@When("Click on login button")
	public void click_on_login_button() {

		login.clickOnLoginBtn();
	
	}

	@Then("User should be navigated to exam dashboard page")
	public void user_should_be_navigated_to_exam_dashboard_page() {

		String Actual = dash.getCbtExamText();
		Assert.assertEquals(Actual, "CBT試験","Test Case Failed...");
	}
}
