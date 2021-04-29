package kz.iitu.phoneStore.service.impl;

import kz.iitu.phoneStore.entity.phones.Phone;
import kz.iitu.phoneStore.repositories.PhoneRepository;
import kz.iitu.phoneStore.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public void deletePhone(Long id) {
        Phone phone = phoneRepository.findById(id).get();
        phoneRepository.delete(phone);
    }

    @Override
    public void addPhone(Phone phone) {
        phoneRepository.saveAndFlush(phone);
    }

    @Override
    public Phone findById(Long id) {
        Phone phone = phoneRepository.findById(id).get();
        return phone;
    }

    @Override
    public void updatePhone(Phone phone) {
        phoneRepository.saveAndFlush(phone);
    }

    @Override
    public String makeNotAvailable(Long id) {
        Phone phone = phoneRepository.findById(id).get();
        if (phone.isAvailable()) {
            phone.setAvailable(false);
        } else {
            phone.setAvailable(true);
        }
        return null;
    }

    @Override
    public List<Phone> showAvailablePhones() {
        return phoneRepository.findAll();
    }
}
