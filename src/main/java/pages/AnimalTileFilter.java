package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnimalTileFilter {
	WebDriver driver;

	public AnimalTileFilter(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='popupPPC']/a[2]")
	WebElement iAgree;

	@FindBy(id = "isc_2P")
	WebElement animalfield;

	@FindBy(id = "isc_3C")
	WebElement dropdownSort;

	@FindBy(xpath = "//body[1]/div[7]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]")
	WebElement sortValue;

	@FindBy(id = "isc_3K")
	WebElement sortOption;

	@FindBy(id = "isc_2B")
	WebElement sliderBar;

	@FindBy(xpath = "//div[not(contains(@style, 'left: 0px; top: 0px;')) and (contains(@class, 'simpleTile'))]")
	 List<WebElement> animalList;

	public void clickOnCookies(){
		iAgree.click();
	}

	public void moveslider() {
		Actions move = new Actions(driver);
		move.dragAndDropBy(sliderBar, 81, 0).perform();
	}

	public void enterAnimal(String val) {
		animalfield.sendKeys(val);
	}

	public void clickOnSort() {
		dropdownSort.click();
	}

	public void selectSortOption() {
		sortValue.click();
	}

	public void verifyAnimalList() {
		if (animalList.size() > 12) {
			System.out.println("Animals has more than 12");
		}
	}

	public void selectListAscending() {
		sortOption.click();
	}

}