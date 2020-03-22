package lk.pathum.utility.service;

import lk.pathum.utility.ReservationCommand.ReservationCommand;
import lk.pathum.utility.model.Item;
import lk.pathum.utility.model.Utility;
import lk.pathum.utility.repository.ItemRepository;
import lk.pathum.utility.repository.UtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Repository
public class UtilityServiceImpl implements UtilityService {

    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @Autowired
    UtilityRepository utilityRepository;

    @Autowired
    ItemRepository itemRepository;

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
        Optional<Utility> utilityOpt = utilityRepository.findById(id);
        if(utilityOpt.isPresent()){
            Utility utility = utilityOpt.get();
            return utility;
        }
        return null;
    }

    private Integer[] fetchSeatsCount(Integer utitlityId){
        return new ReservationCommand(utitlityId, restTemplate, new HttpHeaders()).execute();
    }

    @Override
    public List<Integer> availableSeats(Integer utilityId) {

        List<Integer> seatList = new ArrayList<>();
        // fetch seats list from reservation service
        List<Integer> availableSeatList = Arrays.asList(fetchSeatsCount(utilityId));

        // fetch # of seats from utility repository
        Utility utility = new Utility();
        utility.setId(utilityId);
        Optional<Utility> optionalUtility = utilityRepository.findOne(Example.of(utility));

        if (optionalUtility.isPresent()){
            for (int i = 1; i <= optionalUtility.get().getSeats(); i++) {
                seatList.add(i);
            }
        }

        // remove similar numbers, which returns available seats
        if(availableSeatList!=null)
            seatList.removeAll(availableSeatList);
        return seatList;
    }

}
