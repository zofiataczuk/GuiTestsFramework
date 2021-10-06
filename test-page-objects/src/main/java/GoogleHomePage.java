import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.io.IOException;

public class GoogleHomePage extends BasePage {

  public static final String GOOGLE_IMG_XPATH = "/html/body/div[1]/div[2]/div/img";
  public static final String SEARCH_INPUT_XPATH = "//input[@title=\"Szukaj\"]";
  public static final String AGREE_BUTTON_XPATH = "//*[contains(text(),\"Zgadzam się\")]";
  //public static final String SEARCH_BUTTON_XPATH = "//input[@name=\"btnK\"]";
  public static final String SEARCH_BUTTON_XPATH = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]";

  public GoogleHomePage(WebDriver driver) {
    super(driver);
  }

  public GoogleSearchResultPage searchInGoogle(String text) {
    driver.findElement(By.xpath(AGREE_BUTTON_XPATH))
      .click();
    waitForElementToAppear(By.xpath(SEARCH_INPUT_XPATH));
    driver.findElement(By.xpath(SEARCH_INPUT_XPATH)).sendKeys(text);
    driver.findElement(By.xpath(SEARCH_BUTTON_XPATH)).click();
    return new GoogleSearchResultPage(driver);
  }
}
