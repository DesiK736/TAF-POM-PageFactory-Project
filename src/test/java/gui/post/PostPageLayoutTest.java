package gui.post;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.BasePage;
import com.dkk.pom.PostPage;
import com.dkk.pom.ProfilePage;
import gui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostPageLayoutTest extends BaseTest {

    private static final String followersName = "jamesClark1525012";

    @Test
    public void verifyPostPageLayoutWebElements() throws InterruptedException {

        PostPage postPage = new PostPage(super.driver, log);

        log.info("STEP 1. The user is on the login page, credentials are entered and landed on the Home page after successful login.");
        postPage.navigateToLoginPageAndEnterUserIvanCredentials();

        log.info("STEP 2. The new post page is opened after click on navigation bar new post link.");
        postPage.clickOnNavBarNewPostLink();
        Assert.assertTrue(postPage.isURLLoaded("http://training.skillo-bg.com:4300/posts/create"));

        log.info("STEP 3. Verify on post page - create post form, 'header' and retrieve the text.");
        postPage.getTextFromCreatePostFormHeader();

        log.info("STEP 4. Verify on post page - create post form, 'upload file label' and retrieve the text.");
        postPage.getTextFromCreatePostFormUploadFileLabel();

        log.info("STEP 5. Verify on post page - create post form, 'Browse' button label and retrieve the text.");
        postPage.getTextFromCreatePostFormBrowseButtonLabel();

        log.info("STEP 6. Verify on post page - create post input form, 'caption' label and retrieve the text.");
        postPage.getTextFromInputFormCaptionPlaceholder();

        log.info("STEP 7. Verify on post page - create post custom switch form, 'private checkbox' label and retrieve the text.");
        postPage.getTextFromPostStatusPrivateCheckboxLabel();

        log.info("STEP 8. Verify on post page - create post custom switch form, 'public checkbox' label and retrieve the text.");
        postPage.getTextFromPostStatusPublicCheckboxLabel();

        log.info("STEP 9. Verify on post page - create post custom switch form, 'Create post' button label and retrieve the text.");
        postPage.getTextFromPostStatusCreatePostButtonLabel();

        log.info("STEP 10. Inspect navigation bar profile link and make a functional check.");
        BasePage basePage = new BasePage(super.driver, log);
        basePage.isNavigationBarProfileLinkAccessibleAfterVisibilityAndFunctionalCheck();

        log.info("STEP 11. Check, if the user has 'followers' on the profile page and if it's true - retrieve the names.");
        ProfilePage profilePage = new ProfilePage(super.driver, log);
        String profileUserFollowers =profilePage.getPostUserNameFromTheFollowers();
        Assert.assertEquals(profileUserFollowers, followersName);
    }
}
