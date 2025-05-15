package pl.akademiaqa.cucumber.steps.bug;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import pl.akademiaqa.api.bug.DeleteBugRequest;
import pl.akademiaqa.context.Context;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class DeleteBugSteps {

    private final Context context;
    private final DeleteBugRequest deleteBugRequest;

    @When("I delete existing bug")
    public void i_delete_existing_bug() {
        String bugId = context.getBugResponse().getId();
        Response response = deleteBugRequest.deleteBug(bugId);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }
}
