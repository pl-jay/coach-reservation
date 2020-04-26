package lk.pathum.utility.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    CoachRoutes routes;

    Reservation[] reservations;
}
