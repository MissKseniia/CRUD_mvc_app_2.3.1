package springMVC.web.dao;

import org.springframework.stereotype.Repository;
import springMVC.web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLDataException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addOrUpdateUser(User user) {

        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }

    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User  ", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void removeUser(Long id) throws SQLDataException {

        User user = getUserById(id);
        if (user == null) {
            throw new SQLDataException("User not found");
        }

        entityManager.remove(user);
    }
}
