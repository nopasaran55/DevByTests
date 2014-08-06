package test.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

public class DevByCompanyPage extends BaseForm {
	private static String formlocator="//body/div[@class='wrapper dev all']";
		
	private TextBox searchCompany = new TextBox(By.xpath("//div[@id='tablesort_filter']/label/input"),"search company field");
	private Button devByCompanyLink = new Button(By.linkText("Itransition"),"link on company Itransition");
	private Label devByItransition = new Label(By.xpath("//div[@class='full-name' and contains(text(), 'ЗАО \"Итранзишэн\"')]"), "Itransition name text");
	
	
	
	public void fillBlogSearch(String searchtext){
		searchCompany.type(searchtext);
	}
	
	public void clickOnItransitionCompany(){
		devByCompanyLink.click();
	}
	
	public DevByCompanyPage() {
		super(By.xpath(formlocator), "dev.by Company page");
	}
	
	public void assertDevByCompany(){
		assert(devByItransition.isPresent());
	}
	
	
}
