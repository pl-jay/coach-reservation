package lk.pathum.user.OauthCommand;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lk.pathum.user.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class OAuthCommand extends HystrixCommand<User> {

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
    protected User run() throws Exception {
        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<User> userResponseEntity =
                restTemplate.exchange("http://oauth-server/oauthController/register/"+user, HttpMethod.POST,httpEntity,User.class);
                System.out.println(userResponseEntity.getBody());        
        return userResponseEntity.getBody();
    }

    @Override
    public User getFallback(){
        System.out.println("Fall back !");
        return new User();
    }
}
