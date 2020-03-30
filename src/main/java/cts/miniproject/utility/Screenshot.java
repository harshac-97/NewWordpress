package cts.miniproject.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

public String getScreenshot(WebDriver driver) {

	//Type conversion from webdriver to file
TakesScreenshot ts= (TakesScreenshot)driver;

//This gives screenshot in the form of file
File source=ts.getScreenshotAs(OutputType.FILE);

//RETURNS path in user directory in the screenshot folder which is stored in "path" in the form of string
String path= System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";

//The path is returned to vaiable destination
File destination=new File(path);

try {
FileUtils.copyFile(source,destination );
} catch (IOException e) {
// TODO Auto-generated catch block
System.out.println("Capture Failed" + e.getMessage());
}
return path;
}

}