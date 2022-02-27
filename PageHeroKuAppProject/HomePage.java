package PageHeroKuAppProject;

import BaseHeroKuAppProject.BaseHeroKuAppProject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseHeroKuAppProject {
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[id=\"username\"]")
    WebElement userName;

    @FindBy(css ="[id=\"password\"]")
    WebElement password;

    @FindBy(css = "[class=\"radius\"]")
    WebElement logInButton;

    @FindBy(css = "[class=\"button secondary radius\"]")
    WebElement logOutButton;

    @FindBy(css = "[id=\"flash-messages\"]")
    WebElement checkSuccessMessage;

    @FindBy(css = "[class=\"flash error\"]")
    WebElement checkErrorMessage;

    @FindBy(css = "[class=\"flash success\"]")
    WebElement logOutMessage;

    @FindBy(css = "[class=\"close\"]")
    WebElement xErrorMessage;

    //@FindBy(css = "a[class=\"close\"]")
    //WebElement xSuccessLogInMessage;

    @FindBy(css = "div > a[class=\"close\"]")
    WebElement xSuccessLogOutMessage;

    @FindBy(css = "a img[alt=\"Fork me on GitHub\"]")
    WebElement gitHubbuttonFromLogInPage;

    @FindBy(css = "[alt=\"Fork me on GitHub\"]")
    WebElement gitHubbuttonFromLogOutPage;

    @FindBy(xpath = "//div//a[contains(text(),'Elemental Selenium')]")
    WebElement elementalSeleniumLink;

    @FindBy(css = "[class=\"subheader\"]")
    WebElement textOnLogIn;

    @FindBy(css = "[class=\"subheader\"]")
    WebElement textOnLogOut;

    //LogIn Bez Kredencijala
    public HomePage clickOnLogInWithoutChar(){
        wdWait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();
        return this;
    }

    public boolean checkErrorMessageAfterClickLogInButtonAndClose(){
        wdWait.until(ExpectedConditions.elementToBeClickable(checkErrorMessage));
        wdWait.until(ExpectedConditions.elementToBeClickable(xErrorMessage));
        xErrorMessage.click();
        return checkErrorMessage.isDisplayed();
    }

    //LogIn Samo UserName
    public HomePage enterCorrectOnlyUserName(String correctUserName){
        wdWait.until(ExpectedConditions.elementToBeClickable(userName));
        userName.clear();
        userName.sendKeys(correctUserName);
        wdWait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();
        return this;
    }

    public boolean checkMessageAfterEnterOnlyUserNameAndCloseMessage(){
        wdWait.until(ExpectedConditions.elementToBeClickable(checkSuccessMessage));
        wdWait.until(ExpectedConditions.elementToBeClickable(xErrorMessage));
        xErrorMessage.click();
        return checkSuccessMessage.isDisplayed();
    }

    //LogIn Samo Password
    public HomePage enterCorrectOnlyPassword(String correctPass){
        wdWait.until(ExpectedConditions.elementToBeClickable(password));
        password.clear();
        password.sendKeys(correctPass);
        wdWait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();
        return this;
    }

    public boolean checkErrorMessageAfterEnterOnlyPasswordAndCloseMessage(){
        wdWait.until(ExpectedConditions.elementToBeClickable(checkErrorMessage));
        wdWait.until(ExpectedConditions.elementToBeClickable(xErrorMessage));
        xErrorMessage.click();
        return checkErrorMessage.isDisplayed();
    }

    //LogIn pogresan username ispravan password
    public HomePage enterWrongUserNameCorrectPassword(String wrongUserN, String correctPass){
        wdWait.until(ExpectedConditions.elementToBeClickable(userName));
        userName.clear();
        userName.sendKeys(wrongUserN);
        wdWait.until(ExpectedConditions.elementToBeClickable(password));
        password.clear();
        password.sendKeys(correctPass);
        wdWait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();
        return this;
    }

    public boolean checkErrorMessageAfterEnterWrongUserNameAndCloseMessage(){
        wdWait.until(ExpectedConditions.elementToBeClickable(checkErrorMessage));
        wdWait.until(ExpectedConditions.elementToBeClickable(xErrorMessage));
        xErrorMessage.click();
        return checkErrorMessage.isDisplayed();
    }

    //LogIn ispravan username pogresan password
    public HomePage enterCorrectUserNameWrongPassword(String correctUserN, String wrongPass){
        wdWait.until(ExpectedConditions.elementToBeClickable(userName));
        userName.clear();
        userName.sendKeys(correctUserN);
        wdWait.until(ExpectedConditions.elementToBeClickable(password));
        password.clear();
        password.sendKeys(wrongPass);
        wdWait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();
        return this;
    }

    public boolean checkErrorMessageAfterEnterWrongPassworAndCloseMessage(){
        wdWait.until(ExpectedConditions.elementToBeClickable(checkErrorMessage));
        wdWait.until(ExpectedConditions.elementToBeClickable(xErrorMessage));
        xErrorMessage.click();
        return checkErrorMessage.isDisplayed();
    }

    //Login sve pogresno
    public HomePage enterWrongUserNameWrongPassword(String wrongUserN, String wrongPass){
        wdWait.until(ExpectedConditions.elementToBeClickable(userName));
        userName.clear();
        userName.sendKeys(wrongUserN);
        wdWait.until(ExpectedConditions.elementToBeClickable(password));
        password.clear();
        password.sendKeys(wrongPass);
        wdWait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();
        return this;
    }

    public boolean checkMessageAfterEnterWrongCharAndCloseMessage(){
        wdWait.until(ExpectedConditions.elementToBeClickable(checkErrorMessage));
        wdWait.until(ExpectedConditions.elementToBeClickable(xErrorMessage));
        xErrorMessage.click();
        return checkErrorMessage.isDisplayed();
    }

    //LogIn sa ispravnim kredencijalima
    public HomePage enterCorrectChar(String correctUserN, String correctPass){
        wdWait.until(ExpectedConditions.elementToBeClickable(userName));
        userName.clear();
        userName.sendKeys(correctUserN);
        wdWait.until(ExpectedConditions.elementToBeClickable(password));
        password.clear();
        password.sendKeys(correctPass);
        wdWait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();
        return this;
    }

    public boolean checkSuccessLogInMessage(){
        wdWait.until(ExpectedConditions.elementToBeClickable(checkSuccessMessage));
        wdWait.until(ExpectedConditions.elementToBeClickable(xErrorMessage));
        xErrorMessage.click();
        return checkSuccessMessage.isDisplayed();
    }

    public HomePage inspectLogOutButton(){
        wdWait.until(ExpectedConditions.elementToBeClickable(logOutButton));
        logOutButton.click();
        return this;
    }

    public boolean checkSuccessLogOutMessage(){
        wdWait.until(ExpectedConditions.elementToBeClickable(logOutMessage));
        wdWait.until(ExpectedConditions.elementToBeClickable(xErrorMessage));
        xErrorMessage.click();
        return logOutMessage.isDisplayed();
    }

    //fork me on GitHub sa LogIn strane
    public HomePage clickOnGitHubFromLogInPage(){
        wdWait.until(ExpectedConditions.elementToBeClickable(gitHubbuttonFromLogInPage));
        gitHubbuttonFromLogInPage.click();
        return this;
    }

    //fork me on GitHub sa logout strane
    public HomePage clickOnGitHubFromLogOutPage(String correctUserN, String correctPass){
        wdWait.until(ExpectedConditions.elementToBeClickable(userName));
        userName.clear();
        userName.sendKeys(correctUserN);
        wdWait.until(ExpectedConditions.elementToBeClickable(password));
        password.clear();
        password.sendKeys(correctPass);
        wdWait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();
        wdWait.until(ExpectedConditions.elementToBeClickable(gitHubbuttonFromLogOutPage));
        gitHubbuttonFromLogOutPage.click();
        return this;
    }

    public HomePage clickOnLogOutAfterBackFromGitHubPage(){
        wdWait.until(ExpectedConditions.elementToBeClickable(logOutButton));
        logOutButton.click();
        return this;
    }

    public HomePage clickOnXSuccessLogOutMessage(){
        wdWait.until(ExpectedConditions.elementToBeClickable(xSuccessLogOutMessage));
        xSuccessLogOutMessage.click();
        return this;
    }

    //Klik na Elementa Selenium Link sa logIn strane
    public HomePage clickOnElementalSelenimOnLogInPage(){
        wdWait.until(ExpectedConditions.elementToBeClickable(elementalSeleniumLink));
        elementalSeleniumLink.click();
        return this;
    }

    //Provera teksta na login strani
    public WebElement checkTextOnLogInPage(){
        return textOnLogIn;
    }

    //provera teksta nakon LogIn-a
    public HomePage insertAllCorrectChar(String userNameAgain, String passAgain){
        wdWait.until(ExpectedConditions.elementToBeClickable(userName));
        userName.sendKeys(userNameAgain);
        wdWait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys(passAgain);
        wdWait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();
        return this;
    }
    public WebElement checkTextOnLogOut(){
        return textOnLogOut;
    }

    //provera boje logIn banera
    public HomePage checkCollorLogIn(){
        checkSuccessMessage.getCssValue("background-color: #5da423;");
        return this;
    }
}
