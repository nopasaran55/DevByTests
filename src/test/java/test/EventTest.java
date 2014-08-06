package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.forms.*;
import webdriver.BaseTest;


public class EventTest extends BaseTest {


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
		devbyMP.clickOnEvent();
		
		logger.step(4);
		DevByEventPage devbyEP = new DevByEventPage();
		devbyEP.selectMinsk();
		
		logger.step(5);
		devbyEP.goToBottomPage();
		devbyEP.selectQASummer2014();
				
		logger.step(6);
		devbyEP.assertDevByEvent();
		
	}

}
