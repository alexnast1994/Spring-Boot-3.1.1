package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void removeUserById(Long id);

    List<User> getAllUsers();

    User getUserById(Long id);

    void updateUser(User user);
}
