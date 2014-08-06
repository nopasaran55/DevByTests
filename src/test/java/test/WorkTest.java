package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.forms.*;
import webdriver.BaseTest;


public class WorkTest extends BaseTest {
	String totalVacancy;
	
	
	String siteUrl, searchtextvacan;
	@Test
	@Parameters({"siteUrl", "searchtextvacan"})
	
	public void readParams(String siteUrl, String searchtextvacan) throws Throwable {
		this.siteUrl = siteUrl;
		this.searchtextvacan = searchtextvacan;
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
		devbyMP.clickOnJob();
				
		logger.step(4);
		DevByWorkPage devbyWP = new DevByWorkPage();
		totalVacancy=devbyWP.totalPositionWork();
		devbyWP.fillWorkSearch(searchtextvacan);
				
		logger.step(5);
		devbyWP.clickOnDevByWorkSearch();
				
		logger.step(6);
		devbyWP.assertDevByWork(totalVacancy);
		
	}

}
