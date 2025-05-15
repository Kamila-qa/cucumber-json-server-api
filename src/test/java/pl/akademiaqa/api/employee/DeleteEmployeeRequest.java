package pl.akademiaqa.api.employee;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.BaseRequest;
import pl.akademiaqa.url.JsonServerUrl;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
public class DeleteEmployeeRequest {

    private final BaseRequest baseRequest;

    public Response deleteEmployee(String employeeId) {

        return given()
                .spec(baseRequest.requestSetup())
                .when()
                .delete(JsonServerUrl.getEmployeePath(employeeId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}