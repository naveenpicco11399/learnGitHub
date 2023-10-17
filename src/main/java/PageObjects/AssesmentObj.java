package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssesmentObj {

    WebDriver driver;

	public AssesmentObj(WebDriver ldriver) {
		driver=ldriver;
		PageFactory.initElements(ldriver, this);
		

	}
	
	/*
	 *Locator for Assesment  
	 */
	
	@FindBy(xpath = "//a[@href=\"/assessment?offset=0&received=received\"]")
	@CacheLookup
	WebElement Assessment;

	@FindBy(xpath = "(//button[@data-bs-target='#assesspublishModal'])[1]")
	@CacheLookup
	WebElement publishModal;

	@FindBy(xpath = "(//input[@role=\"combobox\"])[10]")
	@CacheLookup
	WebElement Examtype;
	
	@FindBy(xpath = "//div[text()='Hard']")
	@CacheLookup
	WebElement Hard;
	
	@FindBy(xpath = "//div[text()='Medium']")
	@CacheLookup
	WebElement Medium;

	@FindBy(xpath = "//div[text()='Easy']")
	@CacheLookup
	WebElement Easy;
	
	@FindBy(xpath = "(//input[@role=\"combobox\"])[11]")
	@CacheLookup
	WebElement ExamName;
	
	@FindBy(xpath = "//div[text()='cycle5']")
	@CacheLookup
	WebElement cycle5;


	@FindBy(xpath = "//input[@type='checkbox']")
	@CacheLookup
	WebElement AssignSection;
	
	@FindBy(xpath = "//button[text()=' Choose sections']")
	@CacheLookup
	WebElement ChooseSections;
	
	@FindBy(xpath = "(//label[(text()=\"A\")])")
	@CacheLookup
	WebElement sectionA;
	
	@FindBy(xpath = "//input[@placeholder='hh:mm:ss']")
	@CacheLookup
	WebElement startTime;
	
	@FindBy(xpath = "//span[text()='​']/following::textarea")
	@CacheLookup
	WebElement Instructions;
	
	@FindBy(xpath = "//button[text()='Save']")
	@CacheLookup
	WebElement Save;
	
	
	//Method for Assesment
	
	public void Assessment() {
		Assessment.click();
	}


	public void publishModal() {
		publishModal.click();
	}
	public void Examtype() {
		Examtype.click();
	}


	public void Easy() {
		Easy.click();
	}
	public void ExamName() {
		ExamName.click();
	}


	public void cycle5() {
		cycle5.click();
	}

	public void AssignSection() {
		AssignSection.click();
	}


	public void ChooseSections() {
		ChooseSections.click();
	}
	
	public void sectionA() {
		sectionA.click();
	}
	
	public void startTime() {
		startTime.sendKeys("11:11 am");
	}
	
	
	public void Instructions() {
		Instructions.sendKeys(" Do not fail to attend the test");
	}
	
	public void Save() {
		Save.click();
	}
	
	//student 
	
	@FindBy(xpath = "//button[text()=\"Start test\"]")
	@CacheLookup
	WebElement StartTest;

	@FindBy(xpath = "//button[text()=\"Continue\"]")
	@CacheLookup
	WebElement Continue;

	@FindBy(xpath = "//button[text()=\"Submit Assessment\"]")
	@CacheLookup
	WebElement Submit_Assessment;
	
	@FindBy(xpath = "//a[text()=\"Abort, I don’t want to submit\"]")
	@CacheLookup
	WebElement Abort;
	
	@FindBy(xpath = "//button[text()=\"Close\"]")
	@CacheLookup
	WebElement Close;

	@FindBy(xpath = "//button[text()=\"Completed Assessment\"]")
	@CacheLookup
	WebElement CompletedAssessment;
	
	//admin
	
	@FindBy(xpath = "//button[text()='Published']")
	@CacheLookup
	WebElement Published;
	
	@FindBy(xpath = "(//button[text()='View Details'])[1]")
	@CacheLookup
	WebElement ViewDetails;
	
	@FindBy(xpath = "(//div[@class='Viewstudent_view_std_detail_td__4esez undefined'])[1]")
	@CacheLookup
	WebElement AnswerSheet;
	
	@FindBy(xpath = "//label[text()=' Send to students ']")
	@CacheLookup
	WebElement  SendStudents;
	
	@FindBy(xpath = "//button[text()='Save']")
	@CacheLookup
	WebElement  SaveToStudent;
	
	@FindBy(xpath = "(//button[text()='Yes'])[3]")
	@CacheLookup
	WebElement  YesBtn;
	
	//student
	
	
	@FindBy(xpath = "(//button[text()='View Results'])[1]")
	@CacheLookup
	WebElement ViewResults;
	
	@FindBy(xpath = "//button[text()='View feedback']")
	@CacheLookup
	WebElement  Viewfeedback;
	
    
}
