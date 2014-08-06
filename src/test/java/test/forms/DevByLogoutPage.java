package test.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;

public class DevByLogoutPage extends BaseForm {
	private static String formlocator="//body/div[@class='wrapper dev all']";
	
	private Button logOut = new Button(By.linkText("Выйти"),"logout button");
	private Label confirmLogout = new Label(By.xpath("//div[@class='content-alert' and contains(., 'Вы вышли из системы!')]"),"confirm logout text");
	private Label userNameOnPage;
	
			
		
	public void userLogOut(){
		logOut.click();
	}
	
	public DevByLogoutPage() {
		super(By.xpath(formlocator), "dev.by LogOut page");
	}
	
	public void assertLogoutConfirm(){
		assert(confirmLogout.isPresent());
	}
	
	public void assertNoUserName(String UserName){
		userNameOnPage = new Label(By.xpath("//body[contains(., '"+UserName+"')]"),"user name on page");
		assert(!(userNameOnPage.isPresent()));
	}
	
	
}
