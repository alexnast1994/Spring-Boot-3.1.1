package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static java.util.Objects.nonNull;

@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void add(User user) {
        if (nonNull(user)) {
            entityManager.persist(user);
        }
    }

    @Override
    public void removeUserById(User user) {
        if (nonNull(user)){
            entityManager.remove(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }


    @Override
    public User getUserById(Long id) {
        if (nonNull(id)) {
            return entityManager.find(User.class, id);
        }
        return new User();
    }


    @Override
    public void updateUser(User user) {
        if (nonNull(user)) {
            entityManager.merge(user);
        }
    }
}
