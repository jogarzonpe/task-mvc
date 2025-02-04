package co.edu.uniminuto.mvc.data.repository;

import co.edu.uniminuto.mvc.data.model.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * JPA Spring Repository implementation for {@link User} entity.
 */
@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, Long> {
}
