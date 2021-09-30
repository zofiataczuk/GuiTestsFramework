import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSearchResultPage extends BasePage {

  private static final String SEARCH_RESULT_LIST_CSS = ".r";

  public GoogleSearchResultPage(WebDriver driver) {
    super(driver);
  }

  public GoogleSearchResultPage verifyThatSearchResultContainsText(String resultText) {
    List<WebElement> searchResults = driver.findElements(By.cssSelector(SEARCH_RESULT_LIST_CSS));

    String expectedResult = searchResults.stream()
      .filter(f -> f.getText()
        .contains(resultText))
      .collect(Collectors.toList())
      .get(0).getText();

    assertThat(expectedResult).as("Search result is not correct").isEqualTo(resultText);
    return this;
  }
}
