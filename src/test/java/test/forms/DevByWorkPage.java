package test.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

public class DevByWorkPage extends BaseForm {
	private static String formlocator="//h3[contains(., 'Поиск вакансий')]";
	
	private TextBox searchPosition = new TextBox(By.id("search-jobs_token"),"search field by position");
	private Button devByWorkSearch = new Button(By.xpath("//input[@class='b-submit']"),"search button for positions");
	private Label workTotal = new Label(By.xpath("//div[@class='info-jobs']/a/strong"), "total number of vacancies");
	
	
	
	
	
		
	public void fillWorkSearch(String searchtext){
		searchPosition.type(searchtext);
	}
	
	public void clickOnDevByWorkSearch(){
		devByWorkSearch.click();
	}
	public String totalPositionWork(){
		String total=workTotal.getText();
		return total;
	}
	
	public DevByWorkPage() {
		super(By.xpath(formlocator), "dev.by Work page");
	}
	
	public void assertDevByWork(String totalBefore){
		String total=workTotal.getText();
			if(total.length()!=totalBefore.length()){                        // compare 2 strings, not numbers. 
				for (int i=1; i<=(totalBefore.length()-total.length());i++){ // if 'start string' size larger than 
				total="0"+total;                                             // 'finish string' size (i.e. '12' vs. '9') - 
				}                                                            //adding zeros at the string beginning to equalize strings size (i.e. '12' vs. '09')
			}
		assert(total.compareTo(totalBefore)<0);
	}
	
	
}
