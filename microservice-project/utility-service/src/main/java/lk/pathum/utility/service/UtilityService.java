package lk.pathum.utility.service;

import lk.pathum.utility.model.FilteredUtilities;
import lk.pathum.utility.model.Utility;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtilityService {
    List<Utility> getAll();
    Utility save(Utility utility);
    Utility fetchUtility(Integer id);
    List<Integer> availableSeats(Integer id);

    Integer seats(int id);

    List<Utility> utilityFilter(FilteredUtilities filteredUtilities);
}
