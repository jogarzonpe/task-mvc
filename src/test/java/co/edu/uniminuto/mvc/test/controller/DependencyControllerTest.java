package co.edu.uniminuto.mvc.test.controller;

import co.edu.uniminuto.mvc.data.model.Dependency;
import co.edu.uniminuto.mvc.service.api.DependencyService;
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
public class DependencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DependencyService roleService;

    @AfterEach
    public void afterTests() {
        reset(roleService);
    }

    @Test
    public void testViewDependencys_ShouldSuccess() throws Exception {

        String name = "Administración";
        List<Dependency> dependencies = Collections.singletonList(Dependency.builder().id(1L).name(name).build());
        when(roleService.getDependencies()).thenReturn(dependencies);

        this.mockMvc
            .perform(get("/dependencies"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("admin/view-dependencies"))
            .andExpect(model().attribute("dependencies", equalTo(dependencies)))
            .andExpect(model().attribute("savedDependency", nullValue()))
            .andExpect(model().attribute("saveDependencySuccess", equalTo(Boolean.FALSE)));
    }

    @Test
    public void testViewDependencyAdd_ShouldSuccess() throws Exception {

        this.mockMvc
            .perform(get("/dependencies/add"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("admin/view-dependency-form"))
            .andExpect(model().attribute("dependency", notNullValue()));
    }

    @Test
    public void testViewDependencyEdit_ShouldSuccess() throws Exception {

        String name = "Administración";
        Dependency dependency = Dependency.builder().id(1L).name(name).build();
        when(roleService.findDependency(eq(1L))).thenReturn(dependency);

        this.mockMvc
            .perform(get("/dependencies/1"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("admin/view-dependency-form"))
            .andExpect(model().attribute("dependency", equalTo(dependency)));
    }

    @Test
    public void testViewDependencyDelete_ShouldSuccess() throws Exception {

        doNothing().when(roleService).deleteDependency(eq(1L));

        this.mockMvc
            .perform(get("/dependencies/delete/1"))
            .andDo(print())
            .andExpect(status().isFound())
            .andExpect(view().name("redirect:/dependencies"));
    }

    @Test
    public void testSaveDependency_ShouldSuccess() throws Exception {

        String name = "Administración";
        Dependency newDependency = Dependency.builder().name(name).build();
        when(roleService.saveDependency(eq(newDependency))).thenReturn(Dependency.builder().id(1L).name(name).build());

        this.mockMvc
            .perform(post("/dependencies/save")
                .content(newDependency.toString()))
            .andDo(print())
            .andExpect(status().isFound());
    }

}
