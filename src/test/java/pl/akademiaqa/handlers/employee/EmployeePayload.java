package pl.akademiaqa.handlers.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.akademiaqa.dto.AddressDto;
import pl.akademiaqa.dto.CompanyDto;
import pl.akademiaqa.dto.EmployeeDto;

@AllArgsConstructor
@Getter
@Setter
public class EmployeePayload {

    private EmployeeDto employee;
    private AddressDto address;
    private CompanyDto company;

    public EmployeeDto getDefaultEmployee() {
        address.setStreet("Sezamkowa");
        address.setSuite("12");
        address.setCity("New York");
        address.setZipcode("123-123");

        company.setCompanyName("Akademia QA");
        company.setTaxNumber("999-999-999");
        company.setCompanyPhone("800-700-900");

        employee.setFirstName("Joe");
        employee.setLastName("Black");
        employee.setUsername("joeblack");
        employee.setEmail("jblack@akademiaqa.pl");
        employee.setPhone("123123123");
        employee.setWebsite("www.akademiaqa.pl");
        employee.setRole("qa");
        employee.setType("b2b");
        employee.setAddress(address);
        employee.setCompany(company);

        return employee;
    }

    public EmployeeDto getUpdatedEmployee() {
        address.setStreet("Krzywa");
        address.setSuite("11");
        address.setCity("Cracow");
        address.setZipcode("111-111");

        company.setCompanyName("Microsoft");
        company.setTaxNumber("111-111-111");
        company.setCompanyPhone("800-700-900");

        employee.setFirstName("Joe");
        employee.setLastName("Black");
        employee.setUsername("joeblack");
        employee.setEmail("jblack@microsoft.pl");
        employee.setPhone("123123123");
        employee.setWebsite("www.microsoft.pl");
        employee.setRole("developer");
        employee.setType("b2b");
        employee.setAddress(address);
        employee.setCompany(company);

        return employee;
    }
}