package springMVC.web.dao;

import springMVC.web.entity.User;

import java.sql.SQLDataException;
import java.util.List;

public interface UserDao {

    void addOrUpdateUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void removeUser(Long id) throws SQLDataException;
}
