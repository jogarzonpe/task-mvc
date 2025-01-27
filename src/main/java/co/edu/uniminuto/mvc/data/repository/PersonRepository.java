package co.edu.uniminuto.mvc.data.repository;

import co.edu.uniminuto.mvc.data.model.Person;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepositoryImplementation<Person, Long> {
}
