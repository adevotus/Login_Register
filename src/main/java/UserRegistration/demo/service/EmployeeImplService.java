package UserRegistration.demo.service;

import UserRegistration.demo.mode.EmployeeModel;
import UserRegistration.demo.repository.EmployeeRepository;
import UserRegistration.demo.request.EmployeeDTO;
import UserRegistration.demo.request.LoginDTO;
import UserRegistration.demo.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeImplService implements EmployeeService{


    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String saveEmployee(EmployeeDTO employeeDTO) {
        EmployeeModel employee  = new EmployeeModel(
                employeeDTO.getEmployeeId(),
                employeeDTO.getEmployeeName(),
                employeeDTO.getEmail(),
                this.passwordEncoder.encode(employeeDTO.getPassword())
        );
        employeeRepository.save(employee);
        return employee.getEmployeeName();
    }

    @Override
    public LoginMessage loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        EmployeeModel model = employeeRepository.findByEmail(loginDTO.getEmail());
        if(model != null){
            String password = loginDTO.getPassword();
            String encodedPassword = model.getPassword();
            Boolean isPwdRight  = passwordEncoder.matches(password,encodedPassword);
            if(isPwdRight){
                Optional<EmployeeModel> employeeModel = employeeRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                        if(employeeModel.isPresent()){
                            return new LoginMessage("Login  was sucess", true);
                        }else {
                            return new LoginMessage("Login was failed", false);
                        }
            }else {
                return new LoginMessage("password not match",false);
            }
        }else {
            return new LoginMessage("Email does not Exit", false);
        }
//        return null;
    }
}
