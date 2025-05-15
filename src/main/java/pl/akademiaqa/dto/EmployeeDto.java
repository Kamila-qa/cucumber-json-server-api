package pl.akademiaqa.dto;

import lombok.Data;

@Data
public class EmployeeDto {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phone;
    private String website;
    private String role;
    private String type;
    private AddressDto address;
    private CompanyDto company;
}
