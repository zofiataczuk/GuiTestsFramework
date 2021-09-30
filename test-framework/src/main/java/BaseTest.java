import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class BaseTest extends BrowserSettings {

  private WebDriver driver;

  @BeforeMethod(timeOut = 120000, alwaysRun = true)
  public void beforeTestMethod() {
    /*try {
      driver = getDriver(TestProperties.getBrowser());
      goToStartPage(TestProperties.getUrlToTest());
    } catch (IOException e) {
      e.printStackTrace();
    }*/
  }

  ;

  @AfterMethod(timeOut = 30000)
  public void afterTestMethod() {

  }

  public void goToStartPage(String url) {
    driver.get(url);
  }



  @BeforeSuite
  public void beforeSuite() {
    System.setProperty("headless", "false");
    String headless = System.getProperty("headless");

    ChromeDriverManager.chromedriver().setup();
    if ("true".equals(headless)) {     //(headless.equals(true)) - nie moze byc tak?
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.addArguments("--headless");
      driver = new ChromeDriver(chromeOptions);
    } else {
      Map prefs = new HashMap();
      prefs.put("profile.default_content_settings.cookies", 2);
      ChromeOptions options = new ChromeOptions();
      options.setExperimentalOption("prefs", prefs);
      driver = new ChromeDriver(options);
    }
    driver.get("https://www.google.com/");
    driver.manage().window().maximize();
  }

  @AfterSuite
  public void afterSuite() {
    if (driver != null) {
      driver.close();
      driver.quit();
    }
  }

  public WebDriver getDriver() {
    return driver;
  }
}
