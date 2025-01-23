package com.dkk.pom;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

   private static final String REGISTRATION_PAGE_URL = "users/register";

   @FindBy(css = "h4.text-center")
   private WebElement regFormSignUpHeader;

   @FindBy(id = "defaultRegisterFormPassword")
   private WebElement regFormPasswordProperId;

   @FindBy(id = "defaultRegisterPhonePassword")
   private WebElement regFormConfirmPasswordNotConsistentId;

   @FindBy(xpath = "//button[contains(text(),'Sign in')]")
   private WebElement regFormSignInButtonText;

   @FindBy(css= "div.toast-message.ng-star-inserted")
   private WebElement regPageFailedNotificationMsg;

   @FindBy(id = "toast-container")
   private WebElement regPageSuccessNotificationMsg;

   @FindBy(css = ".invalid-feedback")
   private WebElement regPageInvalidFeedbackUsernameInput;

   @FindBy(xpath = "//*[contains(text(),'Version: 2020.3.2.4300')]")
   private WebElement versionTextFooter;

   @FindBy(xpath = "//*[contains(text(),'Technologies:')]")
   private WebElement technologiesTextFooter;

   public  RegistrationPage(WebDriver driver, Logger log)  {
      super(driver, log);
      PageFactory.initElements(driver, this);
   }

   public void navigateToRegistrationPage() {
      navigateTo(REGISTRATION_PAGE_URL);
   }

   public void registerNewUserWithDataGeneratorForUserAndEmailFields(String username, String email, String dateOfBirth, String password, String confirmPass, String publicInfo) {
      waitAndTypeTextInField(getRegFormUsernameInputField(), username);
      waitAndTypeTextInField(getRegFormEmailInputField(), email);
      waitAndTypeTextInField(getRegFormBirthDateInputField(), dateOfBirth);
      waitAndTypeTextInField(getRegFormPasswordInputField(), password);
      waitAndTypeTextInField(getRegFormConfirmPasswordInputField(), confirmPass);
      waitAndTypeTextInField(getRegFormPublicInfoInputField(), publicInfo);
      waitAndClickOnWebElement(getSignInButtonForRegOrLogin());
      log.info(" -=| REGISTRATION CREDENTIALS |=- " + "user: " +  username + ", email: " + email + ", date of birth: " + dateOfBirth + ", pass: " + password);
   }

   public void registerNewUserWithManualInputAndClickOnSignInButton(String username, String email, String dateOfBirth, String password, String confirmPass, String publicInfo) {
      waitAndTypeTextInField(getRegFormUsernameInputField(), username);
      waitAndTypeTextInField(getRegFormEmailInputField(), email);
      waitAndTypeTextInField(getRegFormBirthDateInputField(), dateOfBirth);
      waitAndTypeTextInField(getRegFormPasswordInputField(), password);
      waitAndTypeTextInField(getRegFormConfirmPasswordInputField(), confirmPass);
      waitAndTypeTextInField(getRegFormPublicInfoInputField(), publicInfo);
      waitAndClickOnWebElement(getSignInButtonForRegOrLogin());
      log.info(" -=| REGISTRATION CREDENTIALS |=-  " + "user: " + username + ", email: " + email + ", date of birth: " + dateOfBirth + ", pass: " + password);
   }

   public void registerNewUserWithManualInput(String username, String email, String dateOfBirth, String password, String confirmPass, String publicInfo) {
      waitAndTypeTextInField(getRegFormUsernameInputField(), username);
      waitAndTypeTextInField(getRegFormEmailInputField(), email);
      waitAndTypeTextInField(getRegFormBirthDateInputField(), dateOfBirth);
      waitAndTypeTextInField(getRegFormPasswordInputField(), password);
      waitAndTypeTextInField(getRegFormConfirmPasswordInputField(), confirmPass);
      waitAndTypeTextInField(getRegFormPublicInfoInputField(), publicInfo);
      log.info("-=| REGISTRATION CREDENTIALS |=-  " + "user: " + username + ", email: " + email + ", date of birth: " + dateOfBirth + ", pass: " + password + ", confirm pass: " + confirmPass);
   }

   public void  clickOnSignInButton () {
      waitAndClickOnWebElement(getSignInButtonForRegOrLogin());
   }

   public void getTextFromRegFormSignUpHeader() {
      waitAndGetText(regFormSignUpHeader);
   }

   public void getTextFromRegFormSignInButton() {
      waitAndGetText(regFormSignInButtonText);
   }

   public void getAlertMsgFromSuccessRegistration() {
      waitAndGetText(regPageSuccessNotificationMsg);
   }

   public void getTextFromTheRegisterFormUserInvalidFeedback() {
      waitAndGetText(regPageInvalidFeedbackUsernameInput);
   }

   public void getTextFromVersionFooter() {
      waitAndGetText(versionTextFooter);
   }

   public void getTextFromTechnologiesFooter() {
      waitAndGetText(technologiesTextFooter);
   }

   public void getValueFromRegFormUsernamePlaceholder() {
      waitAndGetValue(getRegFormUsernameInputField());
   }

   public void getValueFromRegFormEmailPlaceholder() {
      waitAndGetValue(getRegFormEmailInputField());
   }

   public void getValueFromRegFormCalendarPlaceholder() {
      waitAndGetValue(getRegFormBirthDateInputField());
   }

   public void getValueFromRegFormPasswordPlaceholder() {
      waitAndGetValue(getRegFormPasswordInputField());
   }

   public void getValueFromRegFormConfirmPasswordPlaceholder() {
      waitAndGetValue(getRegFormConfirmPasswordInputField());
   }

   public void getValueFormPasswordWithProperId() {
      waitAndGetValue(regFormPasswordProperId);
   }

   public void getValueFromConfirmPasswordWithNoConsistentId() {
      waitAndGetValue(regFormConfirmPasswordNotConsistentId);
   }

   public void getValueFromRegFormPublicInfoPlaceholder() {
      waitAndGetValue(getRegFormPublicInfoInputField());
   }

   public String regFailedGetLogToastMessage() {
      try {
         WebElement regPageFailedNotificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.toast-message.ng-star-inserted")));
         String regPageFailedToastMsg = regPageFailedNotificationMsg.getText();

         log.info("(✓) CONFIRMATION! => Toast message for failed registration:  " + regPageFailedToastMsg);
      } catch (Exception e) {
         log.info("(X) FAILED LOG! => Failed to log toast message:  " + e.getMessage());
      }
      return regPageFailedNotificationMsg.getText();
   }

   public boolean isRegSignInButtonShown() {
      return isPresented(getSignInButtonForRegOrLogin());
   }

   public boolean isRegFormSignUpHeaderPresented() {
      return isPresented(regFormSignUpHeader);
   }
}
