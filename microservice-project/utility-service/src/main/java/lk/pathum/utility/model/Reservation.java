package lk.pathum.utility.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    int user;
    LocalDate date;
    int seatNo;

    Utility coach;
}
