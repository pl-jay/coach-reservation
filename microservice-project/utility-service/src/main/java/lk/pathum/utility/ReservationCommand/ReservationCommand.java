package lk.pathum.utility.ReservationCommand;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;

public class ReservationCommand extends HystrixCommand<Integer[]> {

    Integer utility;
    RestTemplate restTemplate;
    HttpHeaders httpHeaders;
    private static final Integer[] NO_SEATS = {};

    public ReservationCommand(Integer utility,RestTemplate restTemplate, HttpHeaders httpHeaders) {
        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.utility = utility;
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
    }

    @Override
    protected Integer[] run() throws Exception {
        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<Integer[]> reservResponse =
                restTemplate.exchange("http://reservation-service/reservationController/seats/"+ utility,
                        HttpMethod.GET,httpEntity,Integer[].class );
        return reservResponse.getBody();
    }

    @Override
    protected Integer[] getFallback(){
        System.out.println("Fall back");
        return NO_SEATS;
    }
}
