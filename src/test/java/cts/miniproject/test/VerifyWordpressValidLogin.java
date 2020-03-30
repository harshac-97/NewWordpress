package cts.miniproject.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import cts.miniproject.pages.WordpressLoginPage;

public class VerifyWordpressValidLogin {
	@Test
	public void VerifyValidLogin() {


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HARSHA\\eclipse-workspace\\cts-selenium-harsha\\src\\test\\resources\\binaries\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://demosite.center/wordpress/wp-login.php");


		WordpressLoginPage login = new WordpressLoginPage(driver);

		//Parameterised Method
		login.typeUserNameAndPassword("admin", "demo123");

		//Non parameterised method calling
		/* login.typeUserName();
	 login.typePassword();*/

		login.clickonRememberMe();
		login.clickonLoginButton(); 

		//Assert is for verification(actual url, result url)
		String url=driver.getCurrentUrl();
		Assert.assertEquals("http://demosite.center/wordpress/wp-admin/", url);
	}
}
