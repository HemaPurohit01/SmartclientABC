package tests;

import java.time.Duration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DropDownTable;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/Extent_Reports/report.html"
		})
public class DropDownTest {

	WebDriver driver;
	DropDownTable dropdown;
	
	@BeforeTest
	public void setup() throws Exception{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.smartclient.com/smartgwt/showcase/#featured_dropdown_grid_category");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		dropdown = new DropDownTable(driver) ;
		dropdown.clickOnCookies();
	}
	
	@Test(priority = 1)
	public void clickOnDropDownList() throws Exception{
		dropdown.clickOnListItems();

	}
	
	@Test(priority =  2)
	public void scrollDropdownList() throws Exception{
		dropdown.scrollDownList();
	}
	
	@Test(priority = 2)
	public void verifyDropdownList() throws Exception{
		dropdown.verifyDropDownListItems();
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
