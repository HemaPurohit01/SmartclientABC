package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Grid;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/Extent_Reports/report.html"
        })

public class GridTest {

    WebDriver driver;
    Grid grid;

    @BeforeTest
    public void setup() throws Exception{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.smartclient.com/smartgwt/showcase/#featured_nested_grid");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        grid = new Grid(driver) ;
        grid.clickOnCookies();
    }

    @Test(priority = 1)
    public void clickNestedGrid() throws Exception{
        grid.clickGrid();

    }

    @Test(priority =  2)
    public void scrollDropdownList() throws Exception{
        Thread.sleep(1000);
        grid.scrollList();
    }

    @Test(priority = 3)
    public void clickCorrection() throws Exception{
        Thread.sleep(1000);
        grid.clickCorrection();
    }

    @Test(priority = 4)
    public void clickUnitDescendingOption() throws Exception {
        Thread.sleep(2000);
        grid.clickUnitDescending();
    }

    @AfterTest
    public void close() {
        driver.quit();
    }

}

