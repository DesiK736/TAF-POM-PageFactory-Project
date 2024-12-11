package gui.base;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {

   protected WebDriver driver;
   protected Logger log;

   @Parameters({ "browser" })
   @BeforeMethod(alwaysRun = true)
   public void setUp(@Optional("chrome") String browser, ITestContext ctx, Method method) {
      String testName = ctx.getCurrentXmlTest().getName();

      log = LogManager.getLogger(testName);
      log.info(" ==== Test method name: "+ method.getName() +" ====");

      BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
      driver = factory.createDriver();

      driver.manage().window().maximize();
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
   }

   @AfterMethod(alwaysRun = true)
   public void tearDown(ITestResult testResult) {
      log.info("Close driver");
      driver.quit();
   }
}
