import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class TestDataProvider {

  public static String TEST_DATA_PATH = "test-configuration/src/main/resources/testData.csv";

  private CSVReader reader = null;
  private Object[][] data = null;




  public TestDataProvider() {
  }

  @DataProvider(name = "provideTestData")
  public  Iterator<Object[]> testData() throws IOException {
    return parseCsvData(TEST_DATA_PATH);
  }

  private Iterator<Object[]> parseCsvData(String fileName) throws IOException
  {
    BufferedReader input = null;
    File file = new File(fileName);
    input = new BufferedReader(new FileReader(file));
    String line = null;
    ArrayList<Object[]> data = new ArrayList<Object[]>();
    while((line = input.readLine()) != null)
    {
      String in = line.trim();
      String[] temp = in.split(";");
      List<Object> array = new ArrayList<Object>();
      for (String s : temp) {
        array.add(Integer.parseInt(s));
      }
      data.add(array.toArray());
    }
    input.close();
    return data.iterator();

  }

}
