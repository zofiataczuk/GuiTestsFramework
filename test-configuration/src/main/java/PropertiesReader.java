import java.io.*;
import java.util.Properties;

public class PropertiesReader {

  private final static String PROPERTIES_FILE_PATH = "test.properties";
  private final static String URL = "url.to.test";
  private final static String HEADLESS = "headless";
  private final static String BROWSER = "browser";
  private static PropertiesReader instance = null;
  private Properties properties;

  public PropertiesReader() {
  }

  public static PropertiesReader getInstance() {
    if (instance == null) {
      instance = new PropertiesReader();
      instance.loadPropertiesData();
    }
    return instance;
  }


  private void loadPropertiesData() {
    properties = new Properties();
    try {
      FileInputStream inputStream = new FileInputStream(PROPERTIES_FILE_PATH);
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

