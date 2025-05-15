package pl.akademiaqa.cucumber.steps.employee;

import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.employee.UpdateEmployeeRequest;
import pl.akademiaqa.context.Context;
import pl.akademiaqa.dto.EmployeeDto;
import pl.akademiaqa.handlers.employee.EmployeePayload;
import pl.akademiaqa.handlers.employee.EmployeeResponse;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class UpdateEmployeeSteps {

    private final UpdateEmployeeRequest updateEmployeeRequest;
    private final EmployeePayload employeePayload;
    private final Context context;

    @When("I update existing employee")
    public void i_update_existing_employee() {
        String createdEmployeeId = context.getEmployeeResponse().getId();
        EmployeeDto updatedEmployee = employeePayload.getUpdatedEmployee();
        EmployeeResponse updatedEmployeeResponse = updateEmployeeRequest.updateEmployee(updatedEmployee, createdEmployeeId);

        context.setEmployeeResponse(updatedEmployeeResponse);

        assertThat(updatedEmployeeResponse.getFirstName()).isEqualTo(updatedEmployee.getFirstName());
        assertThat(updatedEmployeeResponse.getLastName()).isEqualTo(updatedEmployee.getLastName());
        assertThat(updatedEmployeeResponse.getEmail()).isEqualTo(updatedEmployee.getEmail());
        assertThat(updatedEmployeeResponse.getAddress().getStreet()).isEqualTo(updatedEmployee.getAddress().getStreet());
    }
}
