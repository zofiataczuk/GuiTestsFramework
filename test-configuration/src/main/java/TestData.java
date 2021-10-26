import com.opencsv.bean.CsvBindByName;
import lombok.Data;


@Data
public class TestData {

  @CsvBindByName(column = "SearchText")
  private String searchText;

  @CsvBindByName(column = "SearchResult")
  private String searchResult;

  @CsvBindByName(column = "TestCaseName")
  private String testCaseName;

}
