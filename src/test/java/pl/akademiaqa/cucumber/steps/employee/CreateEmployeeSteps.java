package pl.akademiaqa.cucumber.steps.employee;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.employee.CreateEmployeeRequest;
import pl.akademiaqa.context.Context;
import pl.akademiaqa.dto.EmployeeDto;
import pl.akademiaqa.handlers.employee.EmployeePayload;
import pl.akademiaqa.handlers.employee.EmployeeResponse;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class CreateEmployeeSteps {

    private final CreateEmployeeRequest createEmployeeRequest;
    private final EmployeePayload employeePayload;
    private final Context context;

    @When("I create new employee")
    public void i_create_new_employee() {
        create_new_employee();
    }

    @Given("Employee already exist")
    public void employee_already_exist() {
        create_new_employee();
    }

    private void create_new_employee() {

        EmployeeDto defaultEmployee = employeePayload.getDefaultEmployee();
        EmployeeResponse employeeResponse = createEmployeeRequest.createEmployee(defaultEmployee);

        assertThat(employeeResponse.getFirstName()).isEqualTo(defaultEmployee.getFirstName());
        assertThat(employeeResponse.getLastName()).isEqualTo(defaultEmployee.getLastName());
        assertThat(employeeResponse.getEmail()).isEqualTo(defaultEmployee.getEmail());

        context.setEmployeeResponse(employeeResponse);
    }
}
