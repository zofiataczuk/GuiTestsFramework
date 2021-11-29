import org.testng.annotations.Test;


public class GoogleHomePageTests extends BaseTest {

  @Test
  public void searchInGoogleTest() {
    GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
    googleHomePage.searchInGoogle("kapusta")
      .verifyThatSearchResultContainsText("Kapusta – Wikipedia, wolna encyklopedia");
  }
}
