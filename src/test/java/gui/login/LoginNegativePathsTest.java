package gui.login;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.BasePage;
import com.dkk.pom.LoginPage;
import gui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginNegativePathsTest extends BaseTest {

    private static final String FAILED_LOGIN_MSG = "Wrong username or password!";
    private static final String SUCCESSFUL_LOGIN_MSG = "Successful login!";
    private static final String wrongUsername = "ivan_ivanov";
    private static final String wrongPassword = "goodPass";

    @Test
    public void verifyRegisteredUserUnableToLoginWithInvalidPassword() throws InterruptedException {

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1. Verify, that the user is successfully on the login page.");
        loginPage.navigateToLoginPage();
        BasePage basePage = new BasePage(super.driver, log);
        String loginFormHeader = basePage.getLoginFormHeader();
        Assert.assertEquals(loginFormHeader,basePage.getLoginFormHeader());

        log.info("STEP 2.1. Verify login form web elements and get the text from 'Remember me' checkbox.");
        loginPage.getTextFromRememberMeCheckboxLabel();

        log.info("STEP 2.2. Verify login form web elements and get the text from 'Sign in' button.");
        loginPage.getTextFromLoginFormSignInButtonLabel();

        log.info("STEP 2.3. Verify login form web elements and get the text from 'Not a member?'.");
        loginPage.getTextFromLoginFormNotAMemberLabel();

        log.info("STEP 2.4. Verify login form web elements and get the text from 'Register' link.");
        loginPage.getTextFromLoginFormRegisterLink();

        log.info("STEP 3. User attempts to login with wrong 'password' input.");
        String providedUserInput = loginPage.provideInputForUsernameFieldAndRetrieveTheTxt(basePage.getRegisteredUsernameIvan());
        System.out.println("========>  " + "Provided username input: " + providedUserInput + "  <========");
        String providedPassInput = loginPage.provideInputForPasswordFieldAndRetrieveTheTxt(wrongPassword);
        System.out.println("========>  " + "Provided password input: " + providedPassInput + "   <========");

        log.info("STEP 4. Verify unsuccessful flow result.");
        loginPage.logInFailedGetLogToastMessage();

        log.info("STEP 5. Display the difference between actual and expected behaviour.");
        Assert.assertEquals(FAILED_LOGIN_MSG, SUCCESSFUL_LOGIN_MSG);
    }

    @Test
    public void verifyRegisteredUserUnableToLoginWithInvalidUsername() throws InterruptedException {

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1. Verify, that the user is landing on the login page.");
        loginPage.navigateToLoginPage();
        BasePage basePage = new BasePage(super.driver, log);
        String loginFormHeader = basePage.getLoginFormHeader();
        Assert.assertEquals(loginFormHeader,basePage.getLoginFormHeader());

        log.info("STEP 2. User try to login with wrong 'username' input.");
        String providedUserInput = loginPage.provideInputForUsernameFieldAndRetrieveTheTxt(wrongUsername);
        System.out.println("========>  " + "Provided username input: " + providedUserInput + "  <========");
        String providedPassInput = loginPage.provideInputForPasswordFieldAndRetrieveTheTxt(basePage.getRegisteredPasswordIvan());
        System.out.println("========>  " + "Provided password input: " + providedPassInput + "   <========");

        log.info("STEP 3. Verify unsuccessful flow.");
        loginPage.logInFailedGetLogToastMessage();

        log.info("STEP 4. Display the difference between actual and expected behaviour.");
        Assert.assertEquals(FAILED_LOGIN_MSG, SUCCESSFUL_LOGIN_MSG);
    }
}

