package pomPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPageFactory {

	WebDriver driver;

	@FindBy(id = "email")
	@CacheLookup
	WebElement txt_username;
	@FindBy(id = "pass")
	WebElement txt_passowrd;
	@FindBy(name = "login")
	WebElement btn_login;

	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}

	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}

	public void enterPassword(String password) {
		txt_passowrd.sendKeys(password);
	}

	public void clickLogin() {
		btn_login.sendKeys(Keys.RETURN);
	}
}
