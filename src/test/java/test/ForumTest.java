package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.forms.*;
import webdriver.BaseTest;


public class ForumTest extends BaseTest {
	
	
	String siteUrl;
	@Test
	@Parameters({"siteUrl"})
	
	public void readParams(String siteUrl) throws Throwable {
		this.siteUrl = siteUrl;
		xTest();
	}
	
	@Override
	@Parameters()	
	
		
	public void runTest() {

		logger.step(1);
		browser.navigate(siteUrl);
				
		logger.step(2);
		DevByMainPage devbyMP = new DevByMainPage();
		devbyMP.assertDevByLogo();
		
		logger.step(3);
		devbyMP.clickOnForum();
				
		logger.step(4);
		DevByForumPage devbyFP = new DevByForumPage();
		devbyFP.selectCourses();
				
		logger.step(5);
		devbyFP.selectItransitionCoursesTopic();
		
		logger.step(6);
		devbyFP.assertDevByForum();
		
	}

}
