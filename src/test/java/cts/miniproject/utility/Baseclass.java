package cts.miniproject.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Baseclass {
public WebDriver driver;
@BeforeMethod //(By using this browser launches for every test case)
//@BeforeClass //(By using this browser launches ONLY ONCE e)
public void setup() {
System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\HARSHA\\\\eclipse-workspace\\\\cts-selenium-harsha\\\\src\\\\test\\\\resources\\\\binaries\\\\chromedriver.exe");
driver=new ChromeDriver();

driver.get("https://opensource-demo.orangehrmlive.com/");
driver.manage().window().maximize();

Reporter.log("---Application started----",true);
}

@AfterMethod
//@AfterClass
public void teardown() {
driver.quit();
Reporter.log("Browser session End",true);
}
}
