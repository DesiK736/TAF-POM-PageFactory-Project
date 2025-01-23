package com.dkk.pom;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private static final String LOGIN_PAGE_URL = "users/login";

    @FindBy(css = "input[placeholder='Username or email']")
    private WebElement usernameOrEmailPlaceholder;

    @FindBy(css = "input[placeholder='Password']")
    private WebElement passwordPlaceholder;

    @FindBy(xpath = "//span[contains(text(),'Remember me')]")
    private WebElement rememberMeCheckboxLabel;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    private WebElement loginFormSignInButtonLabel;

    @FindBy(xpath = "//span[contains(.,'Not a member?')]")
    private WebElement loginFormNot_A_MemberLabel;

    @FindBy(xpath = "//a[contains(.,'Register')]")
    private WebElement loginFormRegisterLink;

    @FindBy(css = ".toast-message")
    private WebElement loginPageMsgAlert;

    @FindBy(xpath = "//*[contains(text(),'Successful login!')]")
    private WebElement loginSuccessMsg;

    @FindBy(xpath = "//i[contains(@class,'fas fa-sign-out-alt fa-lg')]/.")
    private WebElement navBarLogOutButton;

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        navigateTo(LOGIN_PAGE_URL);
    }

    public void provideLogInCredentialsWithUsernameInput(String username, String password) {
        waitAndTypeTextInField(getLoginPageUsernameOrEmailInputField(), username);
        waitAndTypeTextInField(getLoginPagePasswordInputField(), password);
        waitAndClickOnWebElement(getLoginPageRememberMeCheckboxButton());
        waitAndClickOnWebElement(getSignInButtonForRegOrLogin());
    }

    public void provideLogInCredentialsWithEmailInput(String email, String password) {
        waitAndTypeTextInField(getLoginPageUsernameOrEmailInputField(), email);
        waitAndTypeTextInField(getLoginPagePasswordInputField(), password);
        waitAndClickOnWebElement(getLoginPageRememberMeCheckboxButton());
        waitAndClickOnWebElement(getSignInButtonForRegOrLogin());
    }

    public void provideTextForNavBarSearchInputField(String searchBarInput) {
        waitAndTypeTextInField(getLoginNavBarSearchBarInputField(), searchBarInput);
    }

    public void clickOnNavBarHomeLinkAfterLogin() {
        waitAndClickOnWebElement(getNavigationBarHomeLink());
    }

    public void clickOnNavBarLogOutButton() {
        waitAndClickOnWebElement(navBarLogOutButton);
    }

    public void clickOnLoginFormRegisterLink() {
        waitAndClickOnWebElement(loginFormRegisterLink);
    }

    public String provideTextForNavBarSearchFieldAndRetrieveTheTxt(String searchBarInput) {
        waitAndTypeTextInField(getLoginNavBarSearchBarInputField(), searchBarInput);
        return searchBarInput;
    }

    public String provideInputForUsernameFieldAndRetrieveTheTxt(String usernameInput) {
        waitAndTypeTextInField(getLoginPageUsernameOrEmailInputField(), usernameInput);
        return usernameInput;
    }

    public String provideInputForPasswordFieldAndRetrieveTheTxt(String passwordInput) {
        waitAndTypeTextInField(getLoginPagePasswordInputField(), passwordInput);
        waitAndClickOnWebElement(getSignInButtonForRegOrLogin());
        return passwordInput;
    }

    public String logInFailedGetLogToastMessage() {
        try {
            WebElement logInPageMsgAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")));
            String logInFailedLogToastMsg = logInPageMsgAlert.getText();

            log.info("(✓) CONFIRMATION! => Toast message for failed log in:  " + logInFailedLogToastMsg);
        } catch (Exception e) {
            log.info("(X) FAILED LOG! => Failed to log toast message:  " + e.getMessage());
        }
        return loginPageMsgAlert.getText();
    }

    public void getTextFromRememberMeCheckboxLabel() {
        waitAndGetText(rememberMeCheckboxLabel);
    }

    public void getTextFromLoginFormSignInButtonLabel() {
        waitAndGetText(loginFormSignInButtonLabel);
    }

    public void getTextFromLoginFormNotAMemberLabel() {
        waitAndGetText(loginFormNot_A_MemberLabel);
    }

    public void getValueFromLoginFormUsernameOrEmailPlaceholder() {
        waitAndGetValue(usernameOrEmailPlaceholder);
    }

    public void getValueFromLoginFormPasswordPlaceholder() {
        waitAndGetValue(passwordPlaceholder);
    }

    public void getTextFromLoginFormRegisterLink() {
        waitAndGetText(loginFormRegisterLink);
    }

    public void getAlertMsgFromSuccessLogin() {
        waitAndGetText(loginSuccessMsg);
    }

    public boolean isNavBarHomeLinkAfterLoginPresented() {
        return isPresented(getNavigationBarHomeLink());
    }

    public boolean isLoginNavBarSearchBarInputFieldShown() {
        return isPresented(getLoginNavBarSearchBarInputField());
    }

    public boolean isNavBarLogOutButtonPresented() {
        return isPresented(navBarLogOutButton);
    }

    //The main goal of the method is to approve the infinite login enter opportunities, until the user authenticates proper.
    //Since the count of attempts are not limited, the test is created with max 4 attempts.
    public boolean isLoginAuthenticationValid(String correctUsername, String correctPassword, int maxAttempts) {
        boolean isAuthenticated = false;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            String username = "ivanIvanov";
            String password = "goodPass";
            provideLogInCredentialsWithUsernameInput(username, password);

            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                isAuthenticated = true;
                log.info(" .*. CONGRATS! .*.  You've logged in successfully! " +  "Entered username: " + correctUsername + " , and password: "  + correctPassword);
                break;
            } else {
                log.info(" [!] LOGIN FAILED!  Invalid credentials! Please, try again! " +  "Entered username: " + username + " , and password: "  +  password);
            }
        }

        if (!isAuthenticated) {
            log.info(" Too many failed attempts! Access is still denied. Proceed with your tries, unless your authentication is proper!");
        }
        return isAuthenticated;
    }
}
