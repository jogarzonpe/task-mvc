package co.edu.uniminuto.mvc.service.api;

import co.edu.uniminuto.mvc.data.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    List<Customer> getCustomersByResponsible(Long responsibleId);

    Customer findCustomer(Long id);

    Customer saveCustomer(Customer Customer);

    void deleteCustomer(Long id);

}
