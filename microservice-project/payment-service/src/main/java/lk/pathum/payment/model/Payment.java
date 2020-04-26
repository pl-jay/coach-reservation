package lk.pathum.payment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Float amount;
    String remarks;
    Integer provider;
    Integer consumer;

}
