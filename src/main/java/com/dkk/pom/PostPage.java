package com.dkk.pom;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PostPage extends BasePage {
    private static final String LOGIN_PAGE_URL = "users/login";
    private static final List<String> uploadedPosts = new ArrayList<>();

    @FindBy(tagName = "h3")
    private WebElement createPostFormHeader;

    @FindBy(xpath = "//label[contains(text(),'Drop an Image here')]")
    private WebElement createPostFormUploadFileLabel;

    @FindBy(css = "img.image-preview")
    private WebElement createPostImage;

    @FindBy(css = "input.input-lg")
    private WebElement createPostImageText;

    @FindBy(css = ".file[type='file']")
    private WebElement newPostUploadPictureField;

    @FindBy(id = "choose-file")
    private WebElement uploadPictureBrowseButton;

    @FindBy(name = "caption")
    private WebElement captionInputField;

    @FindBy(xpath = "//input[@name='caption' and @placeholder='Enter you post caption here']")
    private WebElement inputFormCaptionPlaceholder;

    @FindBy(xpath = "//label[text()='Private']")
    private WebElement postStatusPrivateCheckbox;

    @FindBy(xpath = "//label[text()='Public']")
    private WebElement postStatusPublicCheckbox;

    @FindBy(id = "create-post")
    private WebElement createPostButton;

    @FindBy(css = "div.return-btn")
    private WebElement createPostFormReturnButton;

    @FindBy(css = ".toast-message")
    private WebElement postPageCreatePostNotificationMsg;

    public PostPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPageAndEnterUserIvanCredentials() {
        navigateToPageAndEnterRegisteredUserIvanLoginCredentials(LOGIN_PAGE_URL, getLoginPageUsernameOrEmailInputField(), getLoginPagePasswordInputField(), getLoginPageRememberMeCheckboxButton(), getSignInButtonForRegOrLogin());
    }

    public void clickOnNavBarNewPostLink() {
        waitAndClickOnWebElement(getNavigationBarNewPostLink());
    }

    public void clickOnPostStatusPublicCheckbox() {
        waitAndClickOnWebElement(postStatusPublicCheckbox);
    }

    public void clickOnCreatePostButton() {
        wait.until(ExpectedConditions.visibilityOf(createPostButton));
        createPostButton.click();
        log.info("CONFIRMATION => The user has clicked on the 'Create post' button.");
    }

    public String getImageName() {
        String imageName = createPostImageText.getAttribute("placeholder");
        log.info("CONFIRMATION => The image name is: " + imageName);
        return imageName;
    }

    //The method is useful, whenever some additional activity should be executed afterward. This helps the variety of visions to be pointed out.
    public void uploadPictureForPost(File file) {
        newPostUploadPictureField.sendKeys(file.getAbsolutePath());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".file[type='file"))).isDisplayed();
        log.info("CONFIRMATION => The file was successfully uploaded.");
    }

    //The method identify an error, when the user has forgotten to provide a file for the post.
    public void uploadPictureForPostWithoutFileProviding(File file) {
        try {
            newPostUploadPictureField.sendKeys(file.getAbsolutePath());
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".file[type='file"))).isDisplayed();
            log.error(" [ ERROR! ]=> The file was NOT presented, which caused post failed to upload!");
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    //The method is proven in cases, where we can include any state beforehand, indicating the whole activity to be properly displayed.
    public void providePostCaption(String captionTxt) {
        wait.until(ExpectedConditions.visibilityOf(captionInputField));
        captionInputField.sendKeys(captionTxt);
        uploadedPosts.add("Caption text: " + captionTxt  + ", with uploaded picture.");
        log.info("CONFIRMATION => The user has provided caption text: " + captionTxt);
    }

    public static List<String> getUploadedPosts() {
        return new ArrayList<>(uploadedPosts);
    }

    public static int getTotalPosts() {
        return uploadedPosts.size();
    }

    //The method aims to expose combined approach with all gathered checks in addition successfully post creation.
    public void createPostWithImageAndCaption(File file, String captionTxt)  {
        newPostUploadPictureField.sendKeys(file.getAbsolutePath());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".file[type='file"))).isDisplayed();
        log.info("CONFIRMATION => The file was successfully uploaded!");

        wait.until(ExpectedConditions.visibilityOf(captionInputField));
        captionInputField.sendKeys(captionTxt);
        uploadedPosts.add("Caption text: " + captionTxt  + ", with uploaded picture.");
        log.info("CONFIRMATION => The user has provided the following caption text: " + captionTxt);
        doubleClickOnPostStatusCheckboxes();
        createPostButton.click();
    }

    //The method contributes in cases, where adaptability is needed in order private or public post/posts to be created.
    public void doubleClickOnPostStatusCheckboxes() {
        Actions actions = new Actions(driver);
        actions.click(postStatusPrivateCheckbox).perform();
        actions.click(postStatusPublicCheckbox).perform();
    }

    public void getTextFromCreatePostFormHeader() {
        waitAndGetText(createPostFormHeader);
    }

    public void getTextFromCreatePostFormUploadFileLabel() {
        waitAndGetText(createPostFormUploadFileLabel);
    }

    public void getTextFromCreatePostFormBrowseButtonLabel() {
        waitAndGetText(uploadPictureBrowseButton);
    }

    public void getTextFromCreatePostButton() {
        waitAndGetText(createPostButton);
    }

    public String getTextFromCreatePostReturnButton() {
        return waitAndGetText(createPostFormReturnButton);
    }

    public void getTextFromInputFormCaptionPlaceholder() {
        waitAndGetValue(inputFormCaptionPlaceholder);
    }

    public void getTextFromPostStatusPrivateCheckboxLabel() {
        waitAndGetText(postStatusPrivateCheckbox);
    }

    public void getTextFromPostStatusPublicCheckboxLabel() {
        waitAndGetText(postStatusPublicCheckbox);
    }

    public void getTextFromPostStatusCreatePostButtonLabel() {
        waitAndGetText(createPostButton);
    }

    public void getAlertMsgFromPostCreation() {
        waitAndGetText(postPageCreatePostNotificationMsg);
    }

    public boolean isReturnButtonPresented() {
        return isPresented(createPostFormReturnButton);
    }

    public boolean isThePictureUploadActionPresented() {
        return isPresented(newPostUploadPictureField);
    }

    public boolean isImageVisible() {
        boolean isVisible = false;
        try {
            isVisible = wait.until(ExpectedConditions.visibilityOf(createPostImage)).isDisplayed();
            log.info("CONFIRMATION => The file is visible.");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.error(" [ ERROR! ]=> The file is not visible.");
            isVisible = false;
        }
        return isVisible;
    }
}
