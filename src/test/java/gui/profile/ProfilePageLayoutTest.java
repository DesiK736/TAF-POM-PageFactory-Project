package gui.profile;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import com.dkk.pom.BasePage;
import com.dkk.pom.ProfilePage;
import gui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilePageLayoutTest extends BaseTest {

   @Test
   public void verifyProfilePageLayoutWebElements() throws InterruptedException {

      ProfilePage profilePage = new ProfilePage(super.driver, log);

      log.info("STEP 1. The user is navigating to the login page, typing his credentials and landing on the home page after successful login.");
      profilePage.navigateToLoginPageAndEnterUserIvanCredentials();
      Assert.assertTrue(profilePage.isURLLoaded("http://training.skillo-bg.com:4300/posts/all"));

      log.info("STEP 2. Verify, that the profile page is opened and the 'Iskillo' logo is presented.");
      profilePage.navigateToProfilePageUserIvan();
      BasePage basePage = new BasePage(super.driver, log);
      String logoIskillo = basePage.getNavigationBarIskilloLogo();
      System.out.println("========>  " + "Web site logo presented: " + logoIskillo + "  <========");

      log.info("STEP 3.1. Verify on profile page - profile section, 'profile user header' and retrieve the text.");
      profilePage.getTextFromProfileSectionUserHeader();

      log.info("STEP 3.2. Verify on profile page - profile section, 'posts' and retrieve the text.");
      profilePage.getTextFromProfileSectionPostsTxt();

      log.info("STEP 3.3. Verify on profile page - profile section, 'followers' and retrieve the text.");
      profilePage.getTextFromProfileSectionFollowersTxt();

      log.info("STEP 3.4. Verify on profile page - profile section, 'following' and retrieve the text.");
      profilePage.getTextFromProfileSectionFollowingTxt();

      log.info("STEP 3.5. Verify on profile page - profile section, 'username label' and retrieve the text.");
      profilePage.getTextFromProfileSectionUsername();

      log.info("STEP 4.1. Check profile page - profile posts section, radio button 'All' and retrieve the text.");
      profilePage.getTextFromProfilePostsSectionRadioBtnAll();

      log.info("STEP 4.2. Check  profile page - profile posts section, radio button 'Public' and retrieve the text.");
      profilePage.getTextFromProfilePostsSectionRadioBtnPublic();

      log.info("STEP 4.3. Check profile page - profile posts section, radio button 'Private' and retrieve the text.");
      profilePage.getTextFromProfilePostsSectionRadioBtnPrivate();

      log.info("STEP 4.4. Check profile page - profile posts section, new post link and retrieve the text.");
      profilePage.getTextFromProfilePostsSectionNewPostLink();

      log.info("STEP 5.1. The user is on the profile section, clicking on 'edit profile' button.");
      profilePage.clickOnProfileSectionEditProfileBtn();

      log.info("STEP 5.2. Check the 'edit profile modal form' and retrieve the text from the header.");
      profilePage.getTextFromEditProfileModalFormHeader();

      log.info("STEP 5.3. Check the 'edit profile modal form' and retrieve the text from the username label.");
      profilePage.getTextFromEditProfileModalFormUsernameLabel();

      log.info("STEP 5.4. Check the 'edit profile modal form' and retrieve the text from the email label.");
      profilePage.getTextFromEditProfileModalFormEmailLabel();

      log.info("STEP 5.5. Check the 'edit profile modal form' and retrieve the text from the password label.");
      profilePage.getTextFromEditProfileModalFormPasswordLabel();

      log.info("STEP 5.6. Check the 'edit profile modal form' and retrieve the text from the confirm password label.");
      profilePage.getTextFromEditProfileModalFormConfirmPasswordLabel();

      log.info("STEP 5.7. Check the 'edit profile modal form' and retrieve the text from the public info label.");
      profilePage.getTextFromEditProfileModalFormPublicInfoLabel();

      log.info("STEP 5.8. Check the 'edit profile modal form' and retrieve the text from the save button text.");
      profilePage.getTextFromEditProfileModalFormSaveBtnText();
   }
}
