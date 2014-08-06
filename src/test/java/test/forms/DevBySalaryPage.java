package test.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;

public class DevBySalaryPage extends BaseForm {
	private static String formlocator="//body/div[@class='wrapper dev all']";
		
	private Button devByPositionLink = new Button(By.linkText("Должности"),"link on positions");
	private Button devByPositionQALink = new Button(By.partialLinkText("QA Engineer"),"link on QA position");
	private Label devBySalaryRations = new Label(By.xpath("//strong[contains(., 'Соотношение размеров зарплат')]"), "salary rations text");
	private Label devBySalaryForQA = new Label(By.xpath("//span[@class='ui-selectmenu-status' and contains(., 'QA Engineer/ Tester')]"), "salary for QA in menu");
	
	
		
	public void clickOnPositionAll(){
		devByPositionLink.click();
	}
	
	public void clickOnPositionQA(){
		devByPositionQALink.click();
	}
	
	public DevBySalaryPage() {
		super(By.xpath(formlocator), "dev.by Salary page");
	}
	
	public void assertDevBySalary(){
		assert(devBySalaryRations.isPresent(10) && devBySalaryForQA.isPresent(10));
	}
	
		
}
