package lk.pathum.utility.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Reservation {
    Integer id;
    Integer user;
    String date;
    Integer seatNo;
    Integer utility_id;
    boolean isReserved;
}