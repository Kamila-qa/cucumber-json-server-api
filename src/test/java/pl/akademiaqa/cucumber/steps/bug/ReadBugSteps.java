package pl.akademiaqa.cucumber.steps.bug;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.bug.ReadBugRequest;
import pl.akademiaqa.context.Context;
import pl.akademiaqa.handlers.bug.BugResponse;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class ReadBugSteps {

    private final Context context;
    private final ReadBugRequest readBugRequest;

    private List<BugResponse> allBugs;

    @Then("I can read updated bug and see status as closed")
    public void i_can_read_updated_bug_and_see_status_as_closed() {
        final String bugId = context.getBugResponse().getId();
        final BugResponse bugResponse = readBugRequest.readBug(bugId);
        assertThat(bugResponse.getStatus()).isEqualTo("closed");
    }

    @Given("I read all bugs")
    public void i_read_all_bugs() {
        allBugs = readBugRequest.readAllBugs();
    }

    @Then("I see created bugs on bugs list")
    public void i_see_created_bugs_on_bugs_list() {
        final List<BugResponse> bugsAfterCreate = readBugRequest.readAllBugs();
        assertThat(bugsAfterCreate).hasSizeGreaterThan(allBugs.size());
        assertThat(bugsAfterCreate).containsAll(context.getBugResponseList());
    }

    @Then("I should not see deleted bug on bugs list")
    public void i_should_not_see_deleted_bug_on_bugs_list() {
        List<BugResponse> allBugsAfterDelete = readBugRequest.readAllBugs();
        assertThat(allBugsAfterDelete).doesNotContain(context.getBugResponse());
    }
}
