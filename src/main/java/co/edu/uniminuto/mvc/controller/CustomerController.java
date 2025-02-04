package co.edu.uniminuto.mvc.controller;

import co.edu.uniminuto.mvc.data.model.Customer;
import co.edu.uniminuto.mvc.data.model.Employee;
import co.edu.uniminuto.mvc.data.model.Person;
import co.edu.uniminuto.mvc.service.api.CustomerService;
import co.edu.uniminuto.mvc.service.api.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/employees/{employeeId}/customers")
public class CustomerController {

    private final EmployeeService employeeService;

    private final CustomerService customerService;

    @GetMapping("")
    public String viewCustomers(Model model, @PathVariable Long employeeId) {
        model.addAttribute("customers", customerService.getCustomersByResponsible(employeeId));
        model.addAttribute("employeeId", employeeId);
        model.addAttribute("savedCustomer", null);
        model.addAttribute("saveCustomerSuccess", false);
        return "business/view-customers";
    }

    @GetMapping("/add")
    public String viewCustomerAdd(Model model, @PathVariable Long employeeId) {
        model.addAttribute("employeeId", employeeId);
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("customer", Customer.builder().data(new Person()).build());
        return "business/view-customer-form";
    }

    @GetMapping("/{id}")
    public String viewCustomerEdit(Model model, @PathVariable Long employeeId, @PathVariable Long id) {
        model.addAttribute("employeeId", employeeId);
        model.addAttribute("customer", customerService.findCustomer(id));
        model.addAttribute("responsible", employeeService.findEmployee(employeeId));
        return "business/view-customer-form";
    }

    @GetMapping("/delete/{id}")
    public String viewCustomerDelete(@PathVariable Long employeeId, @PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/employees/" + employeeId + "/customers";
    }

    @PostMapping("/save")
    public RedirectView saveCustomer(@PathVariable Long employeeId, @ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        Employee responsible = employeeService.findEmployee(employeeId);
        customer.setResponsible(responsible);
        Customer savedCustomer = customerService.saveCustomer(customer);
        final RedirectView redirectView = new RedirectView("/employees/" + employeeId + "/customers", true);
        redirectAttributes.addFlashAttribute("savedCustomer", savedCustomer);
        redirectAttributes.addFlashAttribute("saveCustomerSuccess", true);
        return redirectView;
    }

}
