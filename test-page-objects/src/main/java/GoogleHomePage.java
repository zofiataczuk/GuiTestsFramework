import org.openqa.selenium.By;


import java.io.IOException;

public class GoogleHomePage extends BasePage {

  public static final String GOOGLE_IMG_XPATH = "/html/body/div[1]/div[2]/div/img"; //constant variable bo uppercase, kiedy constant? kiedy static final?

 public GoogleHomePage() {
   }

  public void verifyThatGoogleImgIsPresent() {
    try {
      getDriver(TestProperties.getBrowser());
      waitForElementToAppear(By.xpath(GOOGLE_IMG_XPATH));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
