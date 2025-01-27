package co.edu.uniminuto.mvc.service.api;

import co.edu.uniminuto.mvc.data.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRoles();

    Role findRole(Long id);

    Role saveRole(Role role);

    void deleteRole(Long id);
}
