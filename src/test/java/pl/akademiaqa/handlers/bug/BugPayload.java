package pl.akademiaqa.handlers.bug;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.akademiaqa.dto.BugDto;

@AllArgsConstructor
@Getter
@Setter
public class BugPayload {

    private BugDto bug;

    public BugDto getDefaultBug() {
        bug.setTitle("I am not able to create new bug");
        bug.setDescription("When I send POST request I'm getting 500 internal server error");
        bug.setStatus("open");
        bug.setEmployeeId(1);

        return bug;
    }
}
