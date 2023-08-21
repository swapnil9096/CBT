package Steps;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WindowType;

import AdminPages.AdminLoginPage;
import TestTakerPages.BasePage;
import TestTakerPages.DashBoard;
import TestTakerPages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClearLogin extends BasePage{
	
	LoginPage login;	
	AdminLoginPage adminLogin; 
	DashBoard dash; 
	
	@Before
	public void setUp()
	{
		login = new LoginPage();
		adminLogin = new AdminLoginPage();
		dash = new DashBoard();
	}
	
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Given("User should login as Test taker")
	public void user_should_login_as_test_taker() {
		initialize();
		login.enterUserName(prop.getProperty("examNumber"));
		login.enterPassword(prop.getProperty("password"));
		login.clickOnLoginBtn();
	}

	@When("User started the test")
	public void user_started_the_test() {
		dash.clickOnExamInfoBtn();
		dash.ClickOnNextBtn();
		dash.clickOnToStartTestBtn();
		dash.clickOnStartTestBtn();
	}

	@Then("Clear the login from test centre")
	public void clear_the_login_from_test_centre() throws InterruptedException {
		
		driver.switchTo().newWindow(WindowType.TAB).get(prop.getProperty("url"));
		
		Set<String> win = driver.getWindowHandles();
		Iterator<String> iter = win.iterator();
		String parWin = iter.next();
		String childWin =iter.next();
		
		driver.switchTo().window(childWin);
		adminLogin.getAdminLogin(prop.getProperty("adminId"), prop.getProperty("adminPass"));
		
		adminLogin.clickOnClearLogin();

		adminLogin.clickOnExameeNumberTextBox();
		adminLogin.clickOnCandidateSearch();
		adminLogin.clickOnSearchBtn();
		adminLogin.clickOnExamNumerRadioBtn();
		adminLogin.clickOnChooseBtn();
		adminLogin.clickOnClearLoginBtn();
		adminLogin.clickOnConfirmClearYesBtn();
		driver.switchTo().window(parWin);
		
	}

	@Then("User should stop the test")
	public void user_should_stop_the_test() {
		dash.clickOnPopUpNo();
	
	}


}
