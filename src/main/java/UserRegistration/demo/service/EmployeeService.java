package UserRegistration.demo.service;

import UserRegistration.demo.request.EmployeeDTO;
import UserRegistration.demo.request.LoginDTO;
import UserRegistration.demo.response.LoginMessage;
import org.springframework.stereotype.Service;



public interface EmployeeService {
    String saveEmployee(EmployeeDTO employeeDTO);

    LoginMessage loginEmployee(LoginDTO loginDTO);
}
