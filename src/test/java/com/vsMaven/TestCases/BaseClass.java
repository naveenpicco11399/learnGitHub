package com.vsMaven.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vsMaven.PageObjects.AssesmentObj;
import com.vsMaven.PageObjects.schoolLoginOBJ;
import com.vsMaven.Utils.Helper;
import com.vsMaven.Utils.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{

    public static WebDriver driver;
	ReadConfig rc = new ReadConfig();
	public String SaasUrl = rc.getSaasUrl();
	public String SaasUname = rc.getSaasUname();
	public String SaasPword = rc.getSaasPword();
	public String schlLogin = rc.getschlLogin();
	public String schlCode = rc.getschlCode();
	public String adminUname = rc.getschlUname();
	public String adminPword = rc.getschlPword();
	public String stdUname = rc.getstdUname();
	public String stdPword = rc.getstdPword();
	
	
	public static Logger log;
	public static ExtentReports er;
	public static ExtentTest et;

	public schoolLoginOBJ sl;
	public AssesmentObj ao;

	@BeforeSuite
	public void extendReport() {

		ExtentHtmlReporter html = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/report/Izome_Report" + Helper.getTime() + ".html"));
		er = new ExtentReports();
		er.attachReporter(html);
	}

	@AfterMethod
	public void report(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			et.fail("Test Case Is Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.screenshot(driver)).build());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			et.pass("Test case passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.screenshot(driver)).build());

		}

		er.flush();

	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}

	@BeforeClass
	public void launchBrowser() {

		log = Logger.getLogger("spurtStore");
		PropertyConfigurator.configure("log4j.properties");

		if (rc.getBrowser().equals("chrome")) {

			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);

		} else if (rc.getBrowser().equals("firefox")) {
			FirefoxOptions option = new FirefoxOptions();
			// option.addArguments("--remote-allow-origins=*");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(option);
		}

		else if (rc.getBrowser().equals("edge")) {
			EdgeOptions option = new EdgeOptions();
			option.addArguments("--remote-allow-origins=*");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(option);

		}

	}

	public void schoolLogin() {
		driver.get(schlLogin);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		sl = new schoolLoginOBJ(driver);
		sl.SchoolCode(schlCode);
		sl.submit();
		sl.UserID(SaasUname);
		sl.Password(SaasPword);
		sl.LOGIN();

	}
	
	
	public void studentLogin() {
		driver.get(schlLogin);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		sl = new schoolLoginOBJ(driver);
		sl.SchoolCode(schlCode);
		sl.submit();
		sl.UserID(stdUname);
		sl.Password(stdPword);
		sl.LOGIN();
		
	}
	
	public void caputureScreen(WebDriver driver, String Name) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/screenshots/" + Name + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
	}

	public void waitTimeMin() throws InterruptedException {
		Thread.sleep(3000);
	}

	public void waitTime() throws InterruptedException {
		Thread.sleep(5000);
	}

	public void waitTimeMax() throws InterruptedException {
		Thread.sleep(10000);
	}

	public void scrollDown() {
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,800)");
	}

	public void scrollDownMin() {
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,500)");
	}

	public void scrollUp() {
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,-800)");
	}

	public void scrollBottom() {
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

}