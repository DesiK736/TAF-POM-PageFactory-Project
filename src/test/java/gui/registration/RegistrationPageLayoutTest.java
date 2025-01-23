package gui.registration;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.BasePage;
import com.dkk.pom.RegistrationPage;
import gui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationPageLayoutTest extends BaseTest {

    @Test
    public void verifyRegistrationPageLayoutWebElements() throws InterruptedException {

        RegistrationPage registrationPage = new RegistrationPage(super.driver, log);

        log.info("STEP 1. Check, that the registration page is opened and the 'Iskillo' logo is shown.");
        registrationPage.navigateToRegistrationPage();
        BasePage basePage = new BasePage(super.driver, log);
        String logoIskillo = basePage.getNavigationBarIskilloLogo();
        System.out.println("========>  " + "Web site logo presented: " + logoIskillo + "  <========");

        log.info("STEP 2. Check, whether navigation bar home link is presented.");
        Assert.assertTrue(basePage.isNavigationBarHomeLinkVisible());

        log.info("STEP 3. Check, if the navigation bar login link is shown.");
        Assert.assertTrue(registrationPage.isURLLoaded("http://training.skillo-bg.com:4300/users/register"));

        log.info("STEP 3.1. Review and get the text from the registration form header.");
        registrationPage.getTextFromRegFormSignUpHeader();

        log.info("STEP 3.2. Get the value from registration form username placeholder.");
        registrationPage.getValueFromRegFormUsernamePlaceholder();

        log.info("STEP 3.3. Get the value from registration form email placeholder.");
        registrationPage.getValueFromRegFormEmailPlaceholder();

        log.info("STEP 3.4. Get the value from registration form calendar placeholder.");
        registrationPage.getValueFromRegFormCalendarPlaceholder();

        log.info("STEP 3.5. Get the value from registration form password placeholder.");
        registrationPage.getValueFromRegFormPasswordPlaceholder();

        log.info("STEP 3.6. Get the value from registration form confirm password placeholder.");
        registrationPage.getValueFromRegFormConfirmPasswordPlaceholder();

        log.info("STEP 3.7. Get the value from registration form public info placeholder.");
        registrationPage.getValueFromRegFormPublicInfoPlaceholder();

        log.info("STEP 3.8. Verify 'Sign in' button visibility and get the text.");
        Assert.assertTrue(registrationPage.isRegSignInButtonShown());
        registrationPage.getTextFromRegFormSignInButton();

        log.info("STEP 4. Inspect web elements from the footer and get the text from version.");
        registrationPage.getTextFromVersionFooter();

        log.info("STEP 5. Inspect web elements from the footer and get the text from technologies.");
        registrationPage.getTextFromTechnologiesFooter();
    }
}
