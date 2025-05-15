package pl.akademiaqa.cucumber.hooks;

import io.cucumber.java.After;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.bug.DeleteBugRequest;
import pl.akademiaqa.api.bug.ReadBugRequest;
import pl.akademiaqa.api.employee.DeleteEmployeeRequest;
import pl.akademiaqa.api.employee.ReadEmployeeRequest;
import pl.akademiaqa.context.Context;
import pl.akademiaqa.dto.BugDto;
import pl.akademiaqa.handlers.bug.BugResponse;
import pl.akademiaqa.handlers.employee.EmployeeResponse;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class Hooks {

    private final Context context;
    private final DeleteEmployeeRequest deleteEmployeeRequest;
    private final ReadEmployeeRequest readEmployeeRequest;
    private final DeleteBugRequest deleteBugRequest;
    private final ReadBugRequest readBugRequest;

    @After(value = "@employee_cleanup")
    public void afterEmployeeScenario() {
        String employeeIdToDelete = context.getEmployeeResponse().getId();
        Response response = deleteEmployeeRequest.deleteEmployee(employeeIdToDelete);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);

        List<EmployeeResponse> allEmployeesAfterDelete = readEmployeeRequest.readAllEmployees();
        assertThat(allEmployeesAfterDelete).doesNotContain(context.getEmployeeResponse());
    }

    @After(value = "@bug_cleanup")
    public void afterBugScenario() {
        String bugIdToDelete = context.getBugResponse().getId();
        Response response = deleteBugRequest.deleteBug(bugIdToDelete);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);

        List<BugResponse> allBugsAfterDelete = readBugRequest.readAllBugs();
        assertThat(allBugsAfterDelete).doesNotContain(context.getBugResponse());
    }

    @After(value = "@multiple_bug_cleanup")
    public void afterMultipleBugScenario() {
        final List<BugResponse> bugs = context.getBugResponseList();
        for(BugResponse bug : bugs) {
            Response response = deleteBugRequest.deleteBug(bug.getId());

            Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        }
        List<BugResponse> allBugsAfterDelete = readBugRequest.readAllBugs();
        assertThat(allBugsAfterDelete).doesNotContain(context.getBugResponse());
    }
}
