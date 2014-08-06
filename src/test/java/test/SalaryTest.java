package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.forms.*;
import webdriver.BaseTest;


public class SalaryTest extends BaseTest {


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
		devbyMP.clickOnSalary();
				
		logger.step(4);
		DevBySalaryPage devbySP = new DevBySalaryPage();
		devbySP.clickOnPositionAll();
				
		logger.step(5);
		devbySP.clickOnPositionQA();
						
		logger.step(6);
		browser.waitForPageToLoad();
		devbySP.assertDevBySalary();
		
	}

}
