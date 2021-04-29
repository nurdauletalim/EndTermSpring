package kz.iitu.phoneStore.entity.reservation;

import kz.iitu.phoneStore.entity.phones.Phone;
import kz.iitu.phoneStore.entity.users.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@Component
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateIssue;


    @OneToOne
    @JoinColumn(name = "phoneId", insertable = false, updatable = false)
    private Phone phone;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;


}
