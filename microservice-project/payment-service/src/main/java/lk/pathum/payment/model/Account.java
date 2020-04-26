package lk.pathum.payment.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Account {

    Integer id;
    Integer user;
    Float balance;
}
