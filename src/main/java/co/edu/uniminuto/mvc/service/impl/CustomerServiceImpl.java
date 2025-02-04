package co.edu.uniminuto.mvc.service.impl;

import co.edu.uniminuto.mvc.data.model.Customer;
import co.edu.uniminuto.mvc.data.repository.CustomerRepository;
import co.edu.uniminuto.mvc.service.api.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getCustomersByResponsible(Long responsibleId) {
        return customerRepository.findAllByResponsibleId(responsibleId);
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findCustomer(Long id) {
        return customerRepository.findById(id).orElse(Customer.builder().build());
    }

    @Override
    public Customer saveCustomer(Customer Customer) {
        return customerRepository.saveAndFlush(Customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
