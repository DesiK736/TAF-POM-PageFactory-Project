
## <div align="center">"TAF POM PageFactory" Project</div>

#### <div align="center">~ A marvelous opportunity for automating 'Iskillo' website! ~</div>

###### <div align="center"> [![forthebadge](custom-badge.svg)](https://forthebadge.com)
</div>
---------------------------------------------------------------------------------------------------------------------------------------------
<a id="readme-top"></a>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ul>
    <li>
      <a href="#i-about-the-project">I. ABOUT THE PROJECT</a>
    </li>
    <li>
      <a href="#ii-getting-started">II. GETTING STARTED</a>
      <ul>
        <li><a href="#1-prerequisites">1. Prerequisites</a></li>
        <li><a href="#2-installation-steps">2. Installation Steps</a></li>
        <li><a href="#3-languages-and-frameworks">3. Languages and Frameworks</a></li>
      </ul>
    </li>
    <li>
      <a href="#iii-basic-usage">III. BASIC USAGE</a>
      <ul>
        <li><a href="#1-general-project-structure">1. General Project Structure</a></li>
        <li><a href="#2-additional-folders-in-the-main-directory">2. Additional Folders in the 'main' Directory</a></li>
      </ul>
    </li>
    <li>
      <a href="#iv-embedded-test-activities">IV. EMBEDDED TEST ACTIVITIES</a>
      <ul>
        <li><a href="#1-list-of-the-test-cases">1. List of the Test Cases</a></li>
        <li><a href="#2-test-resources-folders">2. Test Resources Folders</a></li>
      </ul>
    </li>
    <li>
      <a href="#v-running-automation-test-suite">V. RUNNING AUTOMATION TEST SUITE</a>
    </li>
    <li>
      <a href="#vi-bug-report">VI. BUG REPORT</a>
    </li>
    <li>
      <a href="#vii-contact">VII. CONTACT</a>
    </li>
  </ul>
</details>

<!-- ABOUT THE PROJECT -->
## I. ABOUT THE PROJECT


The main topic for the project is to expose the abundance of opportunities, which proposes Java automation testing, based on TestNG framework with Selenium WebDriver.  
In this regard, the core of our study is a well-known website 'Iskillo' with particular link: [</Iskillo website>](http://training.skillo-bg.com:4300/posts/all). <br>

The mentioned site is a social web, that provides set of social relations and links people through the World Wide Web. <br> By presumption, the social web encompasses how websites and software are designed, and developed in order to support and foster social interaction.
Thereby, people can connect with others in the same area, families, friends, and those with the same interests. <br> 

Social networks are one of the most important values of the internet today. This leads us to look at the 'Iskillo' site.
Herein, users can upload and update profile picture, create a posts, accept suggestions for new connections and make a variety of acquaintances, leave a comments under the followers post, etc. <br> 
There is significant condition in a manner the user can access to the indicated actions - and it actually is to be active member of the website or namely registered user.
If the authentication is correct and the profile account is created without a hitch, thus will allow the user to interact with all the possible and valid options, which the site provides.

Since the whole process should be smoothly assured, without any interfering events, quality assurance specialists have to be properly involved.


<!-- GETTING STARTED -->
### II. GETTING STARTED



- [ ] _For the project's requisites, these instructions will give you a copy of the project up and running on your local machine for development and testing purposes._

#### **1. <u>Prerequisites**</u>

* Oracle JDK Development Kit, 23.0.1
* TestNG, Version 7.10.2
* Selenium, Version 4.25.0
* Apache Log4j, Version 2.11.1
* Commons.io, Version 2.16.1
* Apache Maven compiler plugin, Version 3.8.1
* Apache Maven surefire plugin, Version 3.0.0-M7

#### **2. <u>Installation steps**</u>

- [ ] _In order to access the automation framework project, please adhere to the following tips._  


 - 1.Clone the repository:
   * navigate to the green button 'Code' on your local machine, beforehand you should found my personal GitHub account, through any of the following ways:
     * look for the account in the 'Search' bar field:  `@DesiK736` and click on the `DesiK736/TAF-POM-PageFactory-Project`;
     * copy shared URL account below and open the link with one of the most convenient browsers for you:
     ```sh
     https://github.com/DesiK736/TAF-POM-PageFactory-Project.git
     ```
     * or the fastest mode - just click here: [Quick access to my GitHub repo!](https://github.com/DesiK736/TAF-POM-PageFactory-Project.git)

- 2.Clone HTTPS, using the web URL with the quick button option 'Copy url to clipboard'.  


- 3.Import the project in IntelliJ IDEA:
  * go to 'Get from Version Control';
  * paste the selected url link in the 'URL:' field;
  * find appropriate directory for the selected file;
  * click on the 'Clone' button;  

  
#### **3. <u>Languages and Frameworks**</u>

_🛠_  _The project is based on the following software requirements and tools for testing:_

* Java 23 as the programming language.
* Selenium WebDriver as the web browser automation framework using the Java binding.
* TestNG as the testing framework.
* Maven central repository procured each appropriate dependency or library resource, required for the project.
* Maven archetype as the project generator.
* IntelliJ IDEA Community Edition, Version 23 as the IDE.

<!-- BASIC USAGE -->
### III. BASIC USAGE

 #### **1. <u>General Project Structure** </u>

The one under consideration website 'Iskillo' includes the following main features:  

- [ ] Home Page;
- [ ] Registration Page;
- [ ] Login Page;
- [ ] Profile Page;
- [ ] Post Page.

There are two additional distinguished pages, which support testing in a more detailed manner:
- [ ] Base Page;
- [ ] Post Modal Page.

In order to clarify the testing framework basics, will expose more information about the structure of the process, which the tests are conducted.

> Project Files are divided into two basic parts - first one is the 'main' directory and the second one is the 'test' section.
On the 'main' package are concentrated page object models. With respect to the whole logic, related to the tests, here are placed already mentioned web features. 
The main idea is the code to be separated from the functional part of the project. This contributes for better code structure and consistency.
>
> When we look for how relevant object behave, what are the range of its states, how can unleash its full potential etc., we can reach out to the 'main' subfolders.
Here, we can find the important traits, that each object has properly built. Navigate further to the subfolder 'pom', the package is concerned for the logic of the tests. 
Because the key desire is the test's logic to be excluded from the test classes' visibility.
>
> Pom includes all the relevant website features, separated into classes - like Base Page class, Login Page class, etc. There are three main points for each page - locate the web element with proper locator strategy (Selenium core role), 
whether the element is suitable to work with (visibility check) and how the variables on each feature talk to each other (interaction or functional check).  
Development model, that either page architecture follows, is defined as per the pattern:
> - declared constants;
> - UI mapping;
> - constructor implementation;
> - navigation methods;
> - providing inputs or user actions (methods);
> - and last, but not the least of importance, is support methods section (boolean methods, methods retrieving information etc.).  

<p align="right">(<a href="#readme-top">back to top</a>)</p>

#### **2. <u>Additional Folders in the 'main' directory**</u>

- [ ] _In a relation, the whole project to be meaningful and well understood, please refer to the additional folders in the 'main' directory! The benefit will be explained subsequently._  

* 'utils';
* 'resources'.

> In the 'main' directory exists utility folder - 'utils', which archive useful data generator techniques for registration purpose. 
Shortly, the whole user registration process is easier, since it provides generated data for certain variables or input fields.
>
> Logging is an essential component of any good software development process. That’s exactly where log4J2.xml come in handy. It exists in the 'resources' folder.
In this regard, we’re going to talk about one such framework, log4j2, in the context of a Maven project.
Through logging, you can detect and fix issues, understand the behavior of your users, and even obtain valuable business insights.
Log4j is used by quality assurance specialists and developers to keep track of what happens in their software applications or online services. 
It's basically a huge journal of the activity of a system or application.  
Log4j2 supports configuration through XML, JSON, YAML, and configuration files. There is an active community support as well.  
In order to the whole log4J2 shared information, we can clarify, that in the related xml file, we can find the layout pattern for console log, that displays on the terminal after test execution.

> Now, let’s delve a little further with the 'pom' package classes.
Regarding the Base Page, herein exists all the needed methods, which are applicable to all the pages, whenever they are called.
The page is consists of the reusable web elements, that provides a common base and shared behaviour for related classes.
The base logic is inherited from the parent class (Base Page), due to keyword 'extends'. Thus prompt the implementation of the already defined methods.
>
> Polymorphism allows for more flexible and adaptable code. It promotes code reuse, simplification, and flexibility, making it an essential component of Object-Oriented Programming.
Another irreplaceable benefit is encapsulation of the variables, which are precisely located on the website by means of the big variety of locator strategies.
With encapsulation implementation, we are using access modifiers, which control the visibility of web elements and methods within a class.
It also protects the data from unauthorized access and manipulation.
>
> Regarding the Home Page, here exists all the variables and methods, related to the home feature.
Due to the Registration Page, it includes the registration behaviour related feature.
The Login Page is the next one - it consist of the web elements and states, engaged with the login feature.
Regarding the Profile Page, here is placed the main profile feature concept - variables and methods, which helps better knowledge of the user behaviour - his personal area with posts, comments, connections.
The Post Page is another useful class, which forms the core of the post feature.
And the last feature is the Post Modal - supports the Post Page feature and can be used as same as the 'iframe' works.  
By reviewing listed features, please keep in mind, that Home Page, Registration Page and Login Page are accessible before user authentication, whilst for the rest of the pages - Profile Page and Post Page, registration is needful.

> Whenever we need the accurate result from the certain object, we should turn to the 'test' package, where we can find all up and running tests.
Since, here is located the whole research and the outcome from it, for instance, how an object functions and interact with other objects.
By following this approach, it is easier to write and maintain the code.
>
> For as much as the project is based on the website research, 'gui' package is specialized for graphical user interface manner.
Naturally, the verification for each object is presented separately - for each feature different class is isolated.
In this regard, our focus is concentrated on the 'login', 'post', 'profile' and 'registration' pages. According to that, testing framework has been constructed. 
Furthermore, there are two more components, that gives an additional value to the project - 'base' and 'e2e'.
Since the introduced four pages are related with the core website features, let explain the function for the added units.

> Due to the 'base' package, here is the main toolkit configured, like browser initialization (browser driver factory), driver set up, log manager, waiting strategy for web elements, page load timeout, etc.
All the common test actions and useful parameters, tuned with annotations (BeforeSuite, AfterSuite, BeforeMethod, AfterMethod), provide the smoothly test execution.
>
> To visualize major website features interaction, a holistic approach is involved or the so-called 'e2e' scenario. 
Thus, demonstrates single execution of test or how the user interact with each page, for example, how does the registration process work, then how login action goes, create a post, etc.
>
> Aside from 'gui' directory, there is prominent unit, called 'resources'. Herein are placed following folders: download, reports, screenshots and upload. 
They support the main activities, for example, whenever any reports is generated or file is downloaded, we can find the relevant output here.
> 
> Bear in mind and to draw attention to the fact as well, that 'Thread.sleep()' method is used in particular cases to pause the execution of the current thread for a specified time in milliseconds. 
Regardless the Selenium Wait (implicit wait and page load timeout) was implemented, the 'Thread.sleep' was also engaged.
Adhered to the recommendation, that it's not a good practice in the production environment.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### IV. EMBEDDED TEST ACTIVITIES

#### **1. <u>List of the Test Cases** </u>

Considering presented structure of the project, let introduce the core of our study - test activities. Below are defined all the test cases, which are accurately implemented. They are divided into features.  
The test methodology, that has been built, follows the principle of:

- [ ] catch bug - includes Registration Errors Test, Login Errors Test, Post Errors Test, Profile Errors Test.;
- [ ] introduce happy path - includes Registration Happy Paths Test, Login Happy Paths Test, Post Happy Paths Test, Profile Happy Paths Test.; 
- [ ] display negative path (deviation from the regular flow) - includes Registration Negative Paths Test, Login Negative Paths Test, Post Negative Paths Test, Profile Negative Paths Test;
- [ ] and provide page layout variables - includes Registration Page Layout Test, Login Page Layout Test, Post Page Layout Test, Profile Page Layout Test.   


* <u>Registration feature</u>
  * Registration Errors Test - composed of:
    * verifyUserRegistrationDeniedWithValidUsernameInput;
    * verifyUserRegistrationWithAlreadyRegisteredPasswordFromAnotherUser;
    * verifyRegistrationFailedWithCyrillicAndEnglishSymbolsForUserWithoutInvalidFeedback;
    * verifyUserRegistrationFailedWithoutInvalidFeedbackForNotMetEmailRequirement;
    * verifyRegistrationFormSignInButtonIsDisabled;
    * verifyRegistrationFormSignInButtonSyntaxIsNotCorrectDefinedAndCanMisleadTheUser;
    * verifyRegistrationFormEmailFieldNameDistinguishesFromTheRestOfTheFields;
    * verifyRegistrationSuccessWithNonRealisticUserDateOfBirth;
    * verifyRegistrationConfirmPasswordIdSyntaxIsNotConsistentWithThePrimaryPasswordId;
    
  * Registration Happy Paths Test - composed of:
    * verifyUserRegistrationWithValidCredentialsManualProvided;
    * verifyUserRegistrationWithValidCredentialsAutomaticallyProvidedForUserAndEmailFields;
    
  * Registration Negative Paths Test - composed of:
    * verifyUserRegistrationFailedInCaseThePasswordsDoNotMatch;
    * verifyUserRegistrationFailedForEmailThatHaveAlreadyBeenTaken;
    
  * Registration Page Layout Test - composed of:
    * verifyRegistrationPageLayoutWebElements; 


* <u>Login feature</u>
  * Login Errors Test - composed of:
    * verifyUserUnableToLockTheAccountWithInfiniteWrongPassTry;
    * verifyUserCanAccessPrivateProfileAccountWithSimilarUserAndSamePassInputs;
    
  * Login Happy Paths Test - composed of:
    * verifyRegisteredUserLoginWithValidUsernameAndPassword;
    * verifyRegisteredUserLoginWithValidEmailAndPassword;
    
  * Login Negative Paths Test - composed of:
    * verifyRegisteredUserUnableToLoginWithInvalidPassword;
    * verifyRegisteredUserUnableToLoginWithInvalidUsername;
    
  * Login Page Layout Test - composed of:
    * verifyLoginPageLayoutWebElements; 


* <u>Post feature</u>
  * Post Errors Test - composed of:
    * verifyUserUnableToCreatePrivatePostSinceThePrivateButtonCanNotBeSelected;
    * verifyThatPrivateAndPublicPostStatusCheckboxesAreNotDefinedProper;
    * verifyMisleadingClassNameForPostStatusPrivateCheckboxSyntax;
    * verifyReturnButtonSyntaxAndProvideTxtForScreenReadersToKeepVisualConsistentForUI;
    * verifyThatUserIsUnableToClickOnReturnButtonSinceItCanNotBeSelected;
    * verifyThatUploadedPostDoesNotMatchWithTheDisplayedCount;
    
  * Post Happy Paths Test - composed of:
    * verifyUserPossibilityToCreatePublicPostWithCaption;
    * verifyUserPossibilityToCreateFewPrivatePostsWithCaption;
    
  * Post Negative Paths Test - composed of:
    * verifyUserImpossibilityToCreatePostWithoutProvidingThePicture;
    
  * Post Page Layout Test - composed of:
    * verifyPostPageLayoutWebElements; 


* <u>Profile feature</u>
  * Profile Errors Test - composed of:
    * verifyUserCanNotRedirectToTheNewPostPageAfterClickOnTheNewPostButton;
    * verifyThatPrivatePostCanBeVisibleAndAccessibleForAnotherUserWhoFollowsTheProfile;
    * verifyUserCanLikePrivatePostOnFollowedProfileAccount;
    * verifyUserCanDislikePrivatePostOnFollowedProfileAccount;
    * verifyUserCanNotSelectDeletePostConfirmButtonNoOnTheChosenItem;
    
  * Profile Happy Paths Test - composed of:
    * verifyUserAbilityToUploadAndUpdateProfilePicture;
    * verifyUserAbilityToFollowAndUnfollowAnotherProfileUser;
    * verifyUserCanLikePostFromAllPostsGalleryOnTheFollowedProfileAccount;
    * verifyUserCanDislikePostFromAllPostsGalleryOnTheFollowedProfileAccount;
    * verifyUserCanLeaveACommentOnPostFromAllPostsGalleryOnTheFollowedProfileAccount;
    * verifyUserCanDeletePostFromAllPostsGalleryOnTheProfilePage;
    
  * Profile Negative Paths Test - composed of:
    * verifyUserCanNotUpdateProfilePictureIfTheFilePathnameIsNotProvided;
    
  * Profile Page Layout Test - composed of:
    * verifyProfilePageLayoutWebElements;   


* <u>End to end scenario</u>
  * Full User Journey Test - composed of: 
    * verifyUserInteractionsWithTheIskilloFeatures or 'Registration - Login - Profile - Post' single test.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

#### **2. <u>Test Resources Folders**</u>

- [ ] _Verify 'resources' folder path for comprehensive project vision._

In order, the 'resources' package to be found, the Windows OS users should navigate to the following path: src/test/resources folder and verify presenting of:
* a folder with name "download";
* a folder with name "reports";
* a folder with name "screenshots";
* a folder with name "upload".

In case the folders are not found, when you build the project, you can find the folders, created by the automation script here: src/test/java/gui.


<!-- RUNNING AUTOMATION TEST SUITE -->
### V. RUNNING AUTOMATION TEST SUITE  

Bear in mind, that 'TestNG' xml file has been generated, before starting report's activity, in order each test to be accurately retrieved and presented.  
Aside from that, the 'testng.xml' file exists after 'pom.xml' placement.  

There is some essential course in generating test suite report, shared further. So stick to the best approach.

- STEP 1: Go to the Maven icon (marked with 'm'), placed on the right IntelliJ's section, and navigate to the Lifecycle.
- STEP 2: Run: clean.
- STEP 3: When it completes, proceed with: validate.
- STEP 4: After current activity finish, move to the next one: compile.
- STEP 5: Ends with the last action: test. Wait a bit the automation to start and after the tests execution, a report will be generated.
- STEP 6: The report will be found in the 'reports' folder and the 'index.html' file shall be displayed with the support of the browser.

<!-- BUG REPORT -->
### VI. BUG REPORT

_With regard to the whole project research, specified report is introduced, which ensure concise form of found errors and shared bug explanation details._

=> [BUG Traceability Matrix Report.pdf](src%2Ftest%2Fresources%2Fupload%2FBUG%20Traceability%20Matrix%20Report.pdf)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->
### VII. CONTACT  

- <u>Project author:</u>  Desislava Kancheva
- <u>Email:</u>  desi.kanchevaa@gmail.com
- <u>Project link:</u>  [</TAF POM Page Factory>](https://github.com/DesiK736/TAF-POM-PageFactory-Project.git)

 -  For genuine spirit sense, follow the link below:  
  [ 💚 Scenery view! 💚](https://www.flickr.com/photos/beaurogers/27660053044/)
