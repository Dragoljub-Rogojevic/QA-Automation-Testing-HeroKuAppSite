
package PageHeroKuAppProject;

import BaseHeroKuAppProject.BaseHeroKuAppProject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SauceLabsHomePage extends BaseHeroKuAppProject {
    public SauceLabsHomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[id=\"onetrust-accept-btn-handler\"]")
    WebElement clickOnOk;

    public void moveToNewTab(){
        wdWait.until(ExpectedConditions.numberOfWindowsToBe(3));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
    }

    public SauceLabsHomePage clickOnOkCookies(){
        moveToNewTab();
        wdWait.until(ExpectedConditions.elementToBeClickable(clickOnOk));
        clickOnOk.click();
        return this;
    }

}
