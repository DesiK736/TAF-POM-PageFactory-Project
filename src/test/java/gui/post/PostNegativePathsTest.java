package gui.post;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.PostPage;
import gui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

public class PostNegativePathsTest extends BaseTest {

    File uploadFirstPostPicture = new File("");

    @Test
    public void verifyUserImpossibilityToCreatePostWithoutProvidingThePicture() throws InterruptedException {

        PostPage postPage = new PostPage(super.driver, log);

        log.info("STEP 1. The user is on the login page, credentials are provided and landed on the Home page after successful login.");
        postPage.navigateToLoginPageAndEnterUserIvanCredentials();

        log.info("STEP 2. The new post page is opened after proper click on navigation bar new post link.");
        postPage.clickOnNavBarNewPostLink();

        log.info("STEP 3. Check the uploading post picture activity.");
        postPage.uploadPictureForPostWithoutFileProviding(uploadFirstPostPicture);

        log.info("STEP 4. Verify create post state and retrieve the unsuccessful flow message, since the file was not provided.");
        postPage.getAlertMsgFromPostCreation();

        log.info("STEP 5. Review the picture upload visibility and display the result.");
        Assert.assertTrue(postPage.isThePictureUploadActionPresented());
    }
}
