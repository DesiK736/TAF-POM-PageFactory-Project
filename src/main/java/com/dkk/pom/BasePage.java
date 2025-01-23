package com.dkk.pom;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    private static final String BASE_URL = "http://training.skillo-bg.com:4300/";
    private static final String ISKILLO_LOGO = "Iskillo";
    private static final String LOGIN_FORM_HEADER = "Sign in";
    private static final String USER_IVAN = "ivanIvanov";
    private static final String PASSWORD_IVAN = "goodPass2";
    private static final String EMAIL_IVAN = "iv.iv@gmail.com";
    private static final String USER_JAMES_II = "jamesClark1525012";
    private static final String PASSWORD_JAMES_II = "cool1245jlK";

    @FindBy(id = "nav-link-home")
    private WebElement navigationBarHomeLink;

    @FindBy(id = "nav-link-login")
    private WebElement navigationBarLoginLink;

    @FindBy(id = "nav-link-profile")
    private WebElement navigationBarProfileLink;

    @FindBy(id = "nav-link-new-post")
    private WebElement navigationBarNewPostLink;

    @FindBy(css = "#defaultLoginFormUsername")
    private WebElement loginPageUsernameOrEmailInputField;

    @FindBy(id = "defaultLoginFormPassword")
    private WebElement loginPagePasswordInputField;

    @FindBy(xpath = "//input[contains(@formcontrolname,'rememberMe')]")
    private WebElement loginPageRememberMeCheckboxButton;

    @FindBy(id = "sign-in-button")
    private WebElement loginAndRegFormSignInButton;

    @FindBy(id = "search-bar")
    private WebElement loginNavBarSearchBarInputField;

    @FindBy(css = "input[placeholder=Username]")
    private WebElement regFormUsernameInputField;

    @FindBy(css = "input[placeholder=email]")
    private WebElement regFormEmailInputField;

    @FindBy(css = "input[placeholder='Birth date']")
    private WebElement regFormBirthDateInputField;

    @FindBy(css = "input[placeholder=Password]")
    private WebElement regFormPasswordInputField;

    @FindBy(css = "input[placeholder='Confirm Password']")
    private WebElement regFormConfirmPasswordInputField;

    @FindBy(css = "textarea[placeholder='Public info']")
    private WebElement regFormPublicInfoInputField;

    WebDriver driver;
    WebDriverWait wait;
    Logger log;

    public BasePage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateTo(String pageURLSuffix) {
        String currentURL = BASE_URL + pageURLSuffix;
        String webPageLogo = ISKILLO_LOGO;

        driver.get(currentURL);
        log.info("CONFIRM ==> The user has navigated to: " +currentURL + " , with the web page logo: " +  webPageLogo + "!");

        waitPageToBeFullyLoaded();
    }

    public void navigateToPageAndEnterRegisteredUserIvanLoginCredentials(String pageURLSuffix, WebElement loginPageUsernameOrEmailInputField, WebElement loginPagePasswordInputField, WebElement loginPageRememberMeCheckboxButton, WebElement loginAndRegFormSignInButton) {
        String currentURL = BASE_URL + pageURLSuffix;
        String webPageLogo = ISKILLO_LOGO;
        String username = "ivanIvanov";
        String password = "goodPass2";

        driver.get(currentURL);
        log.info("CONFIRM ==> The user with credentials 'username':  "+ username + ", and 'password': " + password + ", has navigated to: " +currentURL + " , and logged in proper with visible web page logo: " +  webPageLogo +  "!");

        waitPageToBeFullyLoaded();
        waitAndTypeTextInField(loginPageUsernameOrEmailInputField, username);
        waitAndTypeTextInField(loginPagePasswordInputField, password);
        waitAndClickOnWebElement(loginPageRememberMeCheckboxButton);
        waitAndClickOnWebElement(loginAndRegFormSignInButton);
    }

    public void waitAndClickOnWebElement(WebElement elm) {
        wait.until(ExpectedConditions.visibilityOf(elm));
        wait.until(ExpectedConditions.elementToBeClickable(elm));
        elm .click();
        waitPageToBeFullyLoaded();
    }

    public void waitAndTypeTextInField(WebElement textField, String inputText) {
        wait.until(ExpectedConditions.visibilityOf(textField));
        textField.clear();
        textField.sendKeys(inputText);
        waitPageToBeFullyLoaded();
    }

    public void waitPageToBeFullyLoaded() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
    }

    private String locatorInfo(WebElement elm){
        String[] rawWebElmInfo = elm.toString().split("->");
        String[] webElmInfo = rawWebElmInfo[1].split(":");
        String locatorStrategy = webElmInfo[0];
        String locatorExpression = webElmInfo[1];
        String info  = "LOCATOR STRATEGY BY: " + locatorStrategy.toUpperCase() + " LOCATOR EXPRESSION: " + locatorExpression;
        return  info;
    }

    public String waitAndGetText(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            String text = element.getText();
            System.out.println("WEB ELEMENT RETRIEVED TEXT: " + text +  ", with " +  locatorInfo(element));
            return text;
        } catch (TimeoutException e) {
            throw new RuntimeException("ELEMENT NOT VISIBLE WITHIN THE TIMEOUT PERIOD: " + locatorInfo(element), e);
        }
    }

    public String waitAndGetValue(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            String text = element.getAttribute("placeholder");
            System.out.println("WEB ELEMENT RETRIEVED VALUE: " + text + ", with " + locatorInfo(element));
            return text;
        } catch (TimeoutException e) {
            throw new RuntimeException("ELEMENT NOT VISIBLE WITHIN THE TIMEOUT PERIOD: " + locatorInfo(element), e);
        }
    }

    public String getRegisteredUsernameIvan() {
        return USER_IVAN;
    }

    public String getRegisteredPasswordIvan() {
        return PASSWORD_IVAN;
    }

    public String getRegisteredEmailIvan() {
        return EMAIL_IVAN;
    }

    public String getRegisteredUsernameJamesII() {
        return USER_JAMES_II;
    }

    public String getRegisteredPasswordJamesII() {
        return PASSWORD_JAMES_II;
    }

    public String getLoginFormHeader() {
        return LOGIN_FORM_HEADER;
    }

    public String getNavigationBarIskilloLogo() {
        return ISKILLO_LOGO;
    }

    public WebElement getLoginPageUsernameOrEmailInputField() {
        return loginPageUsernameOrEmailInputField;
    }

    public WebElement getLoginPagePasswordInputField() {
        return loginPagePasswordInputField;
    }

    public WebElement getLoginPageRememberMeCheckboxButton() {
        return loginPageRememberMeCheckboxButton;
    }

    public WebElement getSignInButtonForRegOrLogin() {
        return loginAndRegFormSignInButton;
    }

    public WebElement getLoginNavBarSearchBarInputField() {
        return loginNavBarSearchBarInputField;
    }

    public WebElement getNavigationBarHomeLink() {
        return navigationBarHomeLink;
    }

    public WebElement getNavigationBarProfileLink() {
        return navigationBarProfileLink;
    }

    public WebElement getNavigationBarNewPostLink() {
        return navigationBarNewPostLink;
    }

    public WebElement getRegFormUsernameInputField() {
        return regFormUsernameInputField;
    }

    public WebElement getRegFormEmailInputField() {
        return regFormEmailInputField;
    }

    public WebElement getRegFormBirthDateInputField() {
        return regFormBirthDateInputField;
    }

    public WebElement getRegFormPasswordInputField() {
        return regFormPasswordInputField;
    }

    public WebElement getRegFormConfirmPasswordInputField() {
        return regFormConfirmPasswordInputField;
    }

    public WebElement getRegFormPublicInfoInputField() {
        return regFormPublicInfoInputField;
    }

    public boolean isURLLoaded(String pageURL) {
        waitPageToBeFullyLoaded();
        return wait.until(ExpectedConditions.urlContains(pageURL));
    }

    //The method is created to make visibility and functional check of the private - reusable web element 'navigationBarLoginLink' and then to load the relevant url.
    public boolean isNavigationBarLoginLinkLoadedAfterVisibilityAndFunctionalCheck() {
        boolean isNavigationBarLoginLinkVisible = false;

        try {
            WebElement navigationBarLoginLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-link-login")));
            wait.until(ExpectedConditions.visibilityOf(navigationBarLoginLink)).click();
            log.info("~ WEB ELEMENT VISIBILITY CHECK DONE, LINK LOADED PROPER WITH ~ "+ locatorInfo(navigationBarLoginLink));
            isNavigationBarLoginLinkVisible = true;
            wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users/login"));
        } catch (TimeoutException e) {
            log.error("~ WEB ELEMENT NOT VISIBLE WITHIN THE TIMEOUT PERIOD WITH ~ " + locatorInfo(navigationBarLoginLink));
            isNavigationBarLoginLinkVisible = false;
        }
        return isNavigationBarLoginLinkVisible;
    }

    //The method is created to make visibility and functional check of the private - reusable web element 'navigationBarProfileLink'.
    public boolean isNavigationBarProfileLinkAccessibleAfterVisibilityAndFunctionalCheck() {
        boolean isNavigationBarProfileLinkVisible = false;

        try {
            WebElement navigationBarProfileLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-link-profile")));
            wait.until(ExpectedConditions.visibilityOf(navigationBarProfileLink)).click();
            log.info(" ~ WEB ELEMENT VISIBILITY CHECK DONE, LINK LOADED PROPER WITH ~  "+ locatorInfo(navigationBarProfileLink));
            isNavigationBarProfileLinkVisible = true;
        } catch (TimeoutException e) {
            log.error(" ~ WEB ELEMENT NOT VISIBLE WITHIN THE TIMEOUT PERIOD WITH ~ " + locatorInfo(navigationBarProfileLink));
            isNavigationBarProfileLinkVisible = false;
        }
        return isNavigationBarProfileLinkVisible;
    }

    //The method is engaged to make visibility and functional check of the private - reusable web element 'navigationBarNewPostLink', then to load the relevant url.
    public boolean isNavigationBarNewPostLinkLoadedAfterVisibilityAndFunctionalCheck() {
        boolean isNavigationBarNewPostLinkVisible = false;

        try {
            WebElement navigationBarNewPostLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-link-new-post")));
            wait.until(ExpectedConditions.visibilityOf(navigationBarNewPostLink)).click();
            log.info(" ~ WEB ELEMENT VISIBILITY CHECK DONE AND LINK LOADED PROPER WITH ~  " +  locatorInfo(navigationBarNewPostLink));
            isNavigationBarNewPostLinkVisible = true;
            wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/posts/create"));
        } catch (TimeoutException e) {
            log.error(" ~ WEB ELEMENT NOT VISIBLE WITHIN THE TIMEOUT PERIOD WITH  ~ " +  locatorInfo(navigationBarNewPostLink));
            isNavigationBarNewPostLinkVisible = false;
        }
        return isNavigationBarNewPostLinkVisible;
    }

//The main purpose of the method is to approve visibility for the private - reusable web element 'navigationBarHomeLink' and the result to be retrieved,
// whenever the method is called.
    public boolean isNavigationBarHomeLinkVisible() {
        boolean isNavigationBarHomeLinkVisible = false;

        try {
            WebElement navigationBarHomeLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-home")));
            log.info(" <-> VISIBLE! <-> Web element is visible with locator info: " + locatorInfo(navigationBarHomeLink));
            isNavigationBarHomeLinkVisible = true;
        } catch (TimeoutException e) {
            log.error("=-= VISIBILITY ISSUE! =-= Web element is NOT visible with locator info: " + locatorInfo(navigationBarHomeLink));
            isNavigationBarHomeLinkVisible = false;
        }
        return isNavigationBarHomeLinkVisible;
    }

    public boolean isPresented(WebElement elm) {
        boolean isWebElementShown = false;
        String li = locatorInfo(elm);

        log.info("|| ACTION || The user is verifying the web element with locator info: " + li);
        try {
            wait.until(ExpectedConditions.visibilityOf(elm));
            log.info(" <<>> SHOWN! <<>> Web element is shown with locator info: " + li);
            isWebElementShown = true;
        } catch (TimeoutException e) {
            log.error("<< NOT SHOWN! >> Web element is NOT shown with locator info: " + li);
            isWebElementShown = false;
        }
        return isWebElementShown;
    }
}
