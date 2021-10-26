import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

public class BaseTest extends TestDataProvider{

  private WebDriver driver;
  private PropertiesReader propertiesReader;

  public BaseTest() {
    this.propertiesReader = new PropertiesReader();
  }

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
    System.setProperty("headless", propertiesReader.getHeadless());
    String headless = System.getProperty("headless");
    ChromeOptions chromeOptions = new ChromeOptions();
    Map prefs = new HashMap();
    prefs.put("profile.default_content_settings.cookies", 2);
    chromeOptions.setExperimentalOption("prefs", prefs);

    ChromeDriverManager.chromedriver()
      .setup();
    if ("true".equals(headless)) {     //(headless.equals(true)) - nie moze byc tak?

      chromeOptions.addArguments("--headless");
      driver = new ChromeDriver(chromeOptions);
    } else {
      driver = new ChromeDriver(chromeOptions);
    }
    driver.get(propertiesReader
      .getUrl());
    driver.manage()
      .window()
      .maximize();
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
