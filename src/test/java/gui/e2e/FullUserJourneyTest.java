package gui.e2e;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.*;
import gui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.reg.data.RegistrationDataGenerator;
import java.io.File;

public class FullUserJourneyTest extends BaseTest {

    private static final String searchBarInputUserPeterPan = "PanPeter89";
    private static final String searchBarInputUserIvan = "ivanIvanov";
    private static final String postCommentInputForSelectedPost = "I dream of being there!";
    private static final String captionForFancyPic = "Dreaming is believing!";
    private static final String username = RegistrationDataGenerator.generateUniqueUsername();
    private static final String email = RegistrationDataGenerator.generateUniqueEmail();
    File uploadPrettyProfilePic = new File("src/test/resources/upload/pic2.jpg");
    File uploadFancyPostPic = new File("src/test/resources/upload/pic4.jpg");

    @Test
    public void verifyUserInteractionsWithTheIskilloFeatures()  throws InterruptedException {

        HomePage homePage = new HomePage(super.driver, log);

        log.info("STEP 1. Not logged in user has opened 'Iskillo' home page.");
        homePage.openHomePage();

        log.info("STEP 1.1.Verify the user is on the home page.");
        BasePage basePage = new BasePage(super.driver, log);
        Assert.assertTrue(basePage.isNavigationBarHomeLinkVisible());

        log.info("STEP 1.2. Verify, that the login link is presented and click on the navigation bar login link.");
        Assert.assertTrue(basePage.isNavigationBarLoginLinkLoadedAfterVisibilityAndFunctionalCheck());

        log.info("STEP 2. Approve, that the user is successfully on the login page.");
        LoginPage loginPage = new LoginPage(super.driver, log);
        String loginFormHeader = basePage.getLoginFormHeader();
        Assert.assertEquals(loginFormHeader,basePage.getLoginFormHeader());

        log.info("STEP 3. Verify login form web elements and get the text from 'Remember me' checkbox.");
        loginPage.getTextFromRememberMeCheckboxLabel();

        log.info("STEP 3.1. Verify login form web elements and get the text from 'Sign in' button.");
        loginPage.getTextFromLoginFormSignInButtonLabel();

        log.info("STEP 3.2. Verify login form web elements and get the text from 'Not a member?'.");
        loginPage.getTextFromLoginFormNotAMemberLabel();

        log.info("STEP 3.3. Verify login form 'Register' link, retrieve the text and click on it.");
        loginPage.getTextFromLoginFormRegisterLink();
        loginPage.clickOnLoginFormRegisterLink();

        log.info("STEP 4. Now let's expose the process of registration for the new user. Verify redirection to the registration page, done in the previous step action.");
        RegistrationPage registrationPage = new RegistrationPage(super.driver, log);
        Assert.assertTrue(registrationPage.isURLLoaded("http://training.skillo-bg.com:4300/users/register"));

        log.info("STEP 4.1. Verify, that the 'Iskillo' logo is shown on the registration page.");
        String logoIskillo = basePage.getNavigationBarIskilloLogo();
        System.out.println("========>  " + "Web site logo presented: " + logoIskillo + "  <========");

        log.info("STEP 4.2. Provide credentials for registration form input fields and click on 'Sign in' button.");
        registrationPage.registerNewUserWithDataGeneratorForUserAndEmailFields(username, email,"05/16/1963", "ultiMate1625", "ultiMate1625", "executive chairman");

        log.info("STEP 4.3. Verify successful registration result and contiue with logging out.");
        registrationPage.getAlertMsgFromSuccessRegistration();

        log.info("STEP 4.4. Inspect redirection to the home link after registration.");
        Assert.assertTrue(loginPage.isNavBarHomeLinkAfterLoginPresented());

        log.info("STEP 4.5. Review visibility for the first three new profile connections on the personal user home page.");
        Assert.assertTrue(homePage.isFirstSuggestForNewUsersConnectionPresented());
        Assert.assertTrue(homePage.isSecondSuggestForNewUsersConnectionPresented());
        Assert.assertTrue(homePage.isThirdSuggestForNewUsersConnectionPresented());

        log.info("STEP 4.6. Proceed with retrieving their names. Verify, that the 'log out' button is presented and make a functional check");
        homePage.getTextFromFirstConnectionSuggest();
        homePage.getTextFromSecondConnectionSuggest();
        homePage.getTextFromThirdConnectionSuggest();
        loginPage.clickOnNavBarLogOutButton();
        Thread.sleep(5000);

        log.info("STEP 5. Let then introduce login behaviour. Provide login credentials, click on 'Remember me' button and finally click on 'Sign in' button.");
        loginPage.provideLogInCredentialsWithUsernameInput(basePage.getRegisteredUsernameIvan(), basePage.getRegisteredPasswordIvan());

        log.info("STEP 5.1. Display the successful login flow.");
        loginPage.getAlertMsgFromSuccessLogin();

        log.info("STEP 5.2. Verify redirection to the home link page after successful login.");
        Assert.assertTrue(loginPage.isNavBarHomeLinkAfterLoginPresented());

        log.info("STEP 5.3. Inspect the navigation bar home link after proper login and click on it.");
        loginPage.clickOnNavBarHomeLinkAfterLogin();

        log.info("STEP 6. Verify redirection to the profile link after login with suitable visibility and functional checks.");
        Assert.assertTrue(basePage.isNavigationBarProfileLinkAccessibleAfterVisibilityAndFunctionalCheck());

        log.info("STEP 6.1. Review redirection to the new post link page after successful login with appropriate visibility and functional checks.");
        Assert.assertTrue(basePage.isNavigationBarNewPostLinkLoadedAfterVisibilityAndFunctionalCheck());

        log.info("STEP 7. Check 'Search' bar input field after successful login and provide relevant input.");
        Assert.assertTrue(loginPage.isLoginNavBarSearchBarInputFieldShown());
        loginPage.provideTextForNavBarSearchInputField("perfect");
        Thread.sleep(4000);

        log.info("STEP 8. The main test user profil proceed with the next activities: proper visibility and functional check on navigation bar profile link.");
        Assert.assertTrue(basePage.isNavigationBarProfileLinkAccessibleAfterVisibilityAndFunctionalCheck());

        log.info("STEP 9. Next, main point is to introduce the possibility of the user to upload a picture and set it as a profile image - verify the activity.");
        ProfilePage profilePage = new ProfilePage(super.driver, log);
        profilePage.uploadProfilePicture(uploadPrettyProfilePic);

        log.info("STEP 9.1. Review the uploaded profile picture and retrieve the text from the successful flow.");
        profilePage.getAlertMsgFromTheFlow();

        log.info("STEP 10. Then, we will display two more options - 'Follow' and 'Unfollow'. We will begin with the first one, so let's check 'Search' bar field and provide input with the desired profile username.");
        Assert.assertTrue(loginPage.isLoginNavBarSearchBarInputFieldShown());
        String typedText = loginPage.provideTextForNavBarSearchFieldAndRetrieveTheTxt(searchBarInputUserPeterPan);
        System.out.println("========>  " + "Typed text in the search bar: " + typedText + "  <========");
        profilePage.clickOnTheDropdownSearchUserAccountPeterPan();
        Thread.sleep(5000);

        log.info("STEP 10.1. Review the 'Follow' button and verify, that the user can follow the chosen profile.");
        profilePage.clickOnTheFollowButton();

        log.info("STEP 10.2. Get alert message from the successful flow and retrieve the text, approved that the user followed the desired profile.");
        profilePage.getAlertMsgFromTheFlow();
        Thread.sleep(5000);

        log.info("STEP 10.3. Let's move on to the next step - user can 'Unfollow' the same profile with another click on the 'Follow' button.");
        profilePage.clickOnTheUnfollowButton();

        log.info("STEP 10.4. Retrieve the successful message from the last click.");
        profilePage.getAlertMsgFromTheFlow();

        log.info("STEP 10.5. Verify, that the 'log out' button is presented and click on it.");
        Assert.assertTrue(loginPage.isNavBarLogOutButtonPresented());
        loginPage.clickOnNavBarLogOutButton();

        log.info("STEP 11. Up to now, we demonstrated that the user can 'Follow' and 'Unfollow' the profile, so let's proceed with 'like' and 'dislike' a post.");
        loginPage.provideLogInCredentialsWithUsernameInput(basePage.getRegisteredUsernameJamesII(), basePage.getRegisteredPasswordJamesII());

        log.info("STEP 11.1. The new registered user has navigated to the profile page, since beforehand entered his credentials.");
        profilePage.clickOnNavBarProfileLink();

        log.info("STEP 11.2. Went to the navigation 'Search' bar field and typed the profile username, that the user is followed.");
        String providedInput = loginPage.provideTextForNavBarSearchFieldAndRetrieveTheTxt(searchBarInputUserIvan);
        System.out.println("========>  " + "Typed text in the search bar: " + providedInput + "  <========");
        Thread.sleep(5000);

        log.info("STEP 11.3. Verify the visibility of the profile account, that the user is currently follow and click on it.");
        profilePage.clickOnTheDropdownSearchUserAccountIvan();

        log.info("STEP 11.4. Preview the 'All' radio button with the all posts gallery on the followed profile page and click on the selected image.");
        profilePage.clickOnTheAllPostRadioButtonWithSelectedItem(0);
        Thread.sleep(4000);

        log.info("STEP 11.5. Check the post info 'likes' count and retrieve the initial number, before likes action. Verify post like button and click on it.");
        profilePage.getTextFromPostInfoLikesCount();
        profilePage.clickOnThePostLikeButton();

        log.info("STEP 11.6. Check, whether the chosen post from 'All' posts gallery is proper liked and approve the result with updated number from the 'likes' action.");
        Assert.assertTrue(profilePage.isLikeMessageVisible());
        profilePage.getTextFromPostInfoLikesCount();
        Thread.sleep(5000);

        log.info("STEP 11.7. For as much as the post was liked successfully, we will proceed with 'dislike' state - preview post 'dislike' button and click on it.");
        profilePage.clickOnThePostDislikeButton();

        log.info("STEP 11.8. Check, whether the selected post from 'All' posts gallery is proper 'disliked' and get the updated number from the 'disliked' action.");
        Assert.assertTrue(profilePage.isDislikeMessageVisible());
        profilePage.getTextFromPostInfoLikesCount();
        Thread.sleep(5000);

        log.info("STEP 12. Now, let's move on to the next topic - leaving a comment under the post. Provide input for 'Comment here' post input field.");
        profilePage.provideTextForCommentFormInputField(postCommentInputForSelectedPost);

        log.info("STEP 12.1. Verify the visibility for the post comment message, inspect the successful flow and click on the 'log out' button.");
        Assert.assertTrue(profilePage.isCommentMessageVisible());
        profilePage.clickOnTheDropdownSearchUserAccount();
        loginPage.clickOnNavBarLogOutButton();
        Thread.sleep(5000);

        log.info("STEP 13. Next activity is to show the ability to delete a created post. So, the main registered user is navigating to the login page and entered credentials.");
        loginPage.provideLogInCredentialsWithEmailInput(loginPage.getRegisteredEmailIvan(), loginPage.getRegisteredPasswordIvan());
        Assert.assertTrue(profilePage.isURLLoaded("http://training.skillo-bg.com:4300/posts/all"));

        log.info("STEP 13.1. Then proceed with landing on the profile page after proper click on navigation bar profile link.");
        profilePage.clickOnNavBarProfileLink();
        Thread.sleep(5000);

        log.info("STEP 13.2. Inspect the 'All' radio button with the all posts gallery on the profile page and click on the selected item.");
        profilePage.clickOnTheAllPostRadioButtonWithSelectedItem(1);
        PostModal postModal = new PostModal(super.driver, log);
        Assert.assertTrue(postModal.isImageVisible());

        log.info("STEP 13.3. Check the created post title and date for the selected post, and retrieve the information.");
        profilePage.getTextFromTheCreatedPostTitle();
        profilePage.getTextFromTheCreatedPostDate();

        log.info("STEP 13.4. Verify, that the post delete button is visible and proceed with functional test.");
        Assert.assertTrue(profilePage.isThePostDeleteButtonPresented());
        profilePage.clickOnTheDeletePostButton();

        log.info("STEP 13.5. Inspect the delete post confirmation button 'Yes', click on it and retrieve the text.");
        profilePage.clickOnTheDeleteConfirmationPostButtonYes();
        profilePage.getTextFromDeletePostConfirmYesButton();

        log.info("STEP 13.6. Check, whether the selected post from 'All' posts gallery is proper deleted and approve successful flow.");
        Assert.assertTrue(profilePage.isDeletedMessageVisible());
        Thread.sleep(5000);

        log.info("STEP 14. Finally, we reached to the last action - post creation. In this regard, let's navigate to the new post link");
        PostPage postPage = new PostPage(super.driver, log);
        postPage.clickOnNavBarNewPostLink();

        log.info("STEP 14.1. Verify the visibility of the uploaded picture and caption, then retrieve the confirmation with image name taken.");
        postPage.createPostWithImageAndCaption(uploadFancyPostPic, captionForFancyPic);
        postPage.getImageName();

        log.info("STEP 14.2. Verify the total uploaded posts count.");
        int totalUploadedPosts = PostPage.getTotalPosts();
        System.out.println("Total uploaded posts: " + totalUploadedPosts);
    }
}
