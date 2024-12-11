package gui.login;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.HomePage;
import com.dkk.pom.LoginPage;
import com.dkk.pom.RegistrationPage;
import gui.base.BaseTest;
import org.testng.annotations.Test;

public class LoginHappyPathsTest extends BaseTest {

    @Test
    public void check() throws InterruptedException {

        HomePage homePage = new HomePage(super.driver, log);
        log.info("STEP 1: Not logged in user has opened the Skillo HomePage.");
        homePage.openHomePage();
        homePage.navigateToLoginPageViaClickOnNavigationLoginButton();

        //1. Login with registered user - valid credentials
        LoginPage loginPage = new LoginPage(super.driver, log);

        loginPage.openLoginPage();
        loginPage.navigateToLoginPageViaClickOnNavigationLoginLink();
        loginPage.provideCredentials("ivanIvanov", "goodPass2");
        loginPage.clickOnRememberMeCheckbox();
        loginPage.clickOnLoginFormSignInButton();

        Thread.sleep(4444);

        RegistrationPage registrationPage = new RegistrationPage(super.driver, log);

        registrationPage.openRegistrationPage();
        registrationPage.navigateToRegistrationPageViaClickOnRegisterLink();
        registrationPage.provideRegistrationCredentials("jamesClark15250", "guru.it@gmail.com", "cool1245jlK", "cool1245jlK", "software engineer");
        registrationPage.clickOnCalendarPopUpIcon();
        registrationPage.clickOnSignInButton();

    }

    //2. Login with newly created/registered user - valid credentials
}
