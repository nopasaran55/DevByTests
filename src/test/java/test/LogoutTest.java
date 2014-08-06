package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.forms.*;
import webdriver.BaseTest;

public class LogoutTest extends BaseTest {
	
	
	String siteUrl, userNameSite, passwordSite ;
	@Test
	@Parameters({"siteUrl", "userNameSite", "passwordSite"})
	
	public void readParams(String siteUrl, String userNameSite, String passwordSite) throws Throwable {
		this.siteUrl = siteUrl;
		this.userNameSite = userNameSite;
		this.passwordSite = passwordSite;
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
		DevByLogoutPage devbyLP = new DevByLogoutPage();
		devbyLP.userLogOut();
		
		logger.step(6);
		devbyLP.assertLogoutConfirm();
		devbyLP.assertNoUserName(userNameSite);
		
	}

}
