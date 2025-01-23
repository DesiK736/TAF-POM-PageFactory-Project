package gui.post;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.PostPage;
import com.dkk.pom.ProfilePage;
import gui.base.BaseTest;
import org.testng.annotations.Test;
import java.io.File;
import java.util.List;

public class PostHappyPathsTest extends BaseTest {

    private static final String captionFirst = "Image to remember!";
    private static final String captionSecond = "Basketballer dunking on a midair!";
    private static final String captionThird = "<( * - * )>";
    File uploadFirstPostPicture = new File("src/test/resources/upload/pic1.jpg");
    File uploadSecondPostPicture = new File("src/test/resources/upload/pic3.jpg");
    File uploadThirdPostPicture = new File("src/test/resources/upload/pic4.jpg");

    @Test
    public void verifyUserPossibilityToCreatePublicPostWithCaption() throws InterruptedException {

        PostPage postPage = new PostPage(super.driver, log);

        log.info("STEP 1. The user is navigating to the login page, typing his credentials and landing on the Home page after successful login.");
        postPage.navigateToLoginPageAndEnterUserIvanCredentials();

        log.info("STEP 2. The user is landing on the new post page via click on navigation bar new post link.");
        postPage.clickOnNavBarNewPostLink();

        log.info("STEP 3. Make a functional check on the public status checkbox.");
        postPage.clickOnPostStatusPublicCheckbox();

        log.info("STEP 4. The user is uploading post picture, verifying visibility of the uploaded image, providing caption and create a post at the end.");
        postPage.createPostWithImageAndCaption(uploadFirstPostPicture, captionFirst);

        log.info("STEP 5. Inspect the created post and the displayed post count on the profile page.");
        ProfilePage profilePage = new ProfilePage(super.driver, log);
        int displayedPostCount = profilePage.getDisplayedPostCountForSingleUploadedPublicPost();
        System.out.println("Displayed post count: " + displayedPostCount);
    }

    @Test
    public void verifyUserPossibilityToCreateFewPrivatePostsWithCaption() throws InterruptedException {

        PostPage postPage = new PostPage(super.driver, log);

        log.info("STEP 1. The user is on the login page, typing his credentials and landing on the Home page after successful login.");
        postPage.navigateToLoginPageAndEnterUserIvanCredentials();

        log.info("STEP 2. The user is navigating to the new post page via click on navigation bar new post link.");
        postPage.clickOnNavBarNewPostLink();

        log.info("STEP 3. The user is uploading post picture.");
        postPage.uploadPictureForPost(uploadSecondPostPicture);

        log.info("STEP 4. Check, whether the uploaded image is visible.");
        postPage.isImageVisible();

        log.info("STEP 5. Retrieve the name of the uploaded picture.");
        postPage.getImageName();

        log.info("STEP 6. The user is providing caption for the uploaded post picture.");
        postPage.providePostCaption(captionSecond);

        log.info("STEP 7. Check the entered post caption and retrieve the text.");
        postPage.getTextFromInputFormCaptionPlaceholder();

        log.info("STEP 8. Verify, that the public checkbox is visible and clickable, and click on it in order the private button to be selected.");
        postPage.clickOnPostStatusPublicCheckbox();

        log.info("STEP 9. The user is clicking on the 'Create post' button.");
        postPage.clickOnCreatePostButton();
        Thread.sleep(5000);

        log.info("STEP 10. Navigate to the new post link for creating the second post.");
        postPage.clickOnNavBarNewPostLink();

        log.info("STEP 11. The user perform for second time: upload new post picture, provide caption, click on checkbox, post button and create a Private post.");
        postPage.createPostWithImageAndCaption(uploadThirdPostPicture, captionThird);

        log.info("STEP 12. Verify the total uploaded posts count.");
        int totalUploadedPosts = PostPage.getTotalPosts();
        System.out.println("Total uploaded posts: " + totalUploadedPosts);

        log.info("STEP 13. Print all uploaded posts and retrieve the relevant caption text on each picture.");
        List<String> allPosts = PostPage.getUploadedPosts();
        System.out.println("Uploaded posts: ");
        for (String post : allPosts) {
            System.out.println(post);
        }
    }
}
