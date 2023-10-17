package TestCases;

import org.testng.annotations.Test;

import PageObjects.AssesmentObj;

public class AssesmentTC extends BaseClass {

	@Test
	public void AssignAssesment() throws InterruptedException {

		et = er.createTest("Assignin the assesment");
		et.pass("School Page Launch");

		ao = new AssesmentObj(driver);

		schoolLogin();

		ao.Assessment();
		et.pass("Assessment is clicked");
		log.info("Assessment is clicked");

		// Thread.sleep(3000);

		// ao.publishModal();
		// et.pass("publishModal is clicked");
		// log.info("publishModal is clicked");

		// waitTimeMin();

		// ao.Examtype();
		// et.pass("Examtype is clicked");
		// log.info("Examtype is clicked");

		// ao.Easy();
		// et.pass("Easy is clicked");
		// log.info("Easy is clicked");

		// waitTimeMin();
		// ao.ExamName();
		// et.pass("ExamName is clicked");
		// log.info("ExamName is clicked");

		// ao.cycle5();
		// et.pass("cycle5 is clicked");
		// log.info("cycle5 is clicked");

		// ao.AssignSection();
		// et.pass("AssignSection is clicked");
		// log.info("AssignSection is clicked");

		// ao.ChooseSections();
		// et.pass("ChooseSections is clicked");
		// log.info("ChooseSections is clicked");

		// ao.sectionA();
		// et.pass("sectionA is clicked");
		// log.info("sectionA is clicked");

		// ao.startTime();
		// et.pass("startTime is clicked");
		// log.info("startTime is clicked");

		// ao.Instructions();
		// et.pass("Instructions is Entered");
		// log.info("Instructions is Entered");

		// ao.Save();
		// et.pass("Assesment saved successfully");
		// log.info("Assesment saved successfully");

	}

}
