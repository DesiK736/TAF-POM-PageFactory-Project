package com.dkk.pom;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public static final String LOGIN_PAGE_URL = "/users/login";

   @FindBy(id = "nav-link-login")
   private WebElement navBarHomeLinkLogin;

    @FindBy(css = "p.h4")
    private WebElement loginHeaderTitle;

    @FindBy(css = "#defaultLoginFormUsername")
    private WebElement userNameInputField;

    @FindBy(id = "defaultLoginFormPassword")
    private WebElement passwordInputField;

    @FindBy(xpath = "//span[contains(text(),'Remember me')]")
    private WebElement rememberMeCheckBoxLabel;

    @FindBy(xpath = "//input[contains(@formcontrolname,'rememberMe')]")
    private WebElement rememberMeCheckBoxButton;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    private WebElement loginFormSignInButtonLabel;

    @FindBy(xpath = "//span[contains(.,'Not a member?')]")
    private WebElement loginFormNot_A_MemberText;

    @FindBy(xpath = "//a[contains(.,'Register')]")
    private WebElement loginFormRegisterText;

    @FindBy(id = "sign-in-button")
    private WebElement loginFormSignInButton;

    @FindBy(id = "toast-container")
    private WebElement loginPageMsgAlert;

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
       navigateTo(LOGIN_PAGE_URL);
    }

    public void navigateToLoginPageViaClickOnNavigationLoginLink() {
        waitAndClickOnWebElement(navBarHomeLinkLogin);
    }

    public void provideCredentials(String username, String password) {
        waitAndTypeTextInField(userNameInputField, username);
        waitAndTypeTextInField(passwordInputField, password);
    }

    public void clickOnRememberMeCheckbox () {
        waitAndClickOnWebElement(rememberMeCheckBoxButton);
    }

    public void clickOnLoginFormSignInButton () {
        waitAndClickOnWebElement(loginFormSignInButton);
    }
}
