package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.forms.*;
import webdriver.BaseTest;


public class CompanyTest extends BaseTest {


	String siteUrl, searchtextcomp;
	@Test
	@Parameters({"siteUrl", "searchtextcomp"})
	
	public void readParams(String siteUrl, String searchtextcomp) throws Throwable {
		this.siteUrl = siteUrl;
		this.searchtextcomp = searchtextcomp;
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
		devbyMP.clickOnCompany();
				
		logger.step(4);
		DevByCompanyPage devbyCP = new DevByCompanyPage();
		devbyCP.fillBlogSearch(searchtextcomp);
				
		logger.step(5);
		devbyCP.clickOnItransitionCompany();
				
		logger.step(6);
		devbyCP.assertDevByCompany();
		
	}

}
