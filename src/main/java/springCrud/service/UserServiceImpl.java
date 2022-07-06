package springCrud.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springCrud.dao.UserDAO;
import springCrud.model.User;

import java.util.List;

@Service
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
    public void updateUserById(Long id, User user) {
        userDAO.updateUserById(id, user);
    }

    @Transactional
    @Override
    public void removeUserById(Long id) {
        userDAO.removeUserById(id);
    }

    @Override
    public void cleanTableUsers() {
        userDAO.cleanTableUsers();
    }

    @Override
    public void deleteTableUsers() {
        userDAO.deleteTableUsers();
    }
}
