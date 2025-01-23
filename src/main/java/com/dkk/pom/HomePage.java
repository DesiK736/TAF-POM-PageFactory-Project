package com.dkk.pom;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private static final String HOME_PAGE_URL = "posts/all";

    @FindBy(xpath = "//a[text()='TestUserUserUserUser']")
    private WebElement homePageNewUsersForConnectionFirstSuggest;

    @FindBy(xpath = "//a[text()='MARIELKATA']")
    private WebElement homePageNewUsersForConnectionSecondSuggest;

    @FindBy(xpath = "//a[text()='marielka11']")
    private WebElement homePageNewUsersForConnectionsThirdSuggest;

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        navigateTo(HOME_PAGE_URL);
    }

    public void navigateToTheFirstConnectionSuggest() {
        navigateTo("users/31");
    }

    public void navigateToTheSecondConnectionSuggest() {
        navigateTo("users/32");
    }

    public void navigateToTheThirdConnectionSuggest() {
        navigateTo("users/33");
    }

    public void getTextFromFirstConnectionSuggest() {
        waitAndGetText(homePageNewUsersForConnectionFirstSuggest);
    }

    public void getTextFromSecondConnectionSuggest() {
        waitAndGetText(homePageNewUsersForConnectionSecondSuggest);
    }

    public void getTextFromThirdConnectionSuggest() {
        waitAndGetText(homePageNewUsersForConnectionsThirdSuggest);
    }

    public boolean isFirstSuggestForNewUsersConnectionPresented() {
        return isPresented(homePageNewUsersForConnectionFirstSuggest);
    }

    public boolean isSecondSuggestForNewUsersConnectionPresented() {
        return isPresented(homePageNewUsersForConnectionSecondSuggest);
    }

    public boolean isThirdSuggestForNewUsersConnectionPresented() {
        return isPresented(homePageNewUsersForConnectionsThirdSuggest);
    }
}
