package gui.login;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.BasePage;
import com.dkk.pom.LoginPage;
import com.dkk.pom.ProfilePage;
import gui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginErrorsTest extends BaseTest {

    private static final String FAILED_LOGIN_MSG = "Wrong username or password!";
    private static final String SUCCESSFUL_LOGIN_MSG = "Successful login!";
    private static final String correctUsername = "ivanIvanov";
    private static final String correctPassword = "goodPass2";
    private static final String similarCreatedUsername = "Ivanivanov";
    private static final String samePassword = "goodPass2";
    private static final int maxAttempts = 4;

    @Test
    public void verifyUserUnableToLockTheAccountWithInfiniteWrongPassTry() throws InterruptedException {

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1. Verify, that the user is successfully on the login page.");
        loginPage.navigateToLoginPage();
        BasePage basePage = new BasePage(super.driver, log);
        String loginFormHeader = basePage.getLoginFormHeader();
        Assert.assertEquals(loginFormHeader,basePage.getLoginFormHeader());

        log.info("STEP 2. Check and approve the infinite login authentication tries, until the the right credentials are provided.");
        loginPage.isLoginAuthenticationValid(correctUsername, correctPassword, maxAttempts);

        log.info("STEP 3. Since the user has an unlimited number of attempts, test is created with max 4 attempts. Verify unsuccessful login flow.");
        loginPage.logInFailedGetLogToastMessage();

        log.info("STEP 4. Display the difference between actual and expected behaviour. To be more precise, manual test with more than 100 attempts was executed and the main topic was proven.");
        Assert.assertEquals(FAILED_LOGIN_MSG, SUCCESSFUL_LOGIN_MSG );
    }

    @Test
    public void verifyUserCanAccessPrivateProfileAccountWithSimilarUserAndSamePassInputs() throws InterruptedException {

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1. The user is navigating to the login page.");
        loginPage.navigateToLoginPage();

        log.info("STEP 2. Provide similar username inputs, equal pass and display the entered credentials.");
        String providedUserInput = loginPage.provideInputForUsernameFieldAndRetrieveTheTxt(similarCreatedUsername);
        System.out.println("========>  " + "Provided username input: " + providedUserInput + "  <========");
        String providedPassInput = loginPage.provideInputForPasswordFieldAndRetrieveTheTxt(samePassword);
        System.out.println("========>  " + "Provided password input: " + providedPassInput + "   <========");

        log.info("STEP 3. Inspect the unexpected behaviour and verify successful flow result.");
        loginPage.getAlertMsgFromSuccessLogin();

        log.info("STEP 4. Verify redirection to the home link after login.");
        Assert.assertTrue(loginPage.isNavBarHomeLinkAfterLoginPresented());

        log.info("STEP 5. Review the user profile after proper click on the navigation bar profile link.");
        BasePage basePage =new BasePage(super.driver, log);
        Assert.assertTrue(basePage.isNavigationBarProfileLinkAccessibleAfterVisibilityAndFunctionalCheck());

        log.info("STEP 6. Check the profile link and whether it is proper presented.");
        ProfilePage profilePage = new ProfilePage(super.driver, log);
        profilePage.navigateToProfilePageUserIvan();
        Assert.assertTrue(profilePage.isURLLoaded("http://training.skillo-bg.com:4300/users/8871"));

        log.info("STEP 7. Verify, that the accessed profile is to another user and retrieve the mentioned profile user.");
        profilePage.getTextFromProfileSectionUsername();

        log.info("STEP 8. Display the username inputs, which should be two different account profiles and verify the behaviour deviation.");
        Assert.assertEquals(basePage.getRegisteredUsernameIvan(), similarCreatedUsername);
    }
}
