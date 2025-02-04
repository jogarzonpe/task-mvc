package co.edu.uniminuto.mvc.test;

import co.edu.uniminuto.mvc.controller.CustomerController;
import co.edu.uniminuto.mvc.controller.DependencyController;
import co.edu.uniminuto.mvc.controller.EmployeeController;
import co.edu.uniminuto.mvc.controller.HomeController;
import co.edu.uniminuto.mvc.controller.JobTitleController;
import co.edu.uniminuto.mvc.controller.RoleController;
import co.edu.uniminuto.mvc.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class InitAppIntegrationTests {

    @Autowired
    private HomeController homeController;

    @Autowired
    private RoleController roleController;

    @Autowired
    private UserController userController;

    @Autowired
    private CustomerController customerController;

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private JobTitleController jobTitleController;

    @Autowired
    private DependencyController dependencyController;

    @Test
    void contextLoadsControllers() {
        assertThat(homeController).isNotNull();
        assertThat(roleController).isNotNull();
        assertThat(userController).isNotNull();
        assertThat(customerController).isNotNull();
        assertThat(employeeController).isNotNull();
        assertThat(jobTitleController).isNotNull();
        assertThat(dependencyController).isNotNull();
    }

}
