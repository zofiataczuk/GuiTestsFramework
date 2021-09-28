import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.IOException;


public class BaseTest extends BrowserSettings {

  private WebDriver driver;

  @BeforeMethod(timeOut = 120000, alwaysRun = true)
  public void beforeTestMethod(){
    try {
      driver = getDriver(TestProperties.getBrowser());
      goToStartPage(TestProperties.getUrlToTest());
    } catch (IOException e) {
      e.printStackTrace();
    }
  };

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

    ChromeDriverManager.chromedriver();
    if("true".equals(headless)) {     //(headless.equals(true)) - nie moze byc tak?
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.addArguments("--headless");
      driver = new ChromeDriver(chromeOptions);
  }

    else{
    driver = new ChromeDriver();
    }
  }

  @AfterSuite
  public void afterSuite() {
    if(driver != null)  {
      driver.close();
      driver.quit();
    }
  }

  public WebDriver getDriver() {
    return driver;
  }
}
