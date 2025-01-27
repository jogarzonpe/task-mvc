package co.edu.uniminuto.mvc.data.repository;

import co.edu.uniminuto.mvc.data.model.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, Long> {
}
