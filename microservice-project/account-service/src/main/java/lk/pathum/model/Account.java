package lk.pathum.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer user;
    Float balance;

    Payment[] payments;
}
