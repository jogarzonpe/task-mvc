package co.edu.uniminuto.mvc.data.repository;

import co.edu.uniminuto.mvc.data.model.Dependency;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * JPA Spring Repository implementation for {@link Dependency} entity.
 */
@Repository
public interface DependencyRepository extends JpaRepositoryImplementation<Dependency, Long> {
}
