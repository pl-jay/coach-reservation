package lk.pathum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    int user;
    float balance;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    Account consumer;


//    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
//    List<Payment> providerPayment;
}
