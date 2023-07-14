package variousConcept;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTEST {
	
	
	WebDriver driver;
	
	By USER_NAME_FIELD = By.xpath("//input[@id='username']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGN_IN_BUTTON_FIELD = By.xpath("//button[@name='login']");
	By DASHBOARDHEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	By CUSTOMERS_FIELD = By.xpath("//span[text()='Customers']");
	By ADDCUSTOMER_FIELD = By.xpath("//a[text()='Add Customer']");
	By ADDCONTACT_FIELD = By.xpath("//h5[text()='Add Contact']");
	By FULLNAME_FIELD = By.xpath("//*[@id=\"account\"]");
	By CompanyDropDown_FIELD = By.xpath("//*[@id=\"cid\"]");
	
	//testdata or mockdata
	String USER_NAME = "demo@techfios.com";
	String PASSWORD = "abc123";
	String DASHBOARDHEADER_TEXT = "Dashboard";

	private String DASHBORDHEADER_TEXT;
	
	@BeforeMethod
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://www.techfios.com/billing/?ng=login/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
    public void LoginTest() {
    	
    	driver.findElement(USER_NAME_FIELD).sendKeys(USER_NAME);
    	driver.findElement(PASSWORD_FIELD).sendKeys(PASSWORD);
    	driver.findElement(SIGN_IN_BUTTON_FIELD).click();
    	Assert.assertEquals(driver.findElement(DASHBOARDHEADER_FIELD).getText(), DASHBOARDHEADER_TEXT, "Dashboard page not found");
    	
    }
    @AfterMethod
	public void teardown() {
		driver.close();
	}
}
