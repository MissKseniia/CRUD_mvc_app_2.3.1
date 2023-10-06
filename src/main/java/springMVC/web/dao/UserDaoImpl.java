package springMVC.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springMVC.web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManagerFactory managerFactory;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
        this.entityManager = managerFactory.createEntityManager();
    }

    @Transactional
    @Override
    public void addOrUpdateUser(User user) {


        if (user.getId() == null) {
            getEntityManager().persist(user);
        } else {
            getEntityManager().merge(user);
        }

    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return getEntityManager().createQuery("from User  ", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        return getEntityManager().find(User.class, id);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {

        User user = getEntityManager().merge(getUserById(id));
        getEntityManager().remove(user);
    }
}
