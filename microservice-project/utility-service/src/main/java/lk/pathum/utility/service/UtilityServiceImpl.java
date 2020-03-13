package lk.pathum.utility.service;

import lk.pathum.utility.model.Utility;
import lk.pathum.utility.repository.UtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UtilityServiceImpl implements UtilityService {

    @Autowired
    UtilityRepository utilityRepository;


    @Override
    public List<Utility> getAll() {
        return utilityRepository.findAll();
    }

    @Override
    public Utility save(Utility utility) {
        return utilityRepository.save(utility);
    }

    @Override
    public Utility fetchUtility(Integer id) {
        return null;
    }
}
