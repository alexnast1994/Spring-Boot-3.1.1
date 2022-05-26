package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void add(User user) {
        if (nonNull(user)){
            entityManager.persist(user);
        }
    }

    @Transactional
    @Override
    public void removeUserById(Long id) {
        if (nonNull(id)){
            entityManager.remove(getUserById(id));
        }
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        if (nonNull(id)){
            return entityManager.find(User.class, id);
        }
        return new User();
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        if (nonNull(user)){
            entityManager.merge(user);
        }
    }
}
