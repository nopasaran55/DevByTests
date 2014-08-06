package test.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

import java.util.concurrent.TimeUnit;

public class DevByRegistrationPage extends BaseForm {
	private static String formlocator="//body[@class='body-blue']";
	
	private TextBox registrationUserName = new TextBox(By.id("user_username"),"registration user name field");
	private TextBox registrationUserEMail = new TextBox(By.id("user_email"),"registration user e-mail field");
	private TextBox registrationUserPassword = new TextBox(By.id("user_password"),"registration user password field");
	private TextBox registrationUserPasswordConfirm = new TextBox(By.id("user_password_confirmation"),"registration user password confirm field");
	private TextBox registrationUserAgreementAccept = new TextBox(By.xpath("//label[contains(., 'Я согласен с')]"),"registration user agreement accept field");
	private Button registrationButton = new Button(By.name("commit"),"registration button");
	private Label confirmRegistration = new Label(By.xpath("//div[@class='block-alerts' and contains(., 'Проверьте почту и активируйте свой профиль')]"),"confirm registration text");
	private Label userAlreadyExists = new Label(By.xpath("//div[@class='errors' and contains(., 'Неправильно заполнены следующие поля')]"), "user already exists text warning");
	
	//private Label successRegistration = new Label(By.xpath("//div[@class='content-alert' and contains(., 'Ваш аккаунт был успешно подтвержден')]"), "successRegistration");
	//private Label successRegistrationv2 = new Label(By.xpath("//div[@class='dev-center dev-single' and contains(., 'Войти')]"), "successRegistrationv2");
	//private Button selectConfirmEMail = new Button(By.linkText("Подтверждение аккаунта"),"selectConfirmEMail");
	//private Button confirmLetterClickLink = new Button(By.xpath("//iframe[@id='emailframe']/*/a[contains(., 'подтвердить')]"),"confirmLetterClickLink");

	
	
	public void fillRegistrationForm(String login, String email, String password){
		registrationUserName.setText(login);
		registrationUserEMail.setText(email);
		registrationUserPassword.setText(password);
		registrationUserPasswordConfirm.setText(password);
	}
	
	public void clickOnAgreementCheckBox(){
		registrationUserAgreementAccept.click();
	}
	
	public void clickOnRegistrationButton(){
		registrationButton.click();
	}
	
	public boolean dataSendSuccessful(){
		if (confirmRegistration.isPresent()){
			return true;
		}else{
		return false;
		}
	}
	
	public boolean thisUserAlreadyRegistered(){
		if (userAlreadyExists.isPresent()){
			return true;
		}else{
		return false;
		}
	}
		
	public String usingScriptForRegistration(String emailPostfix, String passwordReg){
		String output="";
		int i=0;
			while (i<10 && ( !(dataSendSuccessful()) || (thisUserAlreadyRegistered()) )){
			String userNameReg=createNewUserName();
			String emailReg=userNameReg+emailPostfix;
			fillRegistrationForm(userNameReg, emailReg, passwordReg);
			clickOnRegistrationButton();
			i++;
			output="";
			output=output+userNameReg;
			}
			return output;
	}
		
	public void confirmRegistrationByEMail(String newUserLoginName){
		String mailAddress="http://mailcatch.com/en/temporary-inbox?box="+newUserLoginName;
		WebDriver maildriver = new FirefoxDriver();
		maildriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		maildriver.navigate().to(mailAddress);
		maildriver.findElement(By.linkText("Подтверждение аккаунта")).click();
		maildriver.switchTo().frame(maildriver.findElement(By.id("emailframe")));
		maildriver.findElement(By.linkText("подтвердить")).click();
		assert(maildriver.findElement(By.xpath("//div[@class='content-alert' and contains(., 'Ваш аккаунт был успешно подтвержден')]")).isDisplayed());
	}
	
//	public void clickOnConfirmMail(){
//		selectConfirmEMail.click();
//	}
	
//	public void clickOnConfirmLink(){
//		confirmLetterClickLink.click();
//	}
	
	public String createNewUserName(){
		UserNameGenerator userNG = new UserNameGenerator();
		String newUserName=userNG.generateNewLogin();
		return newUserName;
	}
			
	public DevByRegistrationPage() {
		super(By.xpath(formlocator), "dev.by registration form");
	}
	
}
