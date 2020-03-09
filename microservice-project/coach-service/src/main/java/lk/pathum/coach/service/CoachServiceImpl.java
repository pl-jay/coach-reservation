package lk.pathum.coach.service;

import lk.pathum.coach.model.Coach;
import lk.pathum.coach.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoachServiceImpl implements CoachService {

    @Autowired
    CoachRepository coachRepository;


    @Override
    public List<Coach> getAll() {
        return coachRepository.findAll();
    }

    @Override
    public Coach save(Coach coach) {
        return coachRepository.save(coach);
    }

    @Override
    public Coach fetchCoach(Integer id) {
        return null;
    }
}
