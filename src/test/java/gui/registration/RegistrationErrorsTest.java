package gui.registration;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.BasePage;
import com.dkk.pom.RegistrationPage;
import gui.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class RegistrationErrorsTest extends BaseTest {

   private static final String REGISTRATION_SUCCESSFUL_MSG = "Successful register!";
   private static final String REG_FORM_USERNAME_REQ_MSG = "Minimum 2 characters !";
   private static final String REGISTRATION_FAILED_MSG = "Registration failed!";
   private static final String regFormSignInButtonText = "Sign in";
   private static final String regFormSignUpHeader = "Sign up";
   private static final String emailSyntax = "email";
   private static final String emailRevisedSyntax = "Email";
   private static final String regFormConfirmPassActualIdSyntax = "defaultRegisterPhonePassword";
   private static final String regFormConfirmPassExpectedIdSyntax = "defaultRegisterFormConfirmPassword";
   private WebElement regSignInButton;

   @Test
   public void verifyUserRegistrationDeniedWithValidUsernameInput() throws InterruptedException {

      RegistrationPage registrationPage = new RegistrationPage(super.driver, log);

      log.info("STEP 1. The user is landing on the registration page.");
      registrationPage.navigateToRegistrationPage();

      log.info("STEP 2. Credentials are provided for Registration form fields, although entered valid requirement for username, the user can not register.");
      registrationPage.registerNewUserWithManualInput("ani", "ani@gmail.com", "02/01/1985", "cool12A", "cool12A", "software engineer");

      log.info("STEP 3. Inspect and retrieve the text from the invalid feedback message.");
      registrationPage.getTextFromTheRegisterFormUserInvalidFeedback();

      log.info("STEP 4. Verify unsuccessful flow with the actual and expected behaviour.");
      Assert.assertEquals(REG_FORM_USERNAME_REQ_MSG, REGISTRATION_SUCCESSFUL_MSG);
   }

   @Test
   public void verifyUserRegistrationWithAlreadyRegisteredPasswordFromAnotherUser() throws InterruptedException {

      RegistrationPage registrationPage = new RegistrationPage(super.driver, log);

      log.info("STEP 1. Check, if the user is navigating to the registration page with logo represented proper.");
      registrationPage.navigateToRegistrationPage();
      BasePage basePage = new BasePage(super.driver, log);
      String logoIskillo = basePage.getNavigationBarIskilloLogo();
      System.out.println("========>  " + "Web site logo presented: " + logoIskillo + "  <========");

      log.info("STEP 2. The new user is registered successfully with the same password from another registered user (ivanIvanov), which define security breach!");
      registrationPage.registerNewUserWithManualInputAndClickOnSignInButton("Kaloyan18", "kalata18@gmail.com", "02/01/1986", "goodPass2", "goodPass2", "software engineer");

      log.info("STEP 3. Verify successful flow with abnormal application behaviour. Display the actual and expected result.");
      registrationPage.getAlertMsgFromSuccessRegistration();
      Assert.assertEquals(REGISTRATION_SUCCESSFUL_MSG, REGISTRATION_FAILED_MSG);
   }

   @Test
   public void verifyRegistrationFailedWithCyrillicAndEnglishSymbolsForUserWithoutInvalidFeedback() throws InterruptedException {

      RegistrationPage registrationPage = new RegistrationPage(super.driver, log);

      log.info("STEP 1. The user is navigating to the registration page proper.");
      registrationPage.navigateToRegistrationPage();

      log.info("STEP 2. Provide credentials for registration form fields: the user registration failed with cyrillic and english characters in username field, but no error checkmark was provided.");
      registrationPage.registerNewUserWithManualInputAndClickOnSignInButton("иван Ivan", "iv253.k@abv.bg", "02/01/1996", "Gh2200jk", "Gh2200jk", "student");

      log.info("STEP 3. Get the log toast message after failed registration try.");
      registrationPage.regFailedGetLogToastMessage();

      log.info("STEP 4. Verify, that the user stayed on the same registration page, after unsuccessful registration.");
      Assert.assertTrue(registrationPage.isRegFormSignUpHeaderPresented());

      log.info("STEP 5. Approve the difference between actual and expected behaviour.");
      Assert.assertEquals(REGISTRATION_FAILED_MSG, REGISTRATION_SUCCESSFUL_MSG);
   }

   @Test
   public void verifyUserRegistrationFailedWithoutInvalidFeedbackForNotMetEmailRequirement() throws InterruptedException {

      RegistrationPage registrationPage = new RegistrationPage(super.driver, log);

      log.info("STEP 1. The user is navigating to the registration page.");
      registrationPage.navigateToRegistrationPage();

      log.info("STEP 2. The user filled out the reg form and registration failed, without any constraints provided for maxLength - email must be shorter than or equal to 20 characters. Green checkmark appeared for proper input/right of the field/ instead of X checkmark for unacceptable input.");
      registrationPage.registerNewUserWithManualInputAndClickOnSignInButton("PeterPan12", "extralongofficialbusines@abv.bg", "02/01/1993", "Kkpass13", "Kkpass13", "designer");

      log.info("STEP 3. Verify unsuccessful flow result.");
      registrationPage.regFailedGetLogToastMessage();

      log.info("STEP 4. Check, that the user was not redirected to the home link, since registration failed and stayed on the same registration page.");
      Assert.assertTrue(registrationPage.isRegFormSignUpHeaderPresented());

      log.info("STEP 5. Display the difference between actual and expected behaviour.");
      Assert.assertEquals(REGISTRATION_FAILED_MSG, REGISTRATION_SUCCESSFUL_MSG);
   }

   @Test
   public void verifyRegistrationFormSignInButtonIsDisabled() throws InterruptedException {

      RegistrationPage registrationPage = new RegistrationPage(super.driver, log);

      log.info("STEP 1. The user is on the registration page.");
      registrationPage.navigateToRegistrationPage();

      log.info("STEP 2. Check for visibility and inspect the 'Sign in' button, whether it is enabled.");
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      regSignInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-in-button")));
      Assert.assertTrue(regSignInButton.isEnabled());
   }

   @Test
   public void verifyRegistrationFormSignInButtonSyntaxIsNotCorrectDefinedAndCanMisleadTheUser() throws InterruptedException {

      RegistrationPage registrationPage = new RegistrationPage(super.driver, log);

      log.info("STEP 1. The user is landed on the registration page.");
      registrationPage.navigateToRegistrationPage();

      log.info("STEP 2. Get the text from registration form 'Sign in' button.");
      registrationPage.getTextFromRegFormSignInButton();

      log.info("STEP 3. Retrieve the text from registration form 'Sign up' header.");
      registrationPage.getTextFromRegFormSignUpHeader();

      log.info("STEP 4. Regarding the main purpose of registration form - 'Sign up', verification for actual and expected result is accurately displayed with comparison.");
      Assert.assertEquals(regFormSignInButtonText, regFormSignUpHeader);
   }

   @Test
   public void verifyRegistrationFormEmailFieldNameDistinguishesFromTheRestOfTheFields() throws InterruptedException {

      RegistrationPage registrationPage = new RegistrationPage(super.driver, log);

      log.info("STEP 1. The user is navigating to  the registration page.");
      registrationPage.navigateToRegistrationPage();

      log.info("STEP 2. In a manner to show the regular expression for the rest of the fields, the retrieved text is introduced for each field.");
      registrationPage.getValueFromRegFormUsernamePlaceholder();
      registrationPage.getValueFromRegFormPasswordPlaceholder();
      registrationPage.getValueFromRegFormConfirmPasswordPlaceholder();
      registrationPage.getValueFromRegFormPublicInfoPlaceholder();

      log.info("STEP 3. The result is shown via actual and expected naming comparison - the proper one is starting with Capital letter.");
      registrationPage.getValueFromRegFormEmailPlaceholder();
      Assert.assertEquals(emailSyntax, emailRevisedSyntax);
   }

   @Test
   public void verifyRegistrationSuccessWithNonRealisticUserDateOfBirth() throws InterruptedException {

      RegistrationPage registrationPage = new RegistrationPage(super.driver, log);

      log.info("STEP 1. The user is on  the registration page.");
      registrationPage.navigateToRegistrationPage();

      log.info("STEP 2. Provide user credentials for the registration.");
      registrationPage.registerNewUserWithManualInput("aladin24", "a.antonova24@abv.bg", "05/04/1905", "antonA61", "antonA61", "team leader");

      log.info("STEP 3. Click on the 'Sign in' button, if the previous condition is met.");
      registrationPage.clickOnSignInButton();

      log.info("STEP 4. Check the registration success and display the difference between actual, and expected behaviour.");
      registrationPage.getAlertMsgFromSuccessRegistration();
      Assert.assertEquals(REGISTRATION_SUCCESSFUL_MSG, REGISTRATION_FAILED_MSG);
   }

   @Test
   public void verifyRegistrationConfirmPasswordIdSyntaxIsNotConsistentWithThePrimaryPasswordId() throws InterruptedException {

      RegistrationPage registrationPage = new RegistrationPage(super.driver, log);

      log.info("STEP 1. The registration page is opened.");
      registrationPage.navigateToRegistrationPage();

      log.info("STEP 2. Inspect the primary 'Password' id syntax, which is consistent with the field's purpose and any related functionality.");
      registrationPage.getValueFormPasswordWithProperId();

      log.info("STEP 3. Review the 'Confirm Password' id syntax, which suggest it relates to a phone number or a phone-related password, which would be misleading.");
      registrationPage.getValueFromConfirmPasswordWithNoConsistentId();

      log.info("STEP 4. Approve the actual and expected(suggested) syntax, that would be more accurate and meaningful choice for a 'Confirm Password' id, since the semantics goal is to maintain clarity and avoid confusion.");
      Assert.assertEquals(regFormConfirmPassActualIdSyntax, regFormConfirmPassExpectedIdSyntax);
   }
}
