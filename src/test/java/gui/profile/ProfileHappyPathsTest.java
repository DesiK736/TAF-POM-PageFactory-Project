package gui.profile;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.BasePage;
import com.dkk.pom.LoginPage;
import com.dkk.pom.PostModal;
import com.dkk.pom.ProfilePage;
import gui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

public class ProfileHappyPathsTest  extends BaseTest {

    private static final String searchBarInputUserIvan = "ivanIvanov";
    private static final String searchBarInputUserPeterPan = "PanPeter89";
    private static final String postCommentInput = "Fairy picture!";
    File uploadAwesomeProfilePic = new File("src/test/resources/upload/pic1.jpg");
    File uploadNewProfilePic = new File("src/test/resources/upload/pic2.jpg");

    @Test (priority = 0)
    public void verifyUserAbilityToUploadAndUpdateProfilePicture() throws InterruptedException {

        ProfilePage profilePage = new ProfilePage(super.driver, log);

        log.info("STEP 1. The user is navigating to the login page, typing his credentials and landing on the Home page after successful login.");
        profilePage.navigateToLoginPageAndEnterUserIvanCredentials();
        Assert.assertTrue(profilePage.isURLLoaded("http://training.skillo-bg.com:4300/posts/all"));

        log.info("STEP 2. The user is landing on the profile page via click on navigation bar profile link.");
        profilePage.clickOnNavBarProfileLink();

        log.info("STEP 3. Upload the selected picture and set it as a profile image.");
        profilePage.uploadProfilePicture(uploadAwesomeProfilePic);

        log.info("STEP 4. Check the first uploaded profile picture and retrieve the text from the successful action.");
        profilePage.getAlertMsgFromTheFlow();

        log.info("STEP 5. Verify the new uploaded profile image, since it will be set as pic2.");
        profilePage.uploadProfilePicture(uploadNewProfilePic);

        log.info("STEP 6. Display the successful flow with the updated profile picture.");
        profilePage.getAlertMsgFromTheFlow();
    }

    @Test (priority = 1)
    public void verifyUserAbilityToFollowAndUnfollowAnotherProfileUser() throws InterruptedException {

        ProfilePage profilePage = new ProfilePage(super.driver, log);

        log.info("STEP 1. The user is on the login page, typing his credentials and landing on the Home page after successful login.");
        profilePage.navigateToLoginPageAndEnterUserIvanCredentials();

        log.info("STEP 2. Verify redirection to the home link after login.");
        LoginPage loginPage = new LoginPage(super.driver, log);
        Assert.assertTrue(loginPage.isNavBarHomeLinkAfterLoginPresented());

        log.info("STEP 3. Check for visibility of  the 'Search' bar field.");
        Assert.assertTrue(loginPage.isLoginNavBarSearchBarInputFieldShown());

        log.info("STEP 4. Provide input with the desired profile username.");
        loginPage.provideTextForNavBarSearchInputField(searchBarInputUserPeterPan);
        profilePage.clickOnTheDropdownSearchUserAccountPeterPan();

        log.info("STEP 5. Review follow button and click on it.");
        profilePage.clickOnTheFollowButton();

        log.info("STEP 6. Get alert message from the successful flow and retrieve the text, that the user followed desired profile.");
        profilePage.getAlertMsgFromTheFlow();
        Thread.sleep(5000);

        log.info("STEP 7. Approve, that the user can 'Unfollow' the same profile with another click on the 'Follow' button.");
        profilePage.clickOnTheUnfollowButton();

        log.info("STEP 8. Retrieve the successful message from the last click.");
        profilePage.getAlertMsgFromTheFlow();
    }

    @Test (priority = 2)
    public void verifyUserCanLikePostFromAllPostsGalleryOnTheFollowedProfileAccount() throws InterruptedException {

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1. The user is on the login page, entering the credentials and landing on the Home page after successful login.");
        loginPage.navigateToLoginPage();
        BasePage basePage = new BasePage(super.driver, log);
        loginPage.provideLogInCredentialsWithUsernameInput(basePage.getRegisteredUsernameJamesII(), basePage.getRegisteredPasswordJamesII());

        log.info("STEP 2. Then the user has navigated to the profile page.");
        ProfilePage profilePage = new ProfilePage(super.driver, log);
        profilePage.clickOnNavBarProfileLink();

        log.info("STEP 3. Go to the navigation search bar field and type the profile username, that the user is followed.");
        loginPage.provideTextForNavBarSearchInputField(searchBarInputUserIvan);
        Thread.sleep(4000);

        log.info("STEP 4. Verify the visibility of the profile account, that the user is currently follow and click on it.");
        profilePage.clickOnTheDropdownSearchUserAccountIvan();

        log.info("STEP 5. Preview the 'All' radio button with the all posts gallery on the followed profile page and click on the selected image.");
        profilePage.clickOnTheAllPostRadioButtonWithSelectedItem(0);
        Thread.sleep(4000);

        log.info("STEP 6. Check the post info 'likes' count and retrieve the initial number, before likes action.");
        profilePage.getTextFromPostInfoLikesCount();

        log.info("STEP 7. Verify post like button and click on it.");
        profilePage.clickOnThePostLikeButton();

        log.info("STEP 8. Check, whether the chosen post from 'All' posts gallery is proper liked and approve successful flow.");
        Assert.assertTrue(profilePage.isLikeMessageVisible());

        log.info("STEP 9. Finally get the updated number from the 'likes' action.");
        profilePage.getTextFromPostInfoLikesCount();
    }

    @Test (priority = 3)
    public void verifyUserCanDislikePostFromAllPostsGalleryOnTheFollowedProfileAccount() throws InterruptedException {

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1. The user is on the login page with entered credentials and landing on the Home page after successful login.");
        loginPage.navigateToLoginPage();
        BasePage basePage = new BasePage(super.driver, log);
        loginPage.provideLogInCredentialsWithUsernameInput(basePage.getRegisteredUsernameJamesII(), basePage.getRegisteredPasswordJamesII());

        log.info("STEP 2. Then go to the profile page.");
        ProfilePage profilePage = new ProfilePage(super.driver, log);
        profilePage.clickOnNavBarProfileLink();

        log.info("STEP 3. Reached to the navigation search bar field and type the profile username, that the user is followed.");
        loginPage.provideTextForNavBarSearchInputField(searchBarInputUserIvan);
        Thread.sleep(4000);

        log.info("STEP 4. Check the visibility of the profile account, that the user is currently follow and click on it.");
        profilePage.clickOnTheDropdownSearchUserAccountIvan();

        log.info("STEP 5. Inspect the 'All' radio button with the all posts gallery on the followed profile page and click on the selected item.");
        profilePage.clickOnTheAllPostRadioButtonWithSelectedItem(0);

        log.info("STEP 6. Check the post info 'likes' count and retrieve the 'likes' number.");
        profilePage.getTextFromPostInfoLikesCount();

        log.info("STEP 7. Preview post dislike button and click on it.");
        profilePage.clickOnThePostDislikeButton();

        log.info("STEP 8. Check, whether the selected post from 'All' posts gallery is proper 'disliked' and approve successful flow.");
        Assert.assertTrue(profilePage.isDislikeMessageVisible());

        log.info("STEP 9. Finally get the updated number from the 'disliked' action.");
        profilePage.getTextFromPostInfoLikesCount();
    }

    @Test (priority = 4)
    public void verifyUserCanLeaveACommentOnPostFromAllPostsGalleryOnTheFollowedProfileAccount() throws InterruptedException {

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1. The user is landed on the login page with entered credentials and navigating to the Home page after successful login.");
        loginPage.navigateToLoginPage();
        BasePage basePage = new BasePage(super.driver, log);
        loginPage.provideLogInCredentialsWithUsernameInput(basePage.getRegisteredUsernameJamesII(), basePage.getRegisteredPasswordJamesII());

        log.info("STEP 2. Then click on the navigation bar profile link to reach the profile page.");
        ProfilePage profilePage = new ProfilePage(super.driver, log);
        profilePage.clickOnNavBarProfileLink();

        log.info("STEP 3. To access the followed profile, the user went to the navigation search bar field and entered the profile username.");
        String typedText = loginPage.provideTextForNavBarSearchFieldAndRetrieveTheTxt(searchBarInputUserIvan);
        System.out.println("========>  " + "Typed text in the search bar: " + typedText + "  <========");
        Thread.sleep(4000);

        log.info("STEP 4. Review the visibility of the profile account, that the user is currently follow and click on it.");
        profilePage.clickOnTheDropdownSearchUserAccountIvan();

        log.info("STEP 5. Check the 'All' radio button with the all posts gallery on the followed profile page and click on the selected post.");
        profilePage.clickOnTheAllPostRadioButtonWithSelectedItem(1);

        log.info("STEP 6. Provide input for 'Comment here' post input field.");
        profilePage.provideTextForCommentFormInputField(postCommentInput);

        log.info("STEP 7. Verify the visibility for the post comment message and inspect the successful flow.");
        Assert.assertTrue(profilePage.isCommentMessageVisible());
    }

    @Test (priority = 5)
    public void verifyUserCanDeletePostFromAllPostsGalleryOnTheProfilePage() throws InterruptedException {

        ProfilePage profilePage = new ProfilePage(super.driver, log);

        log.info("STEP 1. The user is went to the login page, entered login credentials and landed on the Home page after successful login.");
        profilePage.navigateToLoginPageAndEnterUserIvanCredentials();
        Assert.assertTrue(profilePage.isURLLoaded("http://training.skillo-bg.com:4300/posts/all"));

        log.info("STEP 2. Then proceed with landing on the profile page after proper click on navigation bar profile link.");
        profilePage.clickOnNavBarProfileLink();

        log.info("STEP 3. Inspect the 'All' radio button with the all posts gallery on the followed profile page and click on the selected item.");
        profilePage.clickOnTheAllPostRadioButtonWithSelectedItem(1);

        log.info("STEP 4. Review the chosen image and inspect for visibility.");
        PostModal postModal = new PostModal(super.driver, log);
        Assert.assertTrue(postModal.isImageVisible());

        log.info("STEP 5. Check the created post title and date for the selected post, and retrieve the information.");
        profilePage.getTextFromTheCreatedPostTitle();
        profilePage.getTextFromTheCreatedPostDate();

        log.info("STEP 6. Verify, that the post delete button is visible.");
        Assert.assertTrue(profilePage.isThePostDeleteButtonPresented());

        log.info("STEP 7. Proceed with functional test on post delete button.");
        profilePage.clickOnTheDeletePostButton();

        log.info("STEP 8. Inspect the delete confirmation message and retrieve the text.");
        profilePage.getTextFromDeletePostConfirmation();

        log.info("STEP 9. Review the delete post confirmation button 'Yes', click on it and retrieve the text.");
        profilePage.clickOnTheDeleteConfirmationPostButtonYes();
        profilePage.getTextFromDeletePostConfirmYesButton();

        log.info("STEP 10. Check, whether the selected post from 'All' posts gallery is proper deleted and approve successful flow.");
        Assert.assertTrue(profilePage.isDeletedMessageVisible());
    }
}

