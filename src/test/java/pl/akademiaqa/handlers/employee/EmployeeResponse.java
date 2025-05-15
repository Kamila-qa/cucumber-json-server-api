package pl.akademiaqa.handlers.employee;

import lombok.Data;
import pl.akademiaqa.dto.AddressDto;
import pl.akademiaqa.dto.CompanyDto;

@Data
public class EmployeeResponse {

    protected String id;
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String email;
    protected String phone;
    protected String website;
    protected String role;
    protected String type;
    protected AddressDto address;
    protected CompanyDto company;
}