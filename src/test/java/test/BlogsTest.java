package test;

import test.forms.*;
import webdriver.BaseTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BlogsTest extends BaseTest {
		

	String siteUrl, searchtextblog;
	@Test
	@Parameters({"siteUrl", "searchtextblog"})
	
	public void readParams(String siteUrl, String searchtextblog) throws Throwable {
		this.siteUrl = siteUrl;
		this.searchtextblog = searchtextblog;
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
		devbyMP.clickOnBlog();
				
		logger.step(4);
		DevByBlogsPage devbyBP = new DevByBlogsPage();
		devbyBP.fillBlogSearch(searchtextblog);
				
		logger.step(5);
		devbyBP.clickOnDevByBlog();
				
		logger.step(6);
		devbyBP.assertDevByBlog();
		
	}


}
