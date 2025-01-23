package gui.profile;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.ProfilePage;
import gui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

public class ProfileNegativePathsTest extends BaseTest {

    private static final String SUCCESSFUL_UPLOAD_MSG = "Profile picture updated";
    private static final String FAILED_UPLOAD_MSG = "Not successful profile pic upload!";
    File uploadAwesomeProfilePic = new File("");

    @Test
    public void verifyUserCanNotUpdateProfilePictureIfTheFilePathnameIsNotProvided() throws InterruptedException {

        ProfilePage profilePage = new ProfilePage(super.driver, log);

        log.info("STEP 1. The user is navigating to the login page, typing his credentials and landing on the Home page after successful login.");
        profilePage.navigateToLoginPageAndEnterUserIvanCredentials();

        log.info("STEP 2. The user is landing on the profile page via click on navigation bar profile link.");
        profilePage.clickOnNavBarProfileLink();

        log.info("STEP 3. Try to upload profile picture and retrieve the message.");
        profilePage.uploadProfilePictureWithoutFileProviding(uploadAwesomeProfilePic);
        profilePage.getAlertMsgFromTheFlow();

        log.info("STEP 4. Check the upload profile picture unsuccessful flow and display the difference between actual, and expected behaviour.");
        Assert.assertEquals(FAILED_UPLOAD_MSG, SUCCESSFUL_UPLOAD_MSG);
    }
}
