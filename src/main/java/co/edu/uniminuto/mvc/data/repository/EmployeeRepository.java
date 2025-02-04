package co.edu.uniminuto.mvc.data.repository;

import co.edu.uniminuto.mvc.data.model.Employee;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * JPA Spring Repository implementation for {@link Employee} entity.
 */
@Repository
public interface EmployeeRepository extends JpaRepositoryImplementation<Employee, Long> {
}
