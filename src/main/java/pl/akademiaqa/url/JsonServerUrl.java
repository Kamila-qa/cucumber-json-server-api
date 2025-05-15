package pl.akademiaqa.url;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonServerUrl {

    public static final String BASE_URL = "http://localhost:3000/";
    public static final String EMPLOYEES = "employees/";
    public static final String BUGS = "bugs/";

    public static String getEmployeePath(String employeeId) {
        return String.format(EMPLOYEES + "%s", employeeId);
    }

    public static String getBugPath(String bugId) {
        return String.format(BUGS + "%s", bugId);
    }
}
