package lk.pathum.user.OauthCommand;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lk.pathum.user.model.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class OAuthCommand extends HystrixCommand<String> {

    User user;
    RestTemplate restTemplate;
    HttpHeaders httpHeaders;

    public OAuthCommand(User user, RestTemplate restTemplate, HttpHeaders httpHeaders) {
        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.user = user;
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
    }

    @Override
    protected String run() throws Exception {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>("FUCK THIS", httpHeaders);

        ResponseEntity<String> userResponseEntity =
                restTemplate.exchange("http://localhost:9191/oauthController/registerNewUser", HttpMethod.GET, httpEntity,String.class);

                System.out.println(userResponseEntity.getBody());        
        return userResponseEntity.getBody();
    }

    @Override
    public String getFallback(){
        System.out.println("Fall back !");
        return new String("");
    }
}
