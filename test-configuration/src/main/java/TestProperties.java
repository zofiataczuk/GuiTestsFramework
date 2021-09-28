import java.net.URISyntaxException;

public class TestProperties extends PropertiesBase {

  private final static String URL_TO_TEST = "url.to.test";

  private static final String PROPERTIES_FILE_PATH = "/test.properties";
  private static final String HEADLESS_MODE = "headless";
  private static final String BROWSER="browser";

  private static TestProperties INSTANCE = null;

  private TestProperties() {

  }



  private static void build() {

    INSTANCE = new TestProperties();
    try {
      readPropertiesFile(TestProperties.class.getResource(PROPERTIES_FILE_PATH)
        .toURI()
        .getPath());
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

  }

  public static TestProperties getInstance() {
    if (INSTANCE == null) {
      build();
    }
    return (INSTANCE);
  }

  public static String getBrowser() {
    return getProperty(BROWSER);
  }

  public static String getUrlToTest() {
    return getProperty(PROPERTIES_FILE_PATH);
  }

}

