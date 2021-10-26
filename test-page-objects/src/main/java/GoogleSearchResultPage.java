import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSearchResultPage extends BasePage {

  private final static String SEARCH_RESULT_XPATH =
    "//*[@id='rso']//a[contains(@href, 'https')]/h3";

  public GoogleSearchResultPage(WebDriver driver) {
    super(driver);
  }

  public GoogleSearchResultPage verifyThatSearchResultContainsText(String resultText) {

    boolean actualResult = driver.findElements(By.xpath(SEARCH_RESULT_XPATH))
      .stream()
      .map(m -> m.getText())
      .anyMatch(a -> a.contains(resultText)); // to wyniesc do osobnej prywatnej funkcji

    assertThat(actualResult).as("Search result does not contain given text")
      .isTrue();
    return this;
  }
}
