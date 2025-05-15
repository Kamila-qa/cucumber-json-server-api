package pl.akademiaqa.cucumber.steps.bug;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.bug.CreateBugRequest;
import pl.akademiaqa.context.Context;
import pl.akademiaqa.dto.BugDto;
import pl.akademiaqa.handlers.bug.BugPayload;
import pl.akademiaqa.handlers.bug.BugResponse;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class CreateBugSteps {
    private final CreateBugRequest createBugRequest;
    private final BugPayload bugPayload;
    private final Context context;

    @Given("Bug already exist")
    public void bug_already_exist() {
        BugDto defaultBug = bugPayload.getDefaultBug();
        BugResponse bugResponse = createBugRequest.createBug(defaultBug);

        assertThat(bugResponse.getTitle()).isEqualTo(defaultBug.getTitle());
        assertThat(bugResponse.getDescription()).isEqualTo(defaultBug.getDescription());
        assertThat(bugResponse.getEmployeeId()).isEqualTo(defaultBug.getEmployeeId());
        assertThat(bugResponse.getStatus()).isEqualTo(defaultBug.getStatus());

        context.setBugResponse(bugResponse);
        context.setBug(defaultBug);
    }

    @When("I create multiple bugs")
    public void i_create_multiple_bugs(List<BugDto> bugs) {
        for (BugDto bug : bugs) {
            final BugResponse bugResponse = createBugRequest.createBug(bug);
            assertThat(bugResponse.getTitle()).isEqualTo(bug.getTitle());
            assertThat(bugResponse.getDescription()).isEqualTo(bug.getDescription());
            assertThat(bugResponse.getEmployeeId()).isEqualTo(bug.getEmployeeId());
            assertThat(bugResponse.getStatus()).isEqualTo(bug.getStatus());

            context.addBugResponseToList(bugResponse);
            context.addBugToList(bug);
        }

    }

}
