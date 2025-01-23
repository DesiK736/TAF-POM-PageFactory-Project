package gui.profile;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.BasePage;
import com.dkk.pom.LoginPage;
import com.dkk.pom.PostModal;
import com.dkk.pom.ProfilePage;
import gui.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class ProfileErrorsTest extends BaseTest {

    private WebElement profilePostsSectionNewPostButton;
    private static final String searchBarInput = "ivanIvanov";
    private static final String privatePostImageGallery = "Access restricted!";
    private static final String nameOfTheFollowedProfile = "ivanIvanov";
    private static final String privatePostsInvisibleForFollowers = "Private posts must be visible only for its owner!";

    @Test (priority = 0)
    public void verifyUserCanNotRedirectToTheNewPostPageAfterClickOnTheNewPostButton() throws InterruptedException {

        ProfilePage profilePage = new ProfilePage(super.driver, log);

        log.info("STEP 1. The user is navigating to the login page, typing his credentials and landing on the Home page after successful login.");
        profilePage.navigateToLoginPageAndEnterUserIvanCredentials();

        log.info("STEP 2. The user is landing on the profile page via click on navigation bar profile link.");
        profilePage.clickOnNavBarProfileLink();

        log.info("STEP 3. Verify the 'New post' button, whether it is clickable and click on it.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        profilePostsSectionNewPostButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".new-post-btn.btn.btn-primary")));
        profilePage.clickOnProfilePostsSectionNewPostButton();

        log.info("STEP 4. Check, if the 'New post' button is selected and verify the result of interaction.");
        Assert.assertTrue(profilePostsSectionNewPostButton.isSelected());
    }

    @Test (priority = 1)
    public void verifyThatPrivatePostCanBeVisibleAndAccessibleForAnotherUserWhoFollowsTheProfile() throws InterruptedException {

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1. The user is on the login page, typing his credentials and landing on the Home page after successful login.");
        loginPage.navigateToLoginPage();
        BasePage basePage = new BasePage(super.driver, log);
        loginPage.provideLogInCredentialsWithUsernameInput(basePage.getRegisteredUsernameJamesII(), basePage.getRegisteredPasswordJamesII());

        log.info("STEP 2. Navigate to the personal profile page for the relevant user.");
        ProfilePage profilePage = new ProfilePage(super.driver, log);
        profilePage.clickOnNavBarProfileLink();
        profilePage.navigateToProfilePageUserJamesII();
        Assert.assertTrue(profilePage.isURLLoaded("http://training.skillo-bg.com:4300/users/8884"));

        log.info("STEP 3. Verify the accessed profile and retrieve the username account.");
        profilePage.getTextFromProfileSectionUsernameJamesII();

        log.info("STEP 4. Check, if the user 'follows' the profile, which account will be accessed then and if it's true - retrieve the name.");
        String NameOfTheProfileUserWhichFollow =profilePage.getTheNameOfTheProfileUserWhichFollow();
        Assert.assertEquals(NameOfTheProfileUserWhichFollow, nameOfTheFollowedProfile);
        Thread.sleep(5000);

        log.info("STEP 5. Go to the navigation search bar field and type the profile username, that the user is followed.");
        loginPage.provideTextForNavBarSearchInputField(searchBarInput);

        log.info("STEP 6. Verify the visibility of the profile account, that the user is currently follow and click on it.");
        profilePage.clickOnTheDropdownSearchUserAccountIvan();

        log.info("STEP 7. Preview the private radio button on the followed profile page and click on it.");
        profilePage.clickOnThePrivateRadioButtonToDisplayPrivateImages();

        log.info("STEP 8. Verify the visibility of the followed profile private image/images.");
        Assert.assertTrue(profilePage.isThePrivatePostImagePresented());

        log.info("STEP 9. Display the actual and expected(suggested) behaviour for the private posts accessibility. Private segments must be fully protected from the rest of the users.");
        Assert.assertEquals(profilePage.isThePrivatePostImagePresented(), privatePostImageGallery);
    }

    @Test (priority = 2)
    public void verifyUserCanLikePrivatePostOnFollowedProfileAccount() throws InterruptedException {

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1. The user is on the login page, entering the credentials and landing on the Home page after successful login.");
        loginPage.navigateToLoginPage();
        BasePage basePage = new BasePage(super.driver, log);
        loginPage.provideLogInCredentialsWithUsernameInput(basePage.getRegisteredUsernameJamesII(), basePage.getRegisteredPasswordJamesII());

        log.info("STEP 2. Then the user has navigated to the profile page.");
        ProfilePage profilePage = new ProfilePage(super.driver, log);
        profilePage.clickOnNavBarProfileLink();

        log.info("STEP 3. Go to the navigation search bar field and type the profile username, that the user is followed.");
        loginPage.provideTextForNavBarSearchInputField(searchBarInput);
        Thread.sleep(5000);

        log.info("STEP 4. Verify the visibility of the profile account, that the user is currently follow and click on it.");
        profilePage.clickOnTheDropdownSearchUserAccountIvan();

        log.info("STEP 5. Preview the private radio button with the private posts gallery on the followed profile page and click on the selected item.");
        profilePage.clickOnThePrivatePostRadioButtonWithSelectedItem(0);

        log.info("STEP 6. Check the post info 'likes' count and retrieve the initial number, before likes action.");
        profilePage.getTextFromPostInfoLikesCount();

        log.info("STEP 7. Verify post like button and click on it.");
        profilePage.clickOnThePostLikeButton();

        log.info("STEP 8. Check, whether the private post is proper liked and approve successful flow.");
        Assert.assertTrue(profilePage.isLikeMessageVisible());

        log.info("STEP 9. Get the updated number from the 'likes' action.");
        profilePage.getTextFromPostInfoLikesCount();

        log.info("STEP 10. Display the actual and expected behaviour, and keep in mind, that private posts should be fully protected from the outer users.");
        Assert.assertEquals(profilePage.isLikeMessageVisible(), privatePostsInvisibleForFollowers);
    }

    @Test (priority = 3)
    public void verifyUserCanDislikePrivatePostOnFollowedProfileAccount() throws InterruptedException {

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1. The user is on the login page with entered credentials and landing on the Home page after successful login.");
        loginPage.navigateToLoginPage();
        BasePage basePage = new BasePage(super.driver, log);
        loginPage.provideLogInCredentialsWithUsernameInput(basePage.getRegisteredUsernameJamesII(), basePage.getRegisteredPasswordJamesII());

        log.info("STEP 2. Then go to the profile page.");
        ProfilePage profilePage = new ProfilePage(super.driver, log);
        profilePage.clickOnNavBarProfileLink();

        log.info("STEP 3. Reached to the navigation search bar field and type the profile username, that the user is followed.");
        loginPage.provideTextForNavBarSearchInputField(searchBarInput);
        Thread.sleep(5000);

        log.info("STEP 4. Check the visibility of the profile account, that the user is currently follow and click on it.");
        profilePage.clickOnTheDropdownSearchUserAccountIvan();

        log.info("STEP 5. Inspect the private radio button with the private posts gallery on the followed profile page and click on the selected post.");
        profilePage.clickOnThePrivatePostRadioButtonWithSelectedItem(0);

        log.info("STEP 6. Check the post info 'likes' count and retrieve the 'likes' number.");
        profilePage.getTextFromPostInfoLikesCount();

        log.info("STEP 7. Preview post dislike button and click on it.");
        profilePage.clickOnThePostDislikeButton();

        log.info("STEP 8. Check, whether the private post is proper 'disliked' and approve successful flow.");
        Assert.assertTrue(profilePage.isDislikeMessageVisible());

        log.info("STEP 9. Finally get the updated number from the 'disliked' action.");
        profilePage.getTextFromPostInfoLikesCount();

        log.info("STEP 10. Display the actual and expected behaviour. Keep in mind, that private posts should be fully protected from the outer users.");
        Assert.assertEquals(profilePage.isDislikeMessageVisible(), privatePostsInvisibleForFollowers);
    }

    @Test (priority = 4)
    public void verifyUserCanNotSelectDeletePostConfirmButtonNoOnTheChosenItem() throws InterruptedException {

        ProfilePage profilePage = new ProfilePage(super.driver, log);

        log.info("STEP 1. The user is navigated to the login page, entered login credentials and landed on the Home page after successful login.");
        profilePage.navigateToLoginPageAndEnterUserIvanCredentials();
        Assert.assertTrue(profilePage.isURLLoaded("http://training.skillo-bg.com:4300/posts/all"));

        log.info("STEP 2. Proceed with landing on the profile page after proper click on navigation bar profile link.");
        profilePage.clickOnNavBarProfileLink();

        log.info("STEP 3. Inspect the 'All' radio button with the all posts gallery on the followed profile and click on the selected item.");
        profilePage.clickOnTheAllPostRadioButtonWithSelectedItem(0);

        log.info("STEP 4. Review the chosen image and check for visibility.");
        PostModal postModal = new PostModal(super.driver, log);
        Assert.assertTrue(postModal.isImageVisible());

        log.info("STEP 5. Check the created post title and date for the selected picture, and retrieve the information.");
        profilePage.getTextFromTheCreatedPostTitle();
        profilePage.getTextFromTheCreatedPostDate();

        log.info("STEP 6. Verify the visibility of the post delete button.");
        Assert.assertTrue(profilePage.isThePostDeleteButtonPresented());

        log.info("STEP 7. Continue with functional test on post delete button.");
        profilePage.clickOnTheDeletePostButton();

        log.info("STEP 8. Check the delete confirmation message and retrieve the text.");
        profilePage.getTextFromDeletePostConfirmation();

        log.info("STEP 9. Verify the delete post confirmation button 'No' and move on to the functional test.");
        profilePage.clickOnTheDeleteConfirmationPostButtonNo();

        log.info("STEP 10. Review, if the confirm 'No' button function well and inspect the functional identical syntax for both buttons, which caused the exception.");
        Assert.assertTrue(profilePage.isDeleteConfirmationNoButtonFunctionAsExpected());
    }
}
