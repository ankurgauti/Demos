package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By signin=By.xpath("//a/span[contains(text(),'Login')]");
	By username=By.xpath("//input[@id='user_email']");
	By password=By.xpath("//input[@id='user_password']");
	By btn_login=By.xpath("//input[@type='submit']");
	By navigation_bar=By.xpath("");
	By title=By.xpath("//*[@id=\"content\"]/div/div/h2");
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
	}



	public WebElement getLogin()
	{
		return driver.findElement(signin); 
		
	}
	public WebElement getEmail()
	{
		return driver.findElement(username);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLogged()
	{
		return driver.findElement(btn_login);
	}
	public WebElement getNavigationBar()
	{
		return driver.findElement(navigation_bar);
	} 
	public WebElement getTitle()
	{
		return driver.findElement(title);
	} 
}
