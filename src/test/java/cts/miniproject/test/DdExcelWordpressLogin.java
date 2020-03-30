package cts.miniproject.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cts.miniproject.utility.ExcelDataConfig;

public class DdExcelWordpressLogin {
WebDriver driver;
//we get data from @DataProvider wordpress is the variable name
@Test(dataProvider="wordpress")
public void loginToWordpress(String username,String password) {

System.setProperty("webdriver.chrome.driver", "C:\\Users\\HARSHA\\eclipse-workspace\\NewWordpress\\src\\test\\resources\\binaries\\chromedriver.exe");
driver=new ChromeDriver();

driver.get("http://demosite.center/wordpress/wp-login.php");
driver.manage().window().maximize();
driver.findElement(By.id("user_login")).sendKeys(username);
driver.findElement(By.id("user_pass")).sendKeys(password);
driver.findElement(By.xpath("//input[@id='wp-submit']")).click();

Assert.assertEquals("http://demosite.center/wordpress/wp-admin/", driver.getCurrentUrl());

System.out.println(driver.getCurrentUrl());
System.out.println("User is able to Login Successfully");
}

//This is executed AFTER EACH METHOD
@AfterMethod
public void tearDown() {
driver.quit();
}

//THIS works like for look to give data to the program multiple times
@DataProvider(name="wordpress")

//String data is passing in the form of Java object through creating method passData()
public Object[][] passData() {


ExcelDataConfig configExcel = new ExcelDataConfig("C:\\Users\\HARSHA\\eclipse-workspace\\NewWordpress\\src\\test\\resources\\XLSX\\TestData2.xlsx");
int noOfRows = configExcel.getRowCont(0);
Object[][] data = new Object[noOfRows][2];

for(int i=0;i<noOfRows;i++) {
	data[i][0] = configExcel.getData(0, i, 0);
	data[i][1] = configExcel.getData(0, i, 1);
	
}

return data;
}

}