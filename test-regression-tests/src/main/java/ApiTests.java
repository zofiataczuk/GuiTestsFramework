import apiEngine.model.*;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ApiTests {

    private static final String baseUrl = "http://dummy.restapiexample.com/api";

    private Endpoints endPoints;

    @Test
    public void getListOfEmployees() {
        endPoints = new Endpoints(baseUrl);

        IRestResponse<Employees> employeesResponse = endPoints.getListOfEmployees();
        String status = employeesResponse.getBody().getStatus();
        List<EmployeeData> employeeDataList = employeesResponse.getBody().getData();

        assertThat(status).as("Incorrect status returned").isEqualTo("success");
        assertThat(employeeDataList).as("Employee data list is empty").isNotEmpty();
    }

    @Test
    public void getEmployeeData() {
        endPoints = new Endpoints(baseUrl);
        IRestResponse<Employees> employeesResponse = endPoints.getListOfEmployees();
        List <EmployeeData> employeeDataList = employeesResponse.getBody().getData();

        String employeeName = employeeDataList.stream().map(m -> m.getEmployee_name())
                .findFirst().get();

        assertThat(employeeName).as("Incorrect employee name").isEqualTo("Tiger Nixon");
    }

}
