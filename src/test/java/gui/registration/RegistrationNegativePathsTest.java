package gui.registration;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.RegistrationPage;
import gui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationNegativePathsTest extends BaseTest {

    private static final String REGISTRATION_SUCCESSFUL_MSG= "Successful register!";
    private static final String REGISTRATION_FAILED_MSG = "Registration failed!";

    @Test
    public void verifyUserRegistrationFailedInCaseThePasswordsDoNotMatch() throws InterruptedException {

        RegistrationPage registrationPage = new RegistrationPage(super.driver, log);

        log.info("STEP 1. The user is on the registration page.");
        registrationPage.navigateToRegistrationPage();

        log.info("STEP 2. The credentials for registration are provided.");
        registrationPage.registerNewUserWithManualInput("Yasen Petkov", "y.petkov@abv.bg", "06/05/1982", "yasenP65", "yasenP64", "scientist");

        log.info("STEP 3. Verify registration failure ang retrieve the text from the invalid feedback message.");
        registrationPage.getTextFromTheRegisterFormUserInvalidFeedback();

        log.info("STEP 4. Verify the difference between actual and expected behaviour.");
        Assert.assertEquals(REGISTRATION_FAILED_MSG, REGISTRATION_SUCCESSFUL_MSG);
    }

    @Test
    public void verifyUserRegistrationFailedForEmailThatHaveAlreadyBeenTaken() throws InterruptedException {

        RegistrationPage registrationPage = new RegistrationPage(super.driver, log);

        log.info("STEP 1. The user is landed on the registration page.");
        registrationPage.navigateToRegistrationPage();

        log.info("STEP 2. The credentials for registration are provided manually.");
        registrationPage.registerNewUserWithManualInputAndClickOnSignInButton("allen Iverson", "kalata11@gmail.com", "10/09/1985", "superHacker25", "superHacker25", "manager");

        log.info("STEP 3. Verify unsuccessful registration.");
        registrationPage.regFailedGetLogToastMessage();

        log.info("STEP 4. Show the difference between actual and expected behaviour.");
        Assert.assertEquals(REGISTRATION_FAILED_MSG, REGISTRATION_SUCCESSFUL_MSG);
    }
}
