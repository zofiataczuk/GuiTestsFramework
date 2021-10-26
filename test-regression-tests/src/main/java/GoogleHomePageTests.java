import org.testng.annotations.Test;


public class GoogleHomePageTests extends BaseTest {

  @Test(dataProvider = "createTestData" )
  public void searchInGoogleTest(TestData testData) {

    GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
    googleHomePage.searchInGoogle(testData.getSearchText())
      .verifyThatSearchResultContainsText(testData.getSearchResult());
  }
}
