package pl.akademiaqa.dto;

import lombok.Data;

@Data
public class BugDto {

    private String title;
    private String description;
    private int employeeId;
    private String status;
}
