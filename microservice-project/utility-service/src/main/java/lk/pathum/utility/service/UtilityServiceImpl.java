package lk.pathum.utility.service;

import lk.pathum.utility.ReservationCommand.GetReservationsByDateCommand;
import lk.pathum.utility.ReservationCommand.GetReservationsCommand;
import lk.pathum.utility.ReservationCommand.ReservationCommand;
import lk.pathum.utility.model.CoachRoutes;
import lk.pathum.utility.model.FilteredUtilities;
import lk.pathum.utility.model.Reservation;
import lk.pathum.utility.repository.ItemRepository;
import lk.pathum.utility.repository.RoutesRepository;
import lk.pathum.utility.repository.UtilityRepository;
import lk.pathum.utility.model.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
    RoutesRepository routesRepository;

    @Override
    public List<Utility> getAll() {
        return utilityRepository.findAll();
    }

    @Override
    public Utility save(Utility utility) {
        return utilityRepository.save(utility);
    }

    private Reservation[] fetchReservation(Integer utilityId) {
        return new GetReservationsCommand(utilityId, restTemplate, new HttpHeaders()).execute();
    }

    private Reservation[] fetchReservationsByDate(String date) {
        return new GetReservationsByDateCommand(date, restTemplate, new HttpHeaders()).execute();
    }

    private Integer[] fetchSeatsCount(Integer utilityId){
        return new ReservationCommand(utilityId, restTemplate, new HttpHeaders()).execute();
    }

    @Override
    public Utility fetchUtility(Integer id) {

        Utility ut = new Utility();
        ut.setId(id);

        List<Utility> utilityFirst = new ArrayList<>();
        utilityFirst.add(ut);

        CoachRoutes routes = new CoachRoutes();
        routes.setUtilityList(utilityFirst);

        System.out.println("ROUTES"+routes);
        Optional<CoachRoutes> coachRoutes = routesRepository.findOne(Example.of(routes));

        System.out.println("COACHROUTE"+coachRoutes);
        Optional<Utility> utilityOpt = utilityRepository.findById(id);
        System.out.println("UTILIT"+utilityOpt);
        if(utilityOpt.isPresent()){
            Utility utility = utilityOpt.get();
            utility.setReservations(fetchReservation(utility.getId()));
            utility.setRoutes(coachRoutes.get());
            System.out.println(utility);
            return utility;
        }

        return new Utility();
    }

    @Override
    public List<Integer> availableSeats(Integer utilityId) {
        List<Integer> seatList = new ArrayList<>();
        // fetch seats list from reservation service
        List<Integer> availableSeatList = Arrays.asList(fetchSeatsCount(utilityId));
        for (int i = 1; i <= seats(utilityId); i++) {
            seatList.add(i);
        }
        // remove similar numbers, which returns available seats
        if(availableSeatList!=null)
            seatList.removeAll(availableSeatList);
        return seatList;
    }

    @Override
    public Integer seats(int id){
        Utility utility = new Utility();
        utility.setId(id);
        Optional<Utility> optionalUtility = utilityRepository.findById(id);
        return optionalUtility.get().getSeats();
    }

    @Override
    public List<Utility> utilityFilter(FilteredUtilities filteredUtilities) {
        Utility utility = new Utility();
        CoachRoutes routes = new CoachRoutes();
        routes.setId(filteredUtilities.getRoute_id());
        utility.setAc(filteredUtilities.getAc_condition());

        Reservation[] reservation = fetchReservationsByDate(filteredUtilities.getDate());

        System.out.println("Reservation : "+reservation);


        utility.setReservations(reservation);
        utility.setRoutes(routes);

        return utilityRepository.findAll(Example.of(utility));
    }

}
