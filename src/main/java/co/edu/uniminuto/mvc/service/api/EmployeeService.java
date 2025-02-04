package co.edu.uniminuto.mvc.service.api;

import co.edu.uniminuto.mvc.data.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee findEmployee(Long id);

    Employee saveEmployee(Employee Employee);

    void deleteEmployee(Long id);

}
