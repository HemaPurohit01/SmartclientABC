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
import pages.AnimalTileFilter;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/Extent_Reports/report.html"
})
public class AnimalTileFilterTest {

	WebDriver driver;
	AnimalTileFilter animal;

	@BeforeTest
	public void setup() throws Exception{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.smartclient.com/smartgwt/showcase/#featured_tile_filtering");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		animal = new AnimalTileFilter(driver);
		animal.clickOnCookies();
	}

	@Test(priority = 1)
	public void animalSetUsingLetter () throws Exception {
		animal.enterAnimal("a");
	}

	@Test(priority = 2)
	public void clickOnSlider() throws Exception{
		animal.clickOnSort();
	}

	@Test(priority = 3)
	public void selectSortValue() throws Exception{
		animal.selectSortOption();
	}

	@Test(priority = 4)
	public void selectCheckboxToAscending() throws Exception{
		animal.selectListAscending();
	}

	@Test(priority = 5)
	public void ChangeSliderValue() throws Exception{
		animal.moveslider();
	}

	@Test(priority = 6)
	public void verifyAnimalsListSuccessfully() throws Exception{
		animal.verifyAnimalList();
	}

	@AfterTest
	public void close() {
		driver.quit();
	}


}
