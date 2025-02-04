package co.edu.uniminuto.mvc.data.repository;

import co.edu.uniminuto.mvc.data.model.JobTitle;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * JPA Spring Repository implementation for {@link JobTitle} entity.
 */
@Repository
public interface JobTitleRepository extends JpaRepositoryImplementation<JobTitle, Long> {
}
