package test.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;

public class DevByEventPage extends BaseForm {
	private static String formlocator="//body/div[@class='wrapper dev all']";
	
	private Button inMinsk = new Button(By.linkText("Минск"),"events in Minsk");
	private Button qaSummer2014 = new Button(By.linkText("QA Summer 2014"),"event 'QA Summer 2014'");
	private Label qaSummerDateIsSept14 = new Label(By.xpath("//div[@class='time' and contains(text(), '14 Сентября')]"), "date of 'QA Summer 2014' event");
	private Label copyright = new Label(By.className("copyright"), "copyright at the bottom of page"); //element at the bottom of page - to scroll page to bottom
	
		
		
	public void selectMinsk(){
		inMinsk.click();
	}
	
	public void selectQASummer2014(){
		qaSummer2014.click();
	}
	
	public void goToBottomPage(){
		copyright.click();
	}
	
	public DevByEventPage() {
		super(By.xpath(formlocator), "dev.by Event page");
	}
		
	public void assertDevByEvent(){
		assert(qaSummerDateIsSept14.isPresent());
		}
	
	
}
