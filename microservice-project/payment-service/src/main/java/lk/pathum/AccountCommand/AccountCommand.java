package lk.pathum.AccountCommand;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lk.pathum.model.Account;
import lk.pathum.model.Transaction;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AccountCommand  extends HystrixCommand<Boolean> {

    Transaction transaction;
    RestTemplate restTemplate;
    HttpHeaders httpHeaders;

    public AccountCommand(Transaction transaction, RestTemplate restTemplate, HttpHeaders httpHeaders) {
        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.transaction = transaction;
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
    }

    @Override
    protected Boolean run() throws Exception {
        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<Boolean> allocResponse =
               // restTemplate.exchange("http://allocation-service/allocation/allocation/"+ employee.getId(), HttpMethod.GET,httpEntity, Allocation[].class);
                restTemplate.exchange("http://account-service/accountController/pay/"+ transaction.getProvider()+"/"+transaction.getConsumer()+"/"+transaction.getAmount(),
                        HttpMethod.GET,httpEntity,Boolean.class);
        return allocResponse.getBody();
    }

    @Override
    protected Boolean getFallback(){
        System.out.println("Fall Back");
        return false;
    }
}

