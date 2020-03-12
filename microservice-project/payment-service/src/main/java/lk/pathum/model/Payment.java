package lk.pathum.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    float amount;
    String remarks;

    @OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL)
    Account consumer;


//    @JoinColumn
//    @ManyToOne
//    @JsonIgnore
//    Account provider;


}
