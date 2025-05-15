package pl.akademiaqa.cucumber.steps.bug;

import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.bug.UpdateBugRequest;
import pl.akademiaqa.context.Context;
import pl.akademiaqa.dto.BugDto;
import pl.akademiaqa.handlers.bug.BugResponse;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class UpdateBugSteps {

    private final Context context;
    private final UpdateBugRequest updateBugRequest;

    @When("I close existing bug")
    public void i_close_existing_bug() {

        final String bugId = context.getBugResponse().getId();

        BugDto updatedBug = context.getBug();
        updatedBug.setStatus("closed");

        BugResponse bugResponse = updateBugRequest.updateBug(bugId, updatedBug);

        assertThat(bugResponse.getTitle()).isEqualTo(updatedBug.getTitle());
        assertThat(bugResponse.getDescription()).isEqualTo(updatedBug.getDescription());
        assertThat(bugResponse.getEmployeeId()).isEqualTo(updatedBug.getEmployeeId());
        assertThat(bugResponse.getStatus()).isEqualTo(updatedBug.getStatus());
    }
}
