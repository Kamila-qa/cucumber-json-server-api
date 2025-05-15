package pl.akademiaqa.cucumber.transformers;

import io.cucumber.java.DataTableType;
import pl.akademiaqa.dto.BugDto;

import java.util.Map;

public class BugDataTable {

    @DataTableType
    public BugDto transform(Map<String, String> data) {
        BugDto bugDto = new BugDto();
        bugDto.setTitle(data.get("title"));
        bugDto.setDescription(data.get("description"));
        bugDto.setEmployeeId(Integer.parseInt(data.get("employeeId")));
        bugDto.setStatus(data.get("status"));

        return bugDto;
    }
}
