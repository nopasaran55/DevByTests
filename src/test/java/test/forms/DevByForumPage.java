package test.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;

public class DevByForumPage extends BaseForm {
	private static String formlocator="//a[@title='Найти темы с недавними сообщениями.']";
	
	private Button coursesAndSeminars = new Button(By.xpath("//span[contains(.,'Курсы и семинары')]"),"courses and seminars topic");
	private Button coursesItransition = new Button(By.linkText("Курсы Тестирования ПО в itransition"),"courses in Itransition topic");
	private Label firstPost = new Label(By.xpath("//h3[@class='hn post-ident' and node()='1' and contains(., 'yellowcard')]"), "first post in topic");
	
			
		
	public void selectCourses(){
		coursesAndSeminars.click();
	}
	
	public void selectItransitionCoursesTopic(){
		coursesItransition.click();
	}
	
	public DevByForumPage() {
		super(By.xpath(formlocator), "dev.by Forum page");
	}
	
	public void assertDevByForum(){
		assert(firstPost.isPresent());
		}
	
	
}
