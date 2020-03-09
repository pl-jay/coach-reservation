package lk.pathum.coach.service;

import lk.pathum.coach.model.Coach;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CoachService {
    List<Coach> getAll();
    Coach save(Coach passenger);
    Coach fetchCoach(Integer id);
}
