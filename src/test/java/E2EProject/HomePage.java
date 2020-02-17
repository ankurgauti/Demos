package E2EProject;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;


public class HomePage extends base {
	public static Logger log=LogManager.getLogger(HomePage.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		String baseURL=prop.getProperty("url");
		System.out.println(baseURL);
		driver.get(baseURL);
		driver.manage().window().maximize();
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password) throws IOException
	{
		
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();
		l.getEmail().sendKeys(username);
		l.getPassword().sendKeys(password);
		
		l.getLogged().click();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[1][2];
		data[0][0]="abcd@gmail.com";
		data[0][1]="123456";
		//data[0][2]="Restricted User";
		/*data[1][0]="efgh@gmail.com";
		data[1][1]="78910";*/
		//data[1][2]="Non-Restricted User";
		
		return data;
		
	}
	@AfterTest
	public void close()
	{
		driver.close();
		driver=null;
	}
}
