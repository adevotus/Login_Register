package UserRegistration.demo.controller;

import UserRegistration.demo.request.EmployeeDTO;
import UserRegistration.demo.request.LoginDTO;
import UserRegistration.demo.response.LoginMessage;
import UserRegistration.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/add")
    public String addEmployee(@RequestBody EmployeeDTO employeeDTO){
       String response =  employeeService.saveEmployee(employeeDTO);

        return response;
    }

    @PostMapping("/login")
    public ResponseEntity<?>loginEmployee(@RequestBody LoginDTO loginDTO){
        LoginMessage loginMessage =employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }

}
