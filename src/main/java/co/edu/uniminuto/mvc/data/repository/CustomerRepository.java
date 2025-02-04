package co.edu.uniminuto.mvc.data.repository;

import co.edu.uniminuto.mvc.data.model.Customer;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * JPA Spring Repository implementation for {@link Customer} entity.
 */
@Repository
public interface CustomerRepository extends JpaRepositoryImplementation<Customer, Long> {

    List<Customer> findAllByResponsibleId(Long responsibleId);

}
