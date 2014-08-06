package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.forms.*;
import webdriver.BaseTest;


public class UserTest extends BaseTest {


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
		devbyMP.clickOnAllUsers();
				
		logger.step(4);
		DevByUserPage devbyUP = new DevByUserPage();
		devbyUP.selectAdmin();
		
		logger.step(5);
		devbyUP.selectPostsOfUser();
		
		logger.step(6);
		devbyUP.selectLastPageOfPosts();
				
		logger.step(7);
		devbyUP.assertDevByUser();
		
	}

}
