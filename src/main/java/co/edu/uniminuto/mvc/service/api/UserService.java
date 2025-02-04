package co.edu.uniminuto.mvc.service.api;

import co.edu.uniminuto.mvc.data.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User findUser(Long id);

    User saveUser(User user);

    void deleteUser(Long id);

}
