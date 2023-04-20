package UserRegistration.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private String message = "your now registered as employee";
    private String email;
    private String employeeName;
//    private String message;
  public String toString(){
      return "EmployeeResponse{" +
              "message='" + message + '\'' +
              ", email='" + email + '\'' +
              ", employeeName='" + employeeName + '\'' +
              '}';
  }
}
