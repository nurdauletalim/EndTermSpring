package kz.iitu.phoneStore.repositories;

import kz.iitu.phoneStore.entity.phones.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
