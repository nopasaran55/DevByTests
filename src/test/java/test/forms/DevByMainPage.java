package test.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

public class DevByMainPage extends BaseForm {
	private static String formlocator="//div[@class='slider-news']";
	
	private Button blogLink = new Button(By.xpath("//a[@title='Блог']"),"link on blog page");
	private Button companyLink = new Button(By.xpath("//a[@title='Компании']"),"link on company page");
	private Button salaryLink = new Button(By.xpath("//a[@title='Зарплаты']"),"link on salary page");
	private Button jobLink = new Button(By.xpath("//a[@title='Работа']"),"link on job page");
	private Button eventLink = new Button(By.xpath("//a[@title='События']"),"link on event page");
	private Button forumLink = new Button(By.linkText("Форум"),"link on forum");
	private Button allUsersLink = new Button(By.partialLinkText("специалист"),"link on users page");
	private Button loginForm = new Button(By.linkText("Войти"),"login form");
	private TextBox loginSite = new TextBox(By.id("user_login"),"login field ");
	private TextBox passwordSite = new TextBox(By.id("user_password"),"password field");
	private Button loginButton = new Button(By.name("commit"),"login button");
	private Button registrationLink = new Button(By.linkText("Создать аккаунт"),"link on new user registration page");
	private Label devByLogo = new Label(By.className("header-logo"),"dev.by logo");
	private Button userNameAfterLogin;	
	
	
	public void clickOnBlog(){
		blogLink.click();
	}
	
	public void clickOnCompany(){
		companyLink.click();
	}
	
	public void clickOnSalary(){
		salaryLink.click();
	}
	
	public void clickOnJob(){
		jobLink.click();
	}
	
	public void clickOnEvent(){
		eventLink.click();
	}
	
	public void clickOnForum(){
		forumLink.click();
	}
	
	public void clickOnAllUsers(){
		allUsersLink.click();
	}
	
	public void openLoginForm(){
		loginForm.click();
	}
	
	public void registrationNewUser(){
		registrationLink.click();
	}
	
	public void fillLoginForm(String login, String password){
		loginSite.type(login);
		passwordSite.type(password);
		loginButton.click();
	}
	
	public DevByMainPage() {
		super(By.xpath(formlocator), "dev.by Main page");
	}
	
	public void clickOnUserName(String userName){
		userNameAfterLogin = new Button(By.linkText(userName),"user name on site after login");
		userNameAfterLogin.click();
	}
	
	public void assertDevByLogo(){
		assert(devByLogo.isPresent());
	}
		
//	public void hardSleep(int seconds){
//		try {
//		    Thread.sleep(seconds*1000);
//		} 
//		catch(InterruptedException e) {
//		}
//	}

}
