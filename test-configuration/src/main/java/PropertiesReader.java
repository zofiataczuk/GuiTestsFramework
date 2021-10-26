import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

  private final static String PROPERTIES_FILE_PATH = "test.properties";
  private final static String URL = "url.to.test";
  private final static String HEADLESS = "headless";
  private final static String BROWSER = "browser";
  private Properties properties;


  public PropertiesReader() {
    properties = new Properties();
    try {
      FileInputStream inputStream = new FileInputStream(this.getClass()
        .getResource(PROPERTIES_FILE_PATH)
        .getPath());
      try {
        properties.load(inputStream);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public String getUrl() {
    return properties.getProperty(URL);
  }

  public String getHeadless() {
    return properties.getProperty(HEADLESS);
  }

  public String getBrowser() {
    return properties.getProperty(BROWSER);
  }



}

