package lk.pathum.utility.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Utility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String number;
    Integer seats;
    String category;
    boolean ac;

    Reservation[] reservations;
}
