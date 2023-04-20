package UserRegistration.demo.repository;

import UserRegistration.demo.mode.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
@EnableJpaRepositories

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {

    Optional<EmployeeModel> findOneByEmailAndPassword(String email, String password);
    EmployeeModel findByEmail(String email);
}
