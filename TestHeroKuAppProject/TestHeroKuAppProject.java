package TestHeroKuAppProject;

import BaseHeroKuAppProject.BaseHeroKuAppProject;
import PageHeroKuAppProject.ElementalSeleniumHomePage;
import PageHeroKuAppProject.HomePage;
import PageHeroKuAppProject.SauceLabsHomePage;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestHeroKuAppProject extends BaseHeroKuAppProject {
    private HomePage homePage;
    private ElementalSeleniumHomePage elementalSeleniumHomePage;
    private SauceLabsHomePage sauceLabsHomePage;

    @Before
    public void define() {
        homePage = new HomePage();
        elementalSeleniumHomePage = new ElementalSeleniumHomePage();
        sauceLabsHomePage = new SauceLabsHomePage();
    }

    String url = "https://the-internet.herokuapp.com/login";
    String userName = "tomsmith";
    String wrongUserName = RandomStringUtils.randomAlphanumeric(7);
    String password = "SuperSecretPassword!";
    String wrongPassword = RandomStringUtils.randomAlphanumeric(8);

    @Test
    public void logInWithoutCharacter() {
        //bez kredencijala
        homePage.clickOnLogInWithoutChar();
        Assert.assertTrue(homePage.checkErrorMessageAfterClickLogInButtonAndClose());
        homePage.checkErrorMessageAfterClickLogInButtonAndClose();
    }

    @Test
    public void logInWithOnlyUserName() {
        //samo username
        homePage.enterCorrectOnlyUserName(userName);
        Assert.assertTrue(homePage.checkMessageAfterEnterOnlyUserNameAndCloseMessage());
        homePage.checkMessageAfterEnterOnlyUserNameAndCloseMessage();
    }

    @Test
    public void logInOnlyPassword() {
        //samo password
        homePage.enterCorrectOnlyPassword(password);
        Assert.assertTrue(homePage.checkErrorMessageAfterEnterOnlyPasswordAndCloseMessage());
        homePage.checkErrorMessageAfterEnterOnlyPasswordAndCloseMessage();
    }

    @Test
    public void logInWrongUserNameCorrectPassword() {
        //pogresan usrename ispravan password
        homePage.enterWrongUserNameCorrectPassword(wrongUserName, password);
        Assert.assertTrue(homePage.checkErrorMessageAfterEnterWrongUserNameAndCloseMessage());
        homePage.checkErrorMessageAfterEnterWrongUserNameAndCloseMessage();
    }

    @Test
    public void loginCorrectUserNameWrongPassword() {
        //ispravan username pogresan password
        homePage.enterCorrectUserNameWrongPassword(userName, wrongPassword);
        Assert.assertTrue(homePage.checkErrorMessageAfterEnterWrongPassworAndCloseMessage());
        homePage.checkErrorMessageAfterEnterWrongPassworAndCloseMessage();
    }

    @Test
    public void logInWrongUserAndPassword() {
        //pogresan username pogresan password
        homePage.enterWrongUserNameWrongPassword(wrongUserName, wrongPassword);
        Assert.assertTrue(homePage.checkMessageAfterEnterWrongCharAndCloseMessage());
        homePage.checkMessageAfterEnterWrongCharAndCloseMessage();
    }

    @Test
    public void logInCorrectCharacters() {
        //sa ispravnim kredencijalima
        homePage.enterCorrectChar(userName, password);
        Assert.assertTrue(homePage.checkSuccessLogInMessage());
        homePage.checkCollorLogIn();
        homePage.inspectLogOutButton();
        Assert.assertTrue(homePage.checkSuccessLogOutMessage());
    }

    @Test
    public void clickOnGitHubFromLogInPage() {
        //fork me on GitHub sa login strane
        homePage.clickOnGitHubFromLogInPage();
        driver.navigate().back();
        homePage.clickOnGitHubFromLogOutPage(userName, password);
        driver.navigate().back();
        homePage
                .clickOnLogOutAfterBackFromGitHubPage()
                .clickOnXSuccessLogOutMessage();
    }

    @Test
    public void clickOnSeleniumLinkFromLogInPage() {
        //klik na elemental selenium link sa login strane
        homePage.clickOnElementalSelenimOnLogInPage();
    }

    @Test
    public void clickOnLinkOnSeleniumHomePage() {
        //klik na link na Elemental Selenium Home Page
        elementalSeleniumHomePage.clickOnSauceLabsLink();
    }

    @Test
    public void clickOnAcceptCookiesOnSauceLabsHomePage() {
        //klink na OK u SauceLabs home page
        sauceLabsHomePage.clickOnOkCookies();
        driver.get(url);
    }

    @Test
    public void checkMessageInBanner() {
        Assert.assertEquals("This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.", homePage.checkTextOnLogInPage().getText());
        homePage.insertAllCorrectChar(userName, password);
        Assert.assertEquals("Welcome to the Secure Area. When you are done click logout below.", homePage.checkTextOnLogOut().getText());
    }

}
