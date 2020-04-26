package lk.pathum.user.OauthCommand;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lk.pathum.user.model.UserModel;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class OAuthCommand extends HystrixCommand<String> {

    UserModel user;
    RestTemplate restTemplate;
    HttpHeaders httpHeaders;

    public OAuthCommand(UserModel user, RestTemplate restTemplate, HttpHeaders httpHeaders) {
        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.user = user;
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
    }

    @Override
    protected String run() throws Exception {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);

        ResponseEntity<String> userResponseEntity =
                restTemplate.exchange("http://oauth-server/registerNewUserG/"+user.getEmail()+"/"+user.getName()+"/"+user.getPassword()+"/"+user.getRole(),HttpMethod.GET,httpEntity, String.class );
                System.out.println(userResponseEntity.getBody());        
        return userResponseEntity.getBody();
    }

    @Override
    public String getFallback(){
        System.out.println(getFailedExecutionException().getMessage());
        System.out.println("Fall back !");
        return new String("");
    }
}
