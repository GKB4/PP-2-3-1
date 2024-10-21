package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public void create(String name, String secondName, int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setSecondName(secondName);
        create(user);
    }

    @Override
    public User read(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(int id, String name, String secondName, int age) {
        User user = entityManager.find(User.class, id);
        user.setName(name);
        user.setAge(age);
        user.setSecondName(secondName);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public List<User> readUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT t FROM User t", User.class);
        return query.getResultList();
    }
}
