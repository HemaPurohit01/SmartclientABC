package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDownTable {
	WebDriver driver;

	public DropDownTable( WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='popupPPC']/a[2]")
	WebElement iAgree;

	@FindBy(xpath = "//div[contains(@class, 'selectItemLiteText') and contains(@role, 'presentation')]/ancestor::tr[1]/td[2]")
	WebElement dropDownList;

	@FindBy(xpath = "//tr/td/div[contains(text(), 'Exercise')]//ancestor::tr/td[2]/div[contains(text(), 'Ea')]//ancestor::tr/td[3][number(.) > 1.1]//ancestor::tr")
	List<WebElement> drpExerciseItems;

	@FindBy(xpath = "(//table[@class='listTable'])[2]/tbody/tr")
	List<WebElement> drpListItems;

	@FindBy(xpath = "(//div[@class = 'vScrollThumb'])[2]")
	WebElement scroll;

	public void clickOnCookies(){
		iAgree.click();
	}

	public void clickOnListItems() {
		dropDownList.click();
	}


	public void verifyDropDownListItems() {
		if(drpExerciseItems.size() > 0) {
			System.out.println("Dropdown table list" + drpExerciseItems.size());
			for(int i = 0; i < drpExerciseItems.size(); i++) {
				System.out.println(drpExerciseItems.get(i).getText());
			}
		}
	}

	public void scrollDownList(){
		Actions move = new Actions(driver);
		move.dragAndDropBy(scroll, 0,25).perform();
	}


}
