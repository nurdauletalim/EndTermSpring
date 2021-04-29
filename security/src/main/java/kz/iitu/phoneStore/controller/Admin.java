package kz.iitu.phoneStore.controller;

import kz.iitu.phoneStore.entity.phones.Phone;
import kz.iitu.phoneStore.entity.users.User;
import kz.iitu.phoneStore.service.PaymentService;
import kz.iitu.phoneStore.service.PhoneService;
import kz.iitu.phoneStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class Admin {
    @Autowired
    private UserService userService;
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public void createUser(@RequestBody User user) {
        System.out.println("UserController.createUser");
        System.out.println("user = " + user);

        userService.createUser(user);
    }


    @GetMapping("/create")
    public void createUserByUsernameAndPassword(String username,
                                                String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.createUser(user);
    }

    @GetMapping("/userslist")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/updatePhone")
    public void updatePhone(@RequestBody Phone phone) {
        phoneService.updatePhone(phone);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody User user) {

        System.out.println("UserController.updateUser");
        System.out.println("id = " + id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        userService.updateUser(id, user);
    }

    @GetMapping("/deletePhone/{id}")
    public void deletePhone(@PathVariable Long id){
        phoneService.deletePhone(id);
    }

    @PostMapping("/addPhone")
    public void addPhone(@RequestBody Phone phone) {
        phoneService.addPhone(phone);
    }




}
