package spring_crud.dao;

import spring_crud.model.User;

import java.util.List;

public interface UserDAO {

    void save(User user);

    List<User> getAllUsers();
    User getUserById(Long id);

    void updateUserById(Long id, User user);

    void removeUserById(Long id);
    void cleanTableUsers();
    void deleteTableUsers();


}
