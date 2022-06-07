package spring_crud.service;

import spring_crud.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> getAllUsers();
    User getUserById(Long id);
    void updateUserById(Long id, User user);

    void removeUserById(Long id);
    void cleanTableUsers();
    void deleteTableUsers();

}
