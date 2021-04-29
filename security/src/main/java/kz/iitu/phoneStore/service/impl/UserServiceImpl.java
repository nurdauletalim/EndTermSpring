package kz.iitu.phoneStore.service.impl;

import kz.iitu.phoneStore.repositories.UserRepository;
import kz.iitu.phoneStore.service.UserService;
import kz.iitu.phoneStore.entity.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.saveAndFlush(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        User user1 = userRepository.findById(id).orElse(null);

        if (user1 != null) {
            user1.setPassword(user.getPassword());
            user1.setUsername(user.getUsername());
            userRepository.saveAndFlush(user1);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + "not found");
        }
        return user;
    }

    @Override
    public User getUserbyUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public void newUser(User newUser) {
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        userRepository.saveAndFlush(newUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    @Override
    public String changePass(Long id, String pass, String newPass) {
        User user = userRepository.findById(id).get();
        if (user != null) {
            if (bCryptPasswordEncoder.encode(pass) == user.getPassword()) {
                user.setPassword(bCryptPasswordEncoder.encode(newPass));
                userRepository.saveAndFlush(user);
                return "OK";
            } else return "Password is incorrect";
        } else
            return "user not found!";
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
}
