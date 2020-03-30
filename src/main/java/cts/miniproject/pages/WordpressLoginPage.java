package cts.miniproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WordpressLoginPage {
	WebDriver driver;
	By username = By.id("user_login");
	By password = By.xpath("//input[@id='user_pass']");
	By loginbutton = By.xpath("//input[@id='wp-submit']");
	By rememberme = By.xpath("//input[@id='rememberme']");

	// Parameterised Construtor 
	public WordpressLoginPage(WebDriver driver) {

		this.driver = driver;


	}
	//Parameterised Method ( can send data directly login,pass)
	public void typeUserNameAndPassword(String userid,String pass) {
		driver.findElement(username).sendKeys(userid);
		driver.findElement(password).sendKeys(pass);

	}
	//Non Parameterised
	public void typeUserName() {
		driver.findElement(username).sendKeys("admin");
	}

	public void typePassword() {
		driver.findElement(password).sendKeys("demo123");
	}

	public void clickonLoginButton() {
		driver.findElement(loginbutton).click();
	}

	public void clickonRememberMe() {
		driver.findElement(rememberme).click();
	}

}
