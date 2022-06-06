package spring_crud.dao;

import org.springframework.stereotype.Component;
import spring_crud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getUserByNameAndLastname(String name, String lastname) {
        return em.createQuery("from User u where u.name=:name and u.lastname=:lastname", User.class)
                .setParameter("name", name)
                .setParameter("lastname", lastname)
                .getResultList();
    }

    @Override
    public void updateUserById(Long id, User user) {
        User uUser = em.find(User.class, id);
        uUser.setName(user.getName());
        uUser.setLastname(user.getLastname());
        uUser.setAge(user.getAge());
        uUser.setHobby(user.getHobby());
        uUser.setSex(user.getSex());
        em.merge(uUser);
    }

    @Override
    public void removeUserById(Long id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }

    @Override
    public void cleanTableUsers() {
        em.createQuery("delete User").executeUpdate();
    }

    @Override
    public void deleteTableUsers() {
        em.createNativeQuery("drop table users").executeUpdate();
    }
}
