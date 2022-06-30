package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Grid {
    WebDriver driver;

    public Grid( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='popupPPC']/a[2]")
    WebElement iAgree;

    @FindBy(xpath = "//td[@class='etreeCellSelected']//td[text()='Nested Grid']")
    WebElement grid;

    @FindBy(xpath = "//tbody/tr[40]/td[1]/div[1]/span[1]")
    WebElement correction;

    @FindBy(xpath = "//body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[8]/table[1]/tbody[1]/tr[1]/td[1]")
    WebElement unitDescending;

    @FindBy(xpath = "(//div[@class = 'vScrollThumb'])[2]")
    WebElement scrList;


    public void clickOnCookies(){
        iAgree.click();
    }

    public void clickGrid(){
        grid.click();
    }

    public void scrollList(){

        Actions move = new Actions(driver);
        move.dragAndDropBy(scrList, 0,50).perform();
    }

    public void clickCorrection(){
        correction.click();
    }

    public void clickUnitDescending(){
        unitDescending.click();
    }




}
