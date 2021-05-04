package kz.iitu.phoneStore.entity.phones;

import kz.iitu.phoneStore.entity.reservation.Payment;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isAvailable;
    private String model;
    private String color;
    private Double storage;
    private Integer numSim;
    private Integer ram;
    private PhoneType type;
    private int price;

    @Getter(AccessLevel.NONE)
    @OneToOne(mappedBy = "phone", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Payment payment;
}
