package springMVC.web.service;

import springMVC.web.entity.User;

import java.util.List;

public interface UserService {

    void addOrUpdateUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void removeUser(Long id);
}
