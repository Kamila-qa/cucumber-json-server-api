package pl.akademiaqa.api.employee;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.BaseRequest;
import pl.akademiaqa.dto.EmployeeDto;
import pl.akademiaqa.handlers.employee.CreateEmployeeResponse;
import pl.akademiaqa.handlers.employee.EmployeeResponse;
import pl.akademiaqa.url.JsonServerUrl;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
public class CreateEmployeeRequest {

    private final BaseRequest baseRequest;

    public EmployeeResponse createEmployee(EmployeeDto employee) {

        return given()
                .spec(baseRequest.requestSetup())
                .body(employee)
                .when()
                .post(JsonServerUrl.EMPLOYEES)
                .then()
                .statusCode(201)
                .log().ifError()
                .extract()
                .response()
                .as(CreateEmployeeResponse.class);
    }
}
