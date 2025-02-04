package co.edu.uniminuto.mvc.controller;

import co.edu.uniminuto.mvc.data.model.Person;
import co.edu.uniminuto.mvc.data.model.Employee;
import co.edu.uniminuto.mvc.service.api.DependencyService;
import co.edu.uniminuto.mvc.service.api.JobTitleService;
import co.edu.uniminuto.mvc.service.api.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final JobTitleService jobTitleService;

    private final EmployeeService employeeService;

    private final DependencyService dependencyService;

    @GetMapping("")
    public String viewEmployees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("savedEmployee", null);
        model.addAttribute("saveEmployeeSuccess", false);
        return "business/view-employees";
    }

    @GetMapping("/add")
    public String viewEmployeeAdd(Model model) {
        model.addAttribute("jobTitles", jobTitleService.getJobTitles());
        model.addAttribute("dependencies", dependencyService.getDependencies());
        model.addAttribute("employee", Employee.builder().data(new Person()).build());
        return "business/view-employee-form";
    }

    @GetMapping("/{id}")
    public String viewEmployeeEdit(Model model, @PathVariable Long id) {
        model.addAttribute("jobTitles", jobTitleService.getJobTitles());
        model.addAttribute("dependencies", dependencyService.getDependencies());
        model.addAttribute("employee", employeeService.findEmployee(id));
        return "business/view-employee-form";
    }

    @GetMapping("/delete/{id}")
    public String viewEmployeeDelete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    @PostMapping("/save")
    public RedirectView saveEmployee(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/employees", true);
        Employee savedEmployee = employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute("savedEmployee", savedEmployee);
        redirectAttributes.addFlashAttribute("saveEmployeeSuccess", true);
        return redirectView;
    }

}
