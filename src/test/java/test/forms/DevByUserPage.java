package test.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;


public class DevByUserPage extends BaseForm {
	private static String formlocator="//body";
	
	private Button adminUser = new Button(By.linkText("admin"),"link on user with name 'admin' ");
	private Button usersPosts = new Button(By.partialLinkText("пост"),"link on user's posts");
	private Button lastPageOfUserPosts = new Button(By.linkText("Последняя"),"link on last page of user posts");
	private Button helloWorldPost = new Button(By.linkText("Hello, World!"),"link on post 'Hello, World!'");
	
		
		
	public void selectAdmin(){
		adminUser.click();
	}
	
	public void selectPostsOfUser(){
		usersPosts.click();
	}
	
	public void selectLastPageOfPosts(){
		lastPageOfUserPosts.click();
	}
	
	public DevByUserPage() {
		super(By.xpath(formlocator), "dev.by User page");
	}
		
	public void assertDevByUser(){
		assert(helloWorldPost.isPresent());
		}
	
	
}
