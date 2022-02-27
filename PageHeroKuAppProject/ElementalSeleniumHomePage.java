package PageHeroKuAppProject;

import BaseHeroKuAppProject.BaseHeroKuAppProject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class ElementalSeleniumHomePage extends BaseHeroKuAppProject {
    public ElementalSeleniumHomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[rel=\"noopener noreferrer\"]")
    WebElement clickOnLinkSauceLabs;

    public void moveToNewTab(){
        wdWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public ElementalSeleniumHomePage clickOnSauceLabsLink(){
        moveToNewTab();
        wdWait.until(ExpectedConditions.elementToBeClickable(clickOnLinkSauceLabs));
        clickOnLinkSauceLabs.click();
        return this;
    }

}
