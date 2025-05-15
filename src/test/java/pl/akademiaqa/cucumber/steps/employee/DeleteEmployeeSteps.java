package pl.akademiaqa.cucumber.steps.employee;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import pl.akademiaqa.api.employee.DeleteEmployeeRequest;
import pl.akademiaqa.context.Context;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class DeleteEmployeeSteps {
    private final Context context;
    private final DeleteEmployeeRequest deleteEmployeeRequest;

    @When("I delete existing employee")
    public void i_delete_existing_employee() {
        String employeeId = context.getEmployeeResponse().getId();
        Response response = deleteEmployeeRequest.deleteEmployee(employeeId);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }
}