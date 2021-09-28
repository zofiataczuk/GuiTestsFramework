import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PropertiesBase {

  // DLACZEGO ABSTRAKCYJNA??

  protected static Properties props = new Properties();
  protected static Logger LOG;

  public static String getProperty (String propertyName) {
    String property = null;
    if(System.getProperty(propertyName) == null) {
      property = props.getProperty(property);
    }
    return property;
  }

  protected static void readPropertiesFile(String propertiesFilePath) {
    try {
      props.load(new FileInputStream(propertiesFilePath));
      String message = String.format("Successfully loaded properties file: '%s'", propertiesFilePath);
      LOG.info(message);
    } catch(IOException e) {
      LOG.warn("Error reading properties from file " + propertiesFilePath);
    }
  }

  protected static void initializeLogger(String name) {
    LOG = LoggerFactory.getLogger(name);
  }
}
