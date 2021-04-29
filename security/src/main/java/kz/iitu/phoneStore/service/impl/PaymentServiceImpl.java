package kz.iitu.phoneStore.service.impl;

import kz.iitu.phoneStore.entity.reservation.Payment;
import kz.iitu.phoneStore.entity.phones.Phone;
import kz.iitu.phoneStore.entity.users.User;
import kz.iitu.phoneStore.repositories.PaymentRepository;
import kz.iitu.phoneStore.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public String makePayment(Phone phone, User user) {
        Payment payment = null;
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate= DateFor.format(date);
        payment.setDateIssue(stringDate);
        payment.setPhone(phone);
        payment.setUser(user);
        paymentRepository.saveAndFlush(payment);
        return payment.toString();
    }
}
