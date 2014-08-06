package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.forms.*;
import webdriver.BaseTest;


public class LoginTest extends BaseTest {

			
	String siteUrl, userNameSite, passwordSite, userEMailSite ;
	@Test
	@Parameters({"siteUrl", "userNameSite", "passwordSite", "userEMailSite"})
	
	public void readParams(String siteUrl, String userNameSite, String passwordSite, String userEMailSite) throws Throwable {
		this.siteUrl = siteUrl;
		this.userNameSite = userNameSite;
		this.passwordSite = passwordSite;
		this.userEMailSite = userEMailSite;
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
		devbyMP.openLoginForm();
				
		logger.step(4);
		devbyMP.fillLoginForm(userNameSite, passwordSite);
				
		logger.step(5);
		browser.waitForPageToLoad();
		devbyMP.clickOnUserName(userNameSite);	
		
		logger.step(6);
		DevByProfilePage devbyPP = new DevByProfilePage();
		devbyPP.assertUserEMailOnPage(userEMailSite);
		
	}

}
