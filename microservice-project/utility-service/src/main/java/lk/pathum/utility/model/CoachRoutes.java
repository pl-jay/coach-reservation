package lk.pathum.utility.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CoachRoutes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String route;

    @OneToMany(mappedBy = "routes", cascade = CascadeType.ALL)
    List<Utility> utilityList;
}
