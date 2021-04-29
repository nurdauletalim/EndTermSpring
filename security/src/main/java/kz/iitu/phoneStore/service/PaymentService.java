package kz.iitu.phoneStore.service;

import kz.iitu.phoneStore.entity.phones.Phone;
import kz.iitu.phoneStore.entity.users.User;

public interface PaymentService {
    String makePayment(Phone phone, User user);
}
