package gui.post;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.PostPage;
import com.dkk.pom.ProfilePage;
import gui.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;

public class PostErrorsTest extends BaseTest {

    private WebElement postStatusPrivateCheckbox;
    private WebElement postStatusPublicCheckbox;
    private WebElement createPostFormReturnButton;
    private static final String postStatusPrivateCheckboxBtn = "privateCheckboxSelected";
    private static final String postStatusPublicAndPrivateCheckboxBtns = "publicAndPrivateCheckboxesSelected";
    private static final String privateCheckboxNotProperSyntax = "public-status-label";
    private static final String privateCheckboxRevisedSyntax = "private-status-label";
    private static final String createPostReturnButton = "Return";
    private static final String captionForBeautyPic = "Spectacular scenery!";
    File uploadPostPicture = new File("src/test/resources/upload/pic3.jpg");
    File uploadBeautyPostPic = new File("src/test/resources/upload/pic2.jpg");

    @Test
    public void verifyUserUnableToCreatePrivatePostSinceThePrivateButtonCanNotBeSelected() throws InterruptedException {

        PostPage postPage = new PostPage(super.driver, log);

        log.info("STEP 1. The user is navigating to the login page, typing his credentials and landing on the Home page after successful login.");
        postPage.navigateToLoginPageAndEnterUserIvanCredentials();
        Assert.assertTrue(postPage.isURLLoaded("http://training.skillo-bg.com:4300/posts/all"));

        log.info("STEP 2. The user is landing on the new post page via click on navigation bar new post link.");
        postPage.clickOnNavBarNewPostLink();

        log.info("STEP 3. The user is uploading post picture.");
        postPage.uploadPictureForPost(uploadPostPicture);

        log.info("STEP 4. Check, whether the uploaded image is visible.");
        postPage.isImageVisible();

        log.info("STEP 5. Check the image and retrieve the name of the picture.");
        postPage.getImageName();

        log.info("STEP 6. The user is providing caption for the uploaded post picture.");
        postPage.providePostCaption("Basketballer dunking on a midair!");

        log.info("STEP 7. Check the entered post caption and retrieve the text.");
        postPage.getTextFromInputFormCaptionPlaceholder();

        log.info("STEP 8. Inspect, whether the post status private checkbox button is visible.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        postStatusPrivateCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Private']")));
        Thread.sleep(5000);

        log.info("STEP 9. Click on the private checkbox and verify, whether the button is selected.");
        postStatusPrivateCheckbox.click();
        Assert.assertTrue(postStatusPrivateCheckbox.isSelected());
    }

    @Test
    public void verifyThatPrivateAndPublicPostStatusCheckboxesAreNotDefinedProper() throws InterruptedException {

        PostPage postPage = new PostPage(super.driver, log);

        log.info("STEP 1. The user is on the login page, typing his credentials and landing on the Home page after successful login.");
        postPage.navigateToLoginPageAndEnterUserIvanCredentials();

        log.info("STEP 2. Then navigate to the new post page via click on navigation bar new post link.");
        postPage.clickOnNavBarNewPostLink();

        log.info("STEP 3. Inspect post status checkboxes and click on each sequently - approve, that they are radio buttons instead .");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        postStatusPublicCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Public']")));
        postStatusPrivateCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Private']")));
        postPage.doubleClickOnPostStatusCheckboxes();

        log.info("STEP 4. Verify, that there's no possibility post buttons to be selected at the same time, since checkboxes allow to choose items from a fixed number of alternatives, while radio buttons - exactly one item from a list.");
        Assert.assertEquals(postStatusPrivateCheckboxBtn, postStatusPublicAndPrivateCheckboxBtns);
    }

    @Test
    public void verifyMisleadingClassNameForPostStatusPrivateCheckboxSyntax() throws InterruptedException {

        PostPage postPage = new PostPage(super.driver, log);

        log.info("STEP 1. The user is on the login page, providing credentials and landing on the Home page after successful login.");
        postPage.navigateToLoginPageAndEnterUserIvanCredentials();

        log.info("STEP 2. Then navigating to the new post page after proper click on navigation bar new post link.");
        postPage.clickOnNavBarNewPostLink();

        log.info("STEP 3. Inspect private checkbox syntax and retrieve the class name, that suggests the element is related to a 'Public' status, yet the visible text shows 'Private'.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        postStatusPrivateCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("label.post-status-label.public-status-label")));
        Assert.assertTrue(postPage.isPresented(postStatusPrivateCheckbox));

        log.info("STEP 4. Verify the confusion for developers working on the code, that may also lead to functional errors, so the revised(expected) version is displayed.");
        Assert.assertEquals(privateCheckboxNotProperSyntax, privateCheckboxRevisedSyntax);
    }

    @Test
    public void verifyReturnButtonSyntaxAndProvideTxtForScreenReadersToKeepVisualConsistentForUI() throws InterruptedException {

        PostPage postPage = new PostPage(super.driver, log);

        log.info("STEP 1. The user is on the login page, credentials are provided and landed on the Home page after successful login.");
        postPage.navigateToLoginPageAndEnterUserIvanCredentials();

        log.info("STEP 2. The new post page is opened after proper click on navigation bar new post link.");
        postPage.clickOnNavBarNewPostLink();

        log.info("STEP 3. Verify return button, whether it is presented proper.");
        Assert.assertTrue(postPage.isReturnButtonPresented());

        log.info("STEP 4. Inspect retrieve 'create post button' text(visible for users), since buttons semantically correct should be visible and clickable for user actions.");
        postPage.getTextFromCreatePostButton();

        log.info("STEP 5. Then inspect 'return button' without any text, recognizes it exists (and can be used, if necessary) and display the actual and expected(revised) syntax.");
        String returnButtonTxt = postPage.getTextFromCreatePostReturnButton();
        Assert.assertEquals(returnButtonTxt, createPostReturnButton);
    }

    @Test
    public void verifyThatUserIsUnableToClickOnReturnButtonSinceItCanNotBeSelected() throws InterruptedException {

        PostPage postPage = new PostPage(super.driver, log);

        log.info("STEP 1. The user is on the login page, credentials are entered and landed on the Home page after successful login.");
        postPage.navigateToLoginPageAndEnterUserIvanCredentials();

        log.info("STEP 2. The new post page is opened after click on navigation bar new post link.");
        postPage.clickOnNavBarNewPostLink();

        log.info("STEP 3. Check return button and click on it.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        createPostFormReturnButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.return-btn")));
        createPostFormReturnButton.click();

        log.info("STEP 4. Verify, that the return button is selected.");
        Assert.assertTrue(createPostFormReturnButton.isSelected());

        log.info("STEP 5. Verify successful flow - returning to the Home page, if the previous condition is met.");
        Assert.assertTrue(postPage.isURLLoaded("http://training.skillo-bg.com:4300/posts/all"));
    }

    @Test
    public void verifyThatUploadedPostDoesNotMatchWithTheDisplayedCount() throws InterruptedException {

        PostPage postPage = new PostPage(super.driver, log);

        log.info("STEP 1. The user is on the login page, entered credentials and landed on the Home page after successful login.");
        postPage.navigateToLoginPageAndEnterUserIvanCredentials();

        log.info("STEP 2. The new post page is reached out via click on navigation bar new post link.");
        postPage.clickOnNavBarNewPostLink();

        log.info("STEP 3. Then proceeding with a functional check on the public status checkbox.");
        postPage.clickOnPostStatusPublicCheckbox();

        log.info("STEP 4. The user is uploading post picture (meanwhile the visibility of the uploaded image is verified), providing caption and creating a post.");
        postPage.createPostWithImageAndCaption(uploadBeautyPostPic, captionForBeautyPic);
        Thread.sleep(5000);

        log.info("STEP 5. Verify the total uploaded posts count.");
        int totalUploadedPosts = PostPage.getTotalPosts();
        System.out.println("Total uploaded posts: " + totalUploadedPosts);

        log.info("STEP 6. Inspect the displayed posts on the profile page and approve, that they do not match with the uploaded.");
        ProfilePage profilePage = new ProfilePage(super.driver, log);
        int displayedPostCount = profilePage.getDisplayedPostCountForUploadedPostWithoutAdaptation();
        System.out.println("Displayed post count: " + displayedPostCount);
        Assert.assertEquals(displayedPostCount, totalUploadedPosts, "Displayed posts do NOT match uploaded posts.");
    }
}
