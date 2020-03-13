package lk.pathum.utility.service;

import lk.pathum.utility.model.Utility;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtilityService {
    List<Utility> getAll();
    Utility save(Utility utility);
    Utility fetchUtility(Integer id);
}
