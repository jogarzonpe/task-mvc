package co.edu.uniminuto.mvc.data.repository;

import co.edu.uniminuto.mvc.data.model.Role;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * JPA Spring Repository implementation for {@link Role} entity.
 */
@Repository
public interface RoleRepository extends JpaRepositoryImplementation<Role, Long> {
}
