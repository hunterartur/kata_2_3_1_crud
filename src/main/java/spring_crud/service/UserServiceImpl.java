package spring_crud.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring_crud.dao.UserDAO;
import spring_crud.model.User;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Transactional
    @Override
    public List<User> getUserByNameAndLastname(String name, String lastname) {
        return userDAO.getUserByNameAndLastname(name, lastname);
    }

    @Transactional
    @Override
    public void updateUserById(Long id, User user) {
        userDAO.updateUserById(id, user);
    }

    @Transactional
    @Override
    public void removeUserById(Long id) {
        userDAO.removeUserById(id);
    }

    @Transactional
    @Override
    public void cleanTableUsers() {
        userDAO.cleanTableUsers();
    }

    @Transactional
    @Override
    public void deleteTableUsers() {
        userDAO.deleteTableUsers();
    }
}
