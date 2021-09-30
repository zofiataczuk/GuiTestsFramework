import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;

public class BasePage extends BrowserSettings {

  private static final int TIMEOUT = 5;
  private static final int POLLING = 100;

  private WebDriverWait wait;
  protected WebDriver driver;


  public BasePage (WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, 10);
  }

  protected void waitForElementToAppear (By locator) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  protected void waitForElementToDisappear(By locator) {
    wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

  protected void waitForTextToDisappear (By locator, String text) {
    wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
  }


}
