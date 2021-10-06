import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class BaseTest {

  private WebDriver driver;

  @BeforeMethod(timeOut = 120000, alwaysRun = true)
  public void beforeTestMethod() {

  }

  @AfterMethod(timeOut = 30000)
  public void afterTestMethod() {

  }

  public void goToStartPage(String url) {
    driver.get(url);
  }



  @BeforeSuite
  public void beforeSuite() {
    System.setProperty("headless", PropertiesReader.getInstance().getHeadless());
    String headless = System.getProperty("headless");
    ChromeOptions chromeOptions = new ChromeOptions();
    Map prefs = new HashMap();
    prefs.put("profile.default_content_settings.cookies", 2);
    chromeOptions.setExperimentalOption("prefs", prefs);

    ChromeDriverManager.chromedriver().setup();
    if ("true".equals(headless)) {     //(headless.equals(true)) - nie moze byc tak?

      chromeOptions.addArguments("--headless");
      driver = new ChromeDriver(chromeOptions);
    } else {
      driver = new ChromeDriver(chromeOptions);
    }
    driver.get(PropertiesReader.getInstance().getUrl());
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
