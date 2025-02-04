package co.edu.uniminuto.mvc.service.impl;

import co.edu.uniminuto.mvc.data.model.Employee;
import co.edu.uniminuto.mvc.data.repository.EmployeeRepository;
import co.edu.uniminuto.mvc.service.api.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findEmployee(Long id) {
        return employeeRepository.findById(id).orElse(Employee.builder().build());
    }

    @Override
    public Employee saveEmployee(Employee Employee) {
        return employeeRepository.saveAndFlush(Employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
