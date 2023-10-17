package Utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import java.text.Format;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
    public static String getTime() {
		
		DateFormat df= new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
		Date dt= new Date();
		return df.format(dt);
		
	}

	
	public static String screenshot(WebDriver driver) {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		String ss=System.getProperty("user.dir")+"/screenshots/izome"+getTime()+".png";
		
		try {
			FileUtils.copyFile(source, new File(ss));
			System.out.println("screenshot taken");
			
		} catch (Exception e) {
			System.out.println("unable to take screenshot"+e.getMessage());
		}
		return ss;
		}
}
