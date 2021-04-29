package kz.iitu.phoneStore.service;

import kz.iitu.phoneStore.entity.users.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(Long id, User user);
    User getUserbyUsername(String username);
    void newUser(User newUser);
    void deleteUser(Long id);
    String changePass(Long id, String pass, String newPass);
    User findById(Long id);
 }
