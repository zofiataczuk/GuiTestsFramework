import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSearchResultPage extends BasePage {

  private final static String SEARCH_RESULT_1ST_POSITION_XPATH =
    "//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3"; // jak to inaczej?


  public GoogleSearchResultPage(WebDriver driver) {
    super(driver);
  }

  public GoogleSearchResultPage verifyThatSearchResultContainsText(String resultText) {
    String expectedSearchResult = driver.findElement(By.xpath(SEARCH_RESULT_1ST_POSITION_XPATH))
      .getText();

    assertThat(expectedSearchResult).as("Search result is not correct")
      .isEqualTo(resultText);
    return this;
  }
}
