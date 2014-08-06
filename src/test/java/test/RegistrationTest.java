package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.forms.*;
import webdriver.BaseTest;

public class RegistrationTest extends BaseTest {
	String userNameReg;
		
	String siteUrl, passwordReg, emailPostfix ;
	@Test
	@Parameters({"siteUrl", "passwordReg", "emailPostfix"})
	
	public void readParams(String siteUrl, String passwordReg, String emailPostfix) throws Throwable {
		this.siteUrl = siteUrl;
		this.passwordReg = passwordReg;
		this.emailPostfix = emailPostfix;
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
		devbyMP.registrationNewUser();
				
		logger.step(4);
		DevByRegistrationPage devbyRP = new DevByRegistrationPage();
		devbyRP.clickOnAgreementCheckBox();
		userNameReg=devbyRP.usingScriptForRegistration(emailPostfix, passwordReg);
		
		logger.step(5);
		devbyRP.dataSendSuccessful();
				
		logger.step(6);
		devbyRP.confirmRegistrationByEMail(userNameReg);
		System.out.println("UserName is: "+userNameReg+"  and Password is: "+passwordReg);
		
						
	}

}
