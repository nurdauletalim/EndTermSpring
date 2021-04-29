package kz.iitu.phoneStore.service;

import kz.iitu.phoneStore.entity.phones.Phone;

import java.util.List;

public interface PhoneService {

    String makeNotAvailable(Long id);

    List<Phone> showAvailablePhones();

    void deletePhone(Long id);

    void addPhone(Phone phone);

    Phone findById(Long id);

    void updatePhone(Phone phone);


}
