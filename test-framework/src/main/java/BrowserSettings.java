import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;

public class BrowserSettings {

  private final static String CHROME = "chrome";
  private final static String FIREFOX = "firefox";
  private final static String INTERNET_EXPLORER = "ie";


  public static WebDriver getDriver(String browser) throws IOException {

    switch (browser) {
      case CHROME:
        return new ChromeDriver();
      case FIREFOX:
        return new FirefoxDriver();
      case INTERNET_EXPLORER:
        return new InternetExplorerDriver();
      default:
        throw new IllegalArgumentException("Wrong browser name provided: ");
    }
  }
}
