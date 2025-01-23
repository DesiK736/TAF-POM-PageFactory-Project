package gui.registration;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.BasePage;
import com.dkk.pom.RegistrationPage;
import gui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.reg.data.RegistrationDataGenerator;

public class RegistrationHappyPathsTest extends BaseTest {

    private static final String username = RegistrationDataGenerator.generateUniqueUsername();
    private static final String email = RegistrationDataGenerator.generateUniqueEmail();

    @Test
    public void verifyUserRegistrationWithValidCredentialsManualProvided() throws InterruptedException {

        RegistrationPage registrationPage = new RegistrationPage(super.driver,log);

        log.info("STEP 1. Check, that the user is on the registration page.");
        registrationPage.navigateToRegistrationPage();
        Assert.assertTrue(registrationPage.isURLLoaded("http://training.skillo-bg.com:4300/users/register"));

        log.info("STEP 2. Verify, that the 'Iskillo' logo is shown successfully on registration page.");
        BasePage basePage = new BasePage(super.driver, log);
        String logoIskillo = basePage.getNavigationBarIskilloLogo();
        System.out.println("========>  " + "Web site logo presented: " + logoIskillo + "  <========");

        log.info("STEP 3. Provide credentials with manual input for registration form fields and click on 'Sign in' button.");
        registrationPage.registerNewUserWithManualInputAndClickOnSignInButton(basePage.getRegisteredUsernameIvan(), basePage.getRegisteredEmailIvan(), "01/06/1980", basePage.getRegisteredPasswordIvan(), "goodPass2", "perfect");

        log.info("STEP 4. Since the registration has already been implemented, verify the log toast message for failed registration - 'Username taken'.");
        registrationPage.regFailedGetLogToastMessage();
    }

    @Test
    public void verifyUserRegistrationWithValidCredentialsAutomaticallyProvidedForUserAndEmailFields() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(super.driver,log);

        log.info("STEP 1. Check, that the user is navigating to the registration page.");
        registrationPage.navigateToRegistrationPage();
        Assert.assertTrue(registrationPage.isURLLoaded("http://training.skillo-bg.com:4300/users/register"));

        log.info("STEP 2. Verify, that the 'Iskillo' logo is shown on registration page.");
        BasePage basePage = new BasePage(super.driver, log);
        String logoIskillo = basePage.getNavigationBarIskilloLogo();
        System.out.println("========>  " + "Web site logo presented: " + logoIskillo + "  <========");

        log.info("STEP 3. Provide credentials for registration form fields and click on 'Sign in' button.");
        registrationPage.registerNewUserWithDataGeneratorForUserAndEmailFields(username, email, "02/01/1985",  "cool12458M", "cool12458M", "software engineer");

        log.info("STEP 4. Verify successful registration flow.");
        registrationPage.getAlertMsgFromSuccessRegistration();
    }
}
