package test.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

public class DevByBlogsPage extends BaseForm {
	private static String formlocator="//body/div[@class='wrapper dev all']";
	
	private TextBox searchBlogs = new TextBox(By.xpath("//div[@id='tablesort_filter']/label/input"),"search blogs field");
	private Button devByBlogLink = new Button(By.linkText("Блог команды dev.by"),"search blogs button");
	private Label toAllBlogs = new Label(By.linkText("Перейти к списку блогов"), "to all blogs link");
	private Label devByBlog = new Label(By.xpath("//h1[contains(.,'Блог команды dev.by')]"), "dev.by blog text");
	
	
	
	public void fillBlogSearch(String searchtext){
		searchBlogs.type(searchtext);
	}
	
	public void clickOnDevByBlog(){
		devByBlogLink.click();
	}
	
	public DevByBlogsPage() {
		super(By.xpath(formlocator), "dev.by Blogs page");
	}
	
	public void assertDevByBlog(){
		assert(devByBlog.isPresent() && toAllBlogs.isPresent());
	}
	
	
}
