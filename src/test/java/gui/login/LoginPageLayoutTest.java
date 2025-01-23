package gui.login;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.BasePage;
import com.dkk.pom.HomePage;
import com.dkk.pom.LoginPage;
import gui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageLayoutTest extends BaseTest {

    private static final String searchBarInput = "perfect";

    @Test
    public void verifyLoginPageLayoutWebElements() throws InterruptedException {

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1. Verify, that the login page is opened and the 'Iskillo' logo is presented.");
        loginPage.navigateToLoginPage();
        BasePage basePage = new BasePage(super.driver, log);
        String logoIskillo = basePage.getNavigationBarIskilloLogo();
        System.out.println("========>  " + "Web site logo presented: " + logoIskillo + "  <========");

        log.info("STEP 2.1 Check, whether navigation bar home link is presented.");
        Assert.assertTrue(basePage.isNavigationBarHomeLinkVisible());

        log.info("STEP 2.2. Check, if the navigation bar login link is shown.");
        Assert.assertTrue(basePage.isNavigationBarLoginLinkLoadedAfterVisibilityAndFunctionalCheck());

        log.info("STEP 3.1. Review, if the login form header is accurately shown.");
        String loginFormHeader = basePage.getLoginFormHeader();
        Assert.assertEquals(loginFormHeader,basePage.getLoginFormHeader());

        log.info("STEP 3.2. Get the value from login form 'Username or email' placeholder.");
        loginPage.getValueFromLoginFormUsernameOrEmailPlaceholder();

        log.info("STEP 3.3. Get the value from login form 'Password' placeholder.");
        loginPage.getValueFromLoginFormPasswordPlaceholder();

        log.info("STEP 3.4. Verify login form 'Remember me' checkbox and retrieve the text.");
        loginPage.getTextFromRememberMeCheckboxLabel();

        log.info("STEP 3.5. Verify login form 'Sign in' button and retrieve the text.");
        loginPage.getTextFromLoginFormSignInButtonLabel();

        log.info("STEP 3.6. Verify login form element - 'Not a member?' and retrieve the text.");
        loginPage.getTextFromLoginFormNotAMemberLabel();

        log.info("STEP 3.7. Check login form 'Register' link and retrieve the text.");
        loginPage.getTextFromLoginFormRegisterLink();

        log.info("STEP 3.8. Retrieve the provided text for search bar input field, after successful login.");
        loginPage.provideLogInCredentialsWithUsernameInput(loginPage.getRegisteredUsernameIvan(), loginPage.getRegisteredPasswordIvan());
        String typedText = loginPage.provideTextForNavBarSearchFieldAndRetrieveTheTxt(searchBarInput);
        System.out.println("========>  " + "Typed text in the search bar: " + typedText + "  <========");

        log.info("STEP 4. Verify visibility for the first three new profile connections on the personal user home page.");
        HomePage homePage = new HomePage(super.driver, log);
        Assert.assertTrue(homePage.isFirstSuggestForNewUsersConnectionPresented());
        Assert.assertTrue(homePage.isSecondSuggestForNewUsersConnectionPresented());
        Assert.assertTrue(homePage.isThirdSuggestForNewUsersConnectionPresented());

        log.info("STEP 5. Proceed with retrieving their names, after the previous condition is met.");
        homePage.getTextFromFirstConnectionSuggest();
        homePage.getTextFromSecondConnectionSuggest();
        homePage.getTextFromThirdConnectionSuggest();

        log.info("STEP 6. Since visibility check completed proper, continue with functional test on each of the mentioned users and retrieve the flow.");
        homePage.navigateToTheFirstConnectionSuggest();
        loginPage.clickOnNavBarHomeLinkAfterLogin();
        homePage.navigateToTheSecondConnectionSuggest();
        loginPage.clickOnNavBarHomeLinkAfterLogin();
        homePage.navigateToTheThirdConnectionSuggest();
    }
}
