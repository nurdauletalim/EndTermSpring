package kz.iitu.phoneStore.controller;

import kz.iitu.phoneStore.entity.phones.Phone;
import kz.iitu.phoneStore.entity.users.User;
import kz.iitu.phoneStore.service.PaymentService;
import kz.iitu.phoneStore.service.PhoneService;
import kz.iitu.phoneStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Client {

    @Autowired
    private UserService userService;

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/signup")
    public String newUser(@RequestBody User newUser) {
        User newUser1 = userService.getUserbyUsername(newUser.getUsername());
        if (newUser1 != null){
            throw new RuntimeException("With this " + newUser.getUsername() + " is exist");
        }
        if (newUser.getUsername().isEmpty() || newUser.getPassword().isEmpty()){
            throw new RuntimeException("username and password should not be empty");
        }

        userService.newUser(newUser);
        return "Welcome" + newUser.getUsername();
    }

    @GetMapping("/changePassword")
    public String changePass(Long id, String oldPass, String newPass) {
        return userService.changePass(id, oldPass, newPass);
    }

    @GetMapping("/availablePhones")
    public List<Phone> availablePhones() {
        return phoneService.showAvailablePhones();
    }

    //making reservation
    @GetMapping("/makePayment")
    public String makePayment(Long carId, Long userId) {
        phoneService.makeNotAvailable(carId);

        Phone phone = phoneService.findById(carId);
        User user = userService.findById(userId);

        paymentService.makePayment(phone, user);
        return phone.toString();
    }


}
