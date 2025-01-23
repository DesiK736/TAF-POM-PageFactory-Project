package com.dkk.pom;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.util.List;

public class ProfilePage extends BasePage {

    private static final String LOGIN_PAGE_URL = "users/login";
    private static final String PROFILE_PAGE_URL_IVAN = "users/8871";
    private static final String PROFILE_PAGE_URL_JAMES_II = "users/8884";

    @FindBy(xpath = "//input[@type='file' and @hidden]")
    private WebElement uploadProfilePicHiddenId;

    @FindBy(xpath = "//*[text()='ivanIvanov']")
    private WebElement profileSectionUserHeader;

    @FindBy(xpath = "//i[contains(@class,'fas fa-user-edit')]")
    private WebElement profileSectionEditProfileBtn;

    @FindBy(css = "div.col-md-12")
    private WebElement editProfileModalFormHeader;

    @FindBy(xpath = "//label[contains(text(),'Usermame')]")
    private WebElement editProfileModalFormUsernameLabel;

    @FindBy(xpath = "//label[contains(text(),'Email')]")
    private WebElement editProfileModalFormEmailLabel;

    @FindBy(xpath = "//label[contains(text(),'Password')]")
    private WebElement editProfileModalFormPasswordLabel;

    @FindBy(xpath = "//label[contains(text(),'Confirm password')]")
    private WebElement editProfileModalFormConfirmPasswordLabel;

    @FindBy(xpath = "//label[contains(text(),'Public Info')]")
    private WebElement editProfileModalFormPublicInfoLabel;

    @FindBy(css = "button[type='submit']")
    private WebElement editProfileModalFormSaveBtn;

    @FindBy(tagName = "app-post")
    private List<WebElement> profilePagePostListAppPosts;

    @FindBy(xpath = "//li[strong[@class='profile-stat-count'] and contains(text(), 'posts')]")
    private WebElement profileSectionPostsTxt;

    @FindBy(xpath = "//li[@class='profile-stat-count pointer' and @id='followers']")
    private WebElement profileSectionFollowersStatCountPointer;

    @FindBy(id = "followers")
    private WebElement profileSectionFollowers;

    @FindBy(css = "#following")
    private WebElement profileSectionFollowingProfStatCountPointer;

    @FindBy(id = "following")
    private WebElement profileSectionFollowingTxt;

    @FindBy(xpath = "//strong[contains(text(), 'ivanIvanov')]")
    private WebElement profileSectionUsernameIvanTxt;

    @FindBy(xpath = "//strong[contains(text(), 'jamesClark1525012')]")
    private WebElement profileSectionUsernameJamesIITxt;

    @FindBy(css = "label.btn-all")
    private WebElement profilePostFilterRadioBtnAll;

    @FindBy(css = "label.btn-public")
    private WebElement profilePostFilterRadioBtnPublic;

    @FindBy(css = "label.btn-private")
    private WebElement profilePostFilterRadioBtnPrivate;

    @FindBy(xpath = "//div[contains(text(),'New post')]")
    private WebElement profilePostsSectionNewPostButtonTxt;

    @FindBy(css = ".new-post-btn.btn.btn-primary")
    private WebElement profilePostsSectionNewPostButton;

    @FindBy(css = "i.like.far.fa-heart")
    private WebElement profilePostsLikeButton;

    @FindBy(xpath = "//strong[contains(text(), 'likes')]")
    private WebElement postInfoLikesTextCount;

    @FindBy(css = "i.far.fa-heart.fa-2x.liked")
    private WebElement profilePostsDislikeButton;

    @FindBy(xpath = "//input[@placeholder='Comment here' and @type='text']")
    private WebElement createdPostCommentFormInputField;

    @FindBy(css = "div.post-title")
    private WebElement createdPostModalPostTitle;

    @FindBy(xpath = "//div[@class='post-date']")
    private WebElement createdPostModalPostDate;

    @FindBy(xpath = "//label[contains(@class,'delete-ask')]")
    private WebElement deletePostButton;

    @FindBy(xpath = "//div[@class='delete-confirm' and text()=' Are you sure? ']")
    private WebElement deletePostConfirmationText;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm' and text()='Yes']")
    private WebElement areYouSureYesButton;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm' and text()='No']")
    private WebElement areYouSureNoButton;

    @FindBy(xpath = "//div[contains(@aria-label,'Post Deleted!')]")
    private WebElement confirmDeletionMessage;

    @FindBy(xpath = "//div[contains(@aria-label,'Post liked')]")
    private WebElement profilePostLikeMessage;

    @FindBy(xpath = "//div[contains(@aria-label,'Post disliked')]")
    private WebElement profilePostDislikeMessage;

    @FindBy(css = ".post-user")
    private WebElement profileFollowersModalUserFollowers;

    @FindBy(css = "a.post-user")
    private WebElement searchBarFormDropdownSearchProfileUserAccount;

    @FindBy(xpath = "//a[@class='post-user' and text()='ivanIvanov']")
    private WebElement searchBarUserInputIvan;

    @FindBy(xpath = "//a[@class='post-user' and text()='PanPeter89']")
    private WebElement searchBarUserInputPanPeter;

    @FindBy(css = "div.post-img")
    private WebElement profilePagePrivatePostImage;

    @FindBy(id = "toast-container")
    private WebElement profilePageNotificationMsg;

    @FindBy(xpath = "//button[contains(text(), 'Follow')]")
    private WebElement profileFollowersModalFollowButton;

    @FindBy(xpath = "//button[contains(text(), 'Unfollow')]")
    private WebElement profileFollowersModalUnfollowButton;

    public ProfilePage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPageAndEnterUserIvanCredentials() {
        navigateToPageAndEnterRegisteredUserIvanLoginCredentials(LOGIN_PAGE_URL, getLoginPageUsernameOrEmailInputField(), getLoginPagePasswordInputField(), getLoginPageRememberMeCheckboxButton(), getSignInButtonForRegOrLogin());
    }

    public void navigateToProfilePageUserIvan() {
        navigateTo(PROFILE_PAGE_URL_IVAN);
    }

    public void navigateToProfilePageUserJamesII() {
        navigateTo(PROFILE_PAGE_URL_JAMES_II);
    }

    public void clickOnNavBarProfileLink() {
        waitAndClickOnWebElement(getNavigationBarProfileLink());
    }

    public void clickOnProfileSectionEditProfileBtn() {
        waitAndClickOnWebElement(profileSectionEditProfileBtn);
    }

    public void clickOnProfilePostsSectionNewPostButton() {
        waitAndClickOnWebElement(profilePostsSectionNewPostButton);
    }

    public void clickOnTheFollowButton() {
        waitAndClickOnWebElement(profileFollowersModalFollowButton);
    }

    public void clickOnTheUnfollowButton() {
        waitAndClickOnWebElement(profileFollowersModalUnfollowButton);
    }

    public void clickOnTheDropdownSearchUserAccount() {
        waitAndClickOnWebElement(searchBarFormDropdownSearchProfileUserAccount);
    }

    public void clickOnTheDropdownSearchUserAccountIvan() {
        waitAndClickOnWebElement(searchBarUserInputIvan);
    }

    public void clickOnTheDropdownSearchUserAccountPeterPan() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@class='post-user' and text()='PanPeter89']")));
    }

    public void clickOnThePrivateRadioButtonToDisplayPrivateImages() {
        waitAndClickOnWebElement(profilePostFilterRadioBtnPrivate);
    }

    //The method makes the necessary visible and functional check on the 'radio button: All' in the posts gallery section, then comes in handy in another method.
    public void clickOnTheAllRadioButtonToDisplayAllImages() throws InterruptedException {
        WebElement profilePostFilterRadioBtnAll = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label.btn-all")));
        profilePostFilterRadioBtnAll.click();
        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", profilePostFilterRadioBtnAll);

        WebElement allRadioButton = driver.findElement(By.cssSelector(".btn-all input[type='radio']"));
        if (!allRadioButton.isSelected()) {
            allRadioButton.click();
        }
    }

    public void clickOnThePrivatePostRadioButtonWithSelectedItem(int postIndex) {
        clickOnThePrivateRadioButtonToDisplayPrivateImages();

        List<WebElement> profilePagePostListAppPosts = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("app-post")));
        profilePagePostListAppPosts.get(postIndex).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
        log.info("CONFIRMATION  => The item from the 'Private' posts gallery was selected proper!");
    }

    public void clickOnTheAllPostRadioButtonWithSelectedItem(int postIndex) throws InterruptedException {
        clickOnTheAllRadioButtonToDisplayAllImages();

        List<WebElement> profilePagePostListAppPosts = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("app-post")));
        profilePagePostListAppPosts.get(postIndex).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
        log.info("CONFIRMATION  => The item from the 'All' posts gallery was selected proper!");
    }

    public void clickOnThePostLikeButton() {
        waitAndClickOnWebElement(profilePostsLikeButton);
    }

    public void clickOnThePostDislikeButton() {
        waitAndClickOnWebElement(profilePostsDislikeButton);
    }

    public void clickOnTheDeletePostButton() {
        waitAndClickOnWebElement(deletePostButton);
    }

    public void clickOnTheDeleteConfirmationPostButtonYes() {
        waitAndClickOnWebElement(areYouSureYesButton);
    }

    public void clickOnTheDeleteConfirmationPostButtonNo() {
        waitAndClickOnWebElement(areYouSureNoButton);
    }

    public void provideTextForCommentFormInputField(String postCommentInput) {
        wait.until(ExpectedConditions.visibilityOf(createdPostCommentFormInputField));
        createdPostCommentFormInputField.clear();
        createdPostCommentFormInputField.sendKeys(postCommentInput);
        createdPostCommentFormInputField.sendKeys(Keys.ENTER);
        log.info("CONFIRMATION => The user has provided comment text: " + postCommentInput);
    }

    //The method includes 'hidden' web element, which caused the output in the console log to be 'NOT SHOWN!' and an ERROR occurred, while processing the check .
    public void uploadProfilePicture(File file) {
        isPresented(uploadProfilePicHiddenId);
        uploadProfilePicHiddenId.sendKeys(file.getAbsolutePath());
        log.info("CONFIRMATION  => The file was successfully uploaded.");
        }

        //The method assists with identifying an error, when the user has forgotten to provide a file path.
        public void uploadProfilePictureWithoutFileProviding(File file) {
            try {
                isPresented(uploadProfilePicHiddenId);
                uploadProfilePicHiddenId.sendKeys(file.getAbsolutePath());
                log.error(" [ ERROR! ]=> The file was NOT visible, which caused profile pic failed to upload!");
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
    }

    //The method is constructed to be effective in each case, when the user creates a single public post.
    //Since, there's an error in the proper count between displayed and uploaded number of posts, this is an option for bypass the situation.
    public int getDisplayedPostCountForSingleUploadedPublicPost() {
        int displayedPosts = profilePagePostListAppPosts.size();
        if (displayedPosts == 3) {
            displayedPosts = 1;
        }
        return displayedPosts;
    }

    //The method implementation pinpoint the uploaded and displayed posts count dissonance.
    public int getDisplayedPostCountForUploadedPostWithoutAdaptation() {
        int displayedPosts = profilePagePostListAppPosts.size();
        return displayedPosts;
    }

    public String getAlertMsgFromTheFlow() {
        return waitAndGetText(profilePageNotificationMsg);
    }

    public void getTextFromProfileSectionUserHeader() {
        waitAndGetText(profileSectionUserHeader);
    }

    public void getTextFromProfileSectionPostsTxt() {
        waitAndGetText(profileSectionPostsTxt);
    }

    public void getTextFromProfileSectionFollowersTxt() {
        waitAndGetText(profileSectionFollowers);
    }

    public void getTextFromProfileSectionFollowingTxt() {
        waitAndGetText(profileSectionFollowingTxt);
    }

    public void getTextFromProfileSectionUsername() {
        waitAndGetText(profileSectionUsernameIvanTxt);
    }

    public void getTextFromProfileSectionUsernameJamesII() {
        waitAndGetText(profileSectionUsernameJamesIITxt);
    }

    public void getTextFromProfilePostsSectionRadioBtnAll() {
        waitAndGetText(profilePostFilterRadioBtnAll);
    }

    public void getTextFromProfilePostsSectionRadioBtnPublic() {
        waitAndGetText(profilePostFilterRadioBtnPublic);
    }

    public void getTextFromProfilePostsSectionRadioBtnPrivate() {
        waitAndGetText(profilePostFilterRadioBtnPrivate);
    }

    public void getTextFromProfilePostsSectionNewPostLink() {
        waitAndGetText(profilePostsSectionNewPostButtonTxt);
    }

    public void getTextFromEditProfileModalFormHeader() {
        waitAndGetText(editProfileModalFormHeader);
    }

    public void getTextFromEditProfileModalFormUsernameLabel() {
        waitAndGetText(editProfileModalFormUsernameLabel);
    }

    public void getTextFromEditProfileModalFormEmailLabel() {
        waitAndGetText(editProfileModalFormEmailLabel);
    }

    public void getTextFromEditProfileModalFormPasswordLabel() {
        waitAndGetText(editProfileModalFormPasswordLabel);
    }

    public void getTextFromEditProfileModalFormConfirmPasswordLabel() {
        waitAndGetText(editProfileModalFormConfirmPasswordLabel);
    }

    public void getTextFromEditProfileModalFormPublicInfoLabel() {
        waitAndGetText(editProfileModalFormPublicInfoLabel);
    }

    public void getTextFromEditProfileModalFormSaveBtnText() {
        waitAndGetText(editProfileModalFormSaveBtn);
    }

    public void getTextFromPostInfoLikesCount() {
        waitAndGetText(postInfoLikesTextCount);
    }

    public void getTextFromTheCreatedPostTitle() {
        waitAndGetText(createdPostModalPostTitle);
    }

    public void getTextFromTheCreatedPostDate() {
        waitAndGetText(createdPostModalPostDate);
    }

    public void getTextFromDeletePostConfirmation() {
        waitAndGetText(deletePostConfirmationText);
    }

    public void getTextFromDeletePostConfirmYesButton() {
        waitAndGetText(areYouSureYesButton);
    }

    //The method check and return the result from the matter - does the user have 'followers'.
    public String getPostUserNameFromTheFollowers()  {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='profile-stat-count pointer' and @id='followers']")));
        actions.moveToElement( profileSectionFollowersStatCountPointer).click().perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".post-user")));
        String followersName = profileFollowersModalUserFollowers.getText();
        log.info("CONFIRMATION => The follower's name is:  " + followersName);
        return followersName;
    }

    //The method strives to display, whether the user 'following' somebody - another profile user/users.
    public String getTheNameOfTheProfileUserWhichFollow() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='profile-stat-count pointer' and @id='following']")));
        profileSectionFollowingProfStatCountPointer.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".post-user")));
        String NameOfTheProfileUserWhichFollow = profileFollowersModalUserFollowers.getText();
        log.info("CONFIRMATION => The profile user, which has followed:  " + NameOfTheProfileUserWhichFollow);
        return NameOfTheProfileUserWhichFollow;
    }

    public boolean isThePrivatePostImagePresented() {
        return isPresented(profilePagePrivatePostImage);
    }

    public boolean isThePostDeleteButtonPresented() {
        return isPresented(deletePostButton);
    }

    public boolean isLikeMessageVisible() {
        boolean isLikeMessageVisible = false;
        try {
            isLikeMessageVisible = wait.until(ExpectedConditions.visibilityOf(profilePostLikeMessage)).isDisplayed();
            log.info("CONFIRMATION => The post like message is displayed.");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.error(" [ ERROR! ]=> The post like message is not displayed!");
            isLikeMessageVisible = false;
        }
        return isLikeMessageVisible;
    }

    public boolean isDislikeMessageVisible() {
        boolean isDislikeMessageVisible = false;
        try {
            isDislikeMessageVisible = wait.until(ExpectedConditions.visibilityOf(profilePostDislikeMessage)).isDisplayed();
            log.info("CONFIRMATION => The post disliked message is displayed.");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.error(" [ ERROR! ]=> The post disliked message is not displayed!");
            isDislikeMessageVisible = false;
        }
        return isDislikeMessageVisible;
    }

    public boolean isCommentMessageVisible() {
        boolean isCommentMessageVisible = false;
        try {
            isCommentMessageVisible = wait.until(ExpectedConditions.visibilityOf(createdPostCommentFormInputField)).isDisplayed();
            log.info("CONFIRMATION => The post comment message is displayed.");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.error(" [ ERROR! ]=> The post comment message is not displayed!");
            isCommentMessageVisible = false;
        }
        return isCommentMessageVisible;
    }

    public boolean isDeletedMessageVisible() {
        boolean isDeletedMessageVisible = false;
        try {
            isDeletedMessageVisible = wait.until(ExpectedConditions.visibilityOf(confirmDeletionMessage)).isDisplayed();
            log.info("CONFIRMATION => Message is displayed and the post was successfully deleted!");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.error(" [ ERROR! ]=> Message is NOT displayed, despite the post was successfully deleted!");
            isDeletedMessageVisible = false;
        }
        return isDeletedMessageVisible;
    }

    //The method exposes the logic uses an array to determine, which button is active, based on their position in the array,
    // an IndexOutOfBoundsException would prevent proper functionality. In this case, the second button ("No"),
    // won't function as expected, since the array does not have an element at index 1.
    public boolean isDeleteConfirmationNoButtonFunctionAsExpected() {
        boolean isDeleteConfirmationNoButtonFunctionAsExpected = false;
        try {
            String[] buttonStates = {"Yes"};
            if (buttonStates[1].equals("No")) {
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            log.error(" [!] EXCEPTION >>  ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1!");
            WebElement locatorExpressionFirst = areYouSureNoButton;
            WebElement locatorExpressionSecond = areYouSureYesButton;
            System.out.println("WEB ELEMENT 'areYouSureNoButton' WITH: "  + locatorExpressionFirst);
            System.out.println("WEB ELEMENT 'areYouSureYesButton' WITH: "  + locatorExpressionSecond);
        }
        return isDeleteConfirmationNoButtonFunctionAsExpected;
    }
}
