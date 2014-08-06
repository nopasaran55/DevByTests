package test.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Label;

public class DevByProfilePage extends BaseForm {
	private static String formlocator="//body/div[@class='wrapper dev no']";
	
	private Label userEMailOnPage;
	
	
	public DevByProfilePage() {
		super(By.xpath(formlocator), "dev.by Profile page");
	}
			
	public void assertUserEMailOnPage(String userEMailSite){
		userEMailOnPage = new Label(By.xpath("//div[@class='field data-email' and contains(., '"+userEMailSite+"')]"),"user e-mail on page");
		assert(userEMailOnPage.isPresent());
	}
	
		
}
