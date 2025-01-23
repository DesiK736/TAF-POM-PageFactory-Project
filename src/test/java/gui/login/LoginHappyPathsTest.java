package gui.login;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.BasePage;
import com.dkk.pom.HomePage;
import com.dkk.pom.LoginPage;
import gui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginHappyPathsTest extends BaseTest {

    private static final String searchBarInput = "perfect";

    @Test
    public void verifyRegisteredUserLoginWithValidUsernameAndPassword() throws InterruptedException {

        HomePage homePage = new HomePage(super.driver, log);

        log.info("STEP 1. Not logged in user has opened 'Skillo' home page.");
        homePage.openHomePage();

        log.info("STEP 2.Verify, that the 'Iskillo' logo is shown.");
        BasePage basePage = new BasePage(super.driver, log);
        String logoIskillo = basePage.getNavigationBarIskilloLogo();
        System.out.println("========>  " + "Web site logo presented: " + logoIskillo + "  <========");

        log.info("STEP 3. Verify, that the login link is presented and click on the navigation bar login link.");
        Assert.assertTrue(basePage.isNavigationBarLoginLinkLoadedAfterVisibilityAndFunctionalCheck());

        log.info("STEP 4. The user is successfully on the login page and check the login form header.");
        LoginPage loginPage = new LoginPage(super.driver, log);
        String loginFormHeader = basePage.getLoginFormHeader();
        Assert.assertEquals(loginFormHeader,basePage.getLoginFormHeader());

        log.info("STEP 5. Verify login form web elements and get the text from 'Remember me' checkbox.");
        loginPage.getTextFromRememberMeCheckboxLabel();

        log.info("STEP 5.1. Verify login form web elements and get the text from 'Sign in' button.");
        loginPage.getTextFromLoginFormSignInButtonLabel();

        log.info("STEP 5.2. Verify login form web elements and get the text from 'Not a member?'.");
        loginPage.getTextFromLoginFormNotAMemberLabel();

        log.info("STEP 5.3. Verify login form web elements and get the text from 'Register' link.");
        loginPage.getTextFromLoginFormRegisterLink();

        log.info("STEP 6. Provide login credentials for username and password input fields, click on 'Remember me' and 'Sign in' buttons.");
        loginPage.provideLogInCredentialsWithUsernameInput(basePage.getRegisteredUsernameIvan(), basePage.getRegisteredPasswordIvan());

        log.info("STEP 7. Verify successful flow.");
        loginPage.getAlertMsgFromSuccessLogin();

        log.info("STEP 7.1. Verify redirection to the home link after login.");
        Assert.assertTrue(loginPage.isNavBarHomeLinkAfterLoginPresented());

        log.info("STEP 7.2. Click on home link after login.");
        loginPage.clickOnNavBarHomeLinkAfterLogin();

        log.info("STEP 7.3. Verify redirection to the profile link after login with proper visibility and functional check.");
        Assert.assertTrue(basePage.isNavigationBarProfileLinkAccessibleAfterVisibilityAndFunctionalCheck());

        log.info("STEP 7.4. Verify redirection to the new post link after login with proper visibility and functional check.");
        Assert.assertTrue(basePage.isNavigationBarNewPostLinkLoadedAfterVisibilityAndFunctionalCheck());

        log.info("STEP 7.5. Verify redirection to the 'Search' bar input field after login.");
        Assert.assertTrue(loginPage.isLoginNavBarSearchBarInputFieldShown());

        log.info("STEP 7.6. Provide input for 'Search' bar field and retrieve the text.");
        String typedText =  loginPage.provideTextForNavBarSearchFieldAndRetrieveTheTxt(searchBarInput);
        System.out.println("========>  " + "Typed text in the search bar: " + typedText + "  <========");

        log.info("STEP 8. Verify, that the 'log out' button is presented.");
        Assert.assertTrue(loginPage.isNavBarLogOutButtonPresented());

        log.info("STEP 8.1. Click on 'log out' button.");
        loginPage.clickOnNavBarLogOutButton();
    }

    @Test
    public void verifyRegisteredUserLoginWithValidEmailAndPassword() throws InterruptedException {

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1. The user is successfully landed on the login page.");
        loginPage.navigateToLoginPage();
        BasePage basePage = new BasePage(super.driver, log);
        String loginFormHeader = basePage.getLoginFormHeader();
        Assert.assertEquals(loginFormHeader,basePage.getLoginFormHeader());

        log.info("STEP 2. Provide login credentials for email and password input fields, click on 'Remember me' and 'Sign in' buttons.");
        loginPage.provideLogInCredentialsWithEmailInput(basePage.getRegisteredEmailIvan(), basePage.getRegisteredPasswordIvan());

        log.info("STEP 3. Verify successful flow.");
        loginPage.getAlertMsgFromSuccessLogin();

        log.info("STEP 4. Verify redirection to the home link after login.");
        Assert.assertTrue(loginPage.isNavBarHomeLinkAfterLoginPresented());
    }
}

