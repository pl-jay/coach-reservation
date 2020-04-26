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

public class GetReservationsByDateCommand extends HystrixCommand<Reservation[]> {

    String date;
    RestTemplate restTemplate;
    HttpHeaders httpHeaders;
    private static final Reservation[] NO_RESERVATIONS = {};

    public GetReservationsByDateCommand(String date, RestTemplate restTemplate, HttpHeaders httpHeaders) {
        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.date = date;
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
    }

    @Override
    protected Reservation[] run() throws Exception {
        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<Reservation[]> reservationResponse =
                restTemplate.exchange("http://reservation-service/reservationController/getReservationsByDate/"+ date,
                        HttpMethod.GET,httpEntity,Reservation[].class );
        return reservationResponse.getBody();
    }

    @Override
    protected Reservation[] getFallback(){
        System.out.println("Fall back");
        return NO_RESERVATIONS;
    }
}

