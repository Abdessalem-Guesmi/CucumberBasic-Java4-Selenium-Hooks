package StepsDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomPages.LoginPageFactory;

public class LoginFacebookStepsHooks {
	WebDriver driver = null;
	LoginPageFactory login;

	@Before
	public void browserSetup() {

		System.out.println("i m a before method i will executed before each scenario");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		System.out.println("i m a after method i will executed after each scenario");
		driver.close();
		driver.quit();
	}

	@BeforeStep
	public void beforSteps() {
		System.out.println("i am inside before steps");
	}

	@AfterStep
	public void afterSteps() {
		System.out.println("i am inside after steps");

	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("i'm a Given method: user on login page");
		driver.get("https://www.facebook.com/");
	}

	@When("user enters (.*) and (.*)$")
	public void user_enters_user1_and_user1(String username, String password) {
		login = new LoginPageFactory(driver);
		login.enterUsername(username);
		login.enterPassword(password);

	}

	@And("clicks on button")
	public void clicks_on_button() {
		System.out.println("i'm a And method: user clicks on button");
		login.clickLogin();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("i'm a Then method: user navigated to the home page");
		String currentUrl = driver.getCurrentUrl();
		System.out.println("----------" + currentUrl);
		String expectedUrl = "https://www.facebook.com/";
		System.out.println("++++++++++++" + driver.getTitle());
		Assert.assertEquals("not equal", expectedUrl, currentUrl);

	}

}
