package lk.pathum.utility.ReservationCommand;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lk.pathum.utility.model.Reservation;
import lk.pathum.utility.model.Utility;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class GetReservationsCommand extends HystrixCommand<Reservation[]> {

    Integer utilityId;
    RestTemplate restTemplate;
    HttpHeaders httpHeaders;
    private static final Reservation[] NO_RESERVATIONS = {};

    public GetReservationsCommand(Integer utilityId, RestTemplate restTemplate, HttpHeaders httpHeaders) {
        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.utilityId = utilityId;
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
    }

    @Override
    protected Reservation[] run() throws Exception {
        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<Reservation[]> reservationResponse =
                restTemplate.exchange("http://reservation-service/reservationController/getReservationbyUtility/"+ utilityId,
                        HttpMethod.GET,httpEntity,Reservation[].class );
        return reservationResponse.getBody();
    }

    @Override
    protected Reservation[] getFallback(){
        System.out.println("Fall back");
        return NO_RESERVATIONS;
    }
}

