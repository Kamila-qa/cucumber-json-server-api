package pl.akademiaqa.handlers.bug;

import lombok.Data;

@Data
public abstract class BugResponse {

    protected String id;
    protected String title;
    protected String description;
    protected int employeeId;
    protected String status;
}