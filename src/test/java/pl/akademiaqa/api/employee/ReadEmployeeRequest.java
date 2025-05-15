package pl.akademiaqa.api.employee;

import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.BaseRequest;
import pl.akademiaqa.handlers.employee.EmployeeResponse;
import pl.akademiaqa.handlers.employee.ReadEmployeeResponse;
import pl.akademiaqa.url.JsonServerUrl;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
public class ReadEmployeeRequest {

    private final BaseRequest baseRequest;

    public List<EmployeeResponse> readAllEmployees() {

        return Arrays.asList(given()
                .spec(baseRequest.requestSetup())
                .when()
                .get(JsonServerUrl.EMPLOYEES)
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response()
                .as(ReadEmployeeResponse[].class));
    }

    public EmployeeResponse readOneEmployee(String employeeId) {

        return given()
                .spec(baseRequest.requestSetup())
                .when()
                .get(JsonServerUrl.getEmployeePath(employeeId))
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response()
                .as(ReadEmployeeResponse.class);
    }
}