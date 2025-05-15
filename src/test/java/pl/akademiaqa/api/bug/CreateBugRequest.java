package pl.akademiaqa.api.bug;

import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.BaseRequest;
import pl.akademiaqa.dto.BugDto;
import pl.akademiaqa.handlers.bug.BugResponse;
import pl.akademiaqa.handlers.bug.CreateBugResponse;
import pl.akademiaqa.url.JsonServerUrl;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
public class CreateBugRequest {

    private final BaseRequest baseRequest;

    public BugResponse createBug(BugDto bug){

        return given()
                .spec(baseRequest.requestSetup())
                .body(bug)
                .when()
                .post(JsonServerUrl.BUGS)
                .then()
                .statusCode(201)
                .log().ifError()
                .extract()
                .response()
                .as(CreateBugResponse.class);
    }
}
