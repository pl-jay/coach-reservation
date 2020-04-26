package lk.pathum.reservation.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer user;
    String date;
    Integer seatNo;
    Integer utility_id;
    boolean isReserved;
}
