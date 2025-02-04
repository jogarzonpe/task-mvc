package co.edu.uniminuto.mvc.test.controller;

import co.edu.uniminuto.mvc.data.model.Role;
import co.edu.uniminuto.mvc.service.api.RoleService;
import co.edu.uniminuto.mvc.test.IntegrationTest;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@IntegrationTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RoleService roleService;

    @AfterEach
    public void afterTests() {
        reset(roleService);
    }

    @Test
    public void testViewRoles_ShouldSuccess() throws Exception {

        String roleName = "ADMIN";
        List<Role> roles = Collections.singletonList(Role.builder().id(1L).name(roleName).build());
        when(roleService.getRoles()).thenReturn(roles);

        this.mockMvc
            .perform(get("/roles"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("admin/view-roles"))
            .andExpect(model().attribute("roles", equalTo(roles)))
            .andExpect(model().attribute("savedRole", nullValue()))
            .andExpect(model().attribute("saveRoleSuccess", equalTo(Boolean.FALSE)));
    }

    @Test
    public void testViewRoleAdd_ShouldSuccess() throws Exception {

        this.mockMvc
            .perform(get("/roles/add"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("admin/view-role-form"))
            .andExpect(model().attribute("role", notNullValue()));
    }

    @Test
    public void testViewRoleEdit_ShouldSuccess() throws Exception {

        String roleName = "ADMIN";
        Role role = Role.builder().id(1L).name(roleName).build();
        when(roleService.findRole(eq(1L))).thenReturn(role);

        this.mockMvc
            .perform(get("/roles/1"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("admin/view-role-form"))
            .andExpect(model().attribute("role", equalTo(role)));
    }

    @Test
    public void testViewRoleDelete_ShouldSuccess() throws Exception {

        doNothing().when(roleService).deleteRole(eq(1L));

        this.mockMvc
            .perform(get("/roles/delete/1"))
            .andDo(print())
            .andExpect(status().isFound())
            .andExpect(view().name("redirect:/roles"));
    }

    @Test
    public void testSaveRole_ShouldSuccess() throws Exception {

        String roleName = "ADMIN";
        Role newRole = Role.builder().name(roleName).build();
        when(roleService.saveRole(eq(newRole))).thenReturn(Role.builder().id(1L).name(roleName).build());

        this.mockMvc
            .perform(post("/roles/save")
                .content(newRole.toString()))
            .andDo(print())
            .andExpect(status().isFound());
    }

}
