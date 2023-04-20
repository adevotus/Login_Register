package UserRegistration.demo.mode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeModel {

    @Id
    @Column(name = "employee_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    @Column(name = "employee_name", length = 255)
    private String employeeName;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "passoword", length = 255)
    private String password;

}