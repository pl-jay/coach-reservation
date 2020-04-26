package lk.pathum.utility.service;

import lk.pathum.utility.model.CoachRoutes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtilityRoutesService {
    List<CoachRoutes> getAllRoutes();
}
