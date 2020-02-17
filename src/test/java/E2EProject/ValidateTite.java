package E2EProject;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

//adding logs
//generating HTML reports
//screenshots on failure
//jenkins integration
public class ValidateTite extends base{
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		String baseURL=prop.getProperty("url");
		System.out.println(baseURL);
		driver.get(baseURL);
		driver.manage().window().maximize();
	}
	@Test
	public void basePageNavigation() throws IOException
	{
		
		LandingPage l=new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "Featured Courses");
		log.info("Succesfully validated Title");
	}
	@AfterTest
	public void close()
	{
		driver.close();
		driver=null;
	}
}
