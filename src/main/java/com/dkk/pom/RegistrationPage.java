package com.dkk.pom;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {
   private static final String REGISTER_PAGE_URL = "/users/register";

   @FindBy(css = "#nav-link-login")
   private WebElement regNavigationBarLink;

   @FindBy(css = "h4.text-center")
   private WebElement regSignUpTitleText;

   @FindBy(name = "username")
   private WebElement regUsernameInputField;

   @FindBy(css = "input[placeholder=email]")
   private WebElement regEmailInputField;

   @FindBy(css = "input[type=date]")
   private WebElement regCalendarPopUpIcon;

   @FindBy(name = "password")
   private WebElement regPasswordInputField;

   @FindBy(css = "input[placeholder='Confirm Password']")
   private WebElement regConfirmPasswordInputField;

   @FindBy(css = "textarea[placeholder='Public info']")
   private WebElement regPublicInfoInputField;

   @FindBy(xpath = "//button[contains(text(),'Sign in')]")
   private WebElement regSignInRegButtonText;

   @FindBy(xpath = "//*[@id='sign-in-button']")
   private WebElement regSignInButton;

   @FindBy(name = "Successful register!")
   private WebElement regPageSuccessMsg;

   public  RegistrationPage(WebDriver driver, Logger log)  {
      super(driver, log);
      PageFactory.initElements(driver, this);
   }

   public void openRegistrationPage() {
      navigateTo(REGISTER_PAGE_URL);
   }

   public void navigateToRegistrationPageViaClickOnRegisterLink() {
      waitAndClickOnWebElement(regNavigationBarLink);
   }

   public void provideRegistrationCredentials (String username, String email, String password, String confirmPass, String publicInfo) {
      waitAndTypeTextInField(regUsernameInputField, username);
      waitAndTypeTextInField(regEmailInputField, email);
      waitAndTypeTextInField(regPasswordInputField, password);
      waitAndTypeTextInField(regConfirmPasswordInputField, confirmPass);
      waitAndTypeTextInField(regPublicInfoInputField, publicInfo);
   }

   public void clickOnCalendarPopUpIcon () {
      waitAndClickOnWebElement(regCalendarPopUpIcon);
   }

   public void  clickOnSignInButton () {
      waitAndClickOnWebElement(regSignInRegButtonText);
   }
}
