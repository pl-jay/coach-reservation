package lk.pathum.utility.service;

import lk.pathum.utility.model.CoachRoutes;
import lk.pathum.utility.repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UtilityRoutesServiceImpl implements UtilityRoutesService {
    @Autowired
    RoutesRepository routesRepository;

    @Override
    public List<CoachRoutes> getAllRoutes(){
        return routesRepository.findAll();
    }
}
