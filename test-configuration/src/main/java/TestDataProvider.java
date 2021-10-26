import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.Data;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class TestDataProvider {

  public static String TEST_DATA_PATH = "testData.csv";


  public TestDataProvider() {
  }


  @DataProvider(name = "createTestData")
  public Object[][] createTestData() throws IOException {

  }


  private static Object[][] readCsvData() {
    String filePath = "src/main/resources/testData.csv";
    ArrayList<Object[]> dataList = new ArrayList<Object[]>();
    CSVReader reader = null;

    try {
      reader = new CSVReader(new FileReader(filePath));
      String[] line;
      while(true) {
        try {
          if (!((line=reader.readNext()) !=null))
            break;
        } catch (CsvValidationException e) {
          e.printStackTrace();
        }
        Object[] record = {line[0], line[1], line[2]};
        dataList.add(record);
      }
      reader.close();

      return dataList.toArray(new Object[dataList.size()][]);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

}
