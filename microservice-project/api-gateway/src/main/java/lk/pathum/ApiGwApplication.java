package lk.pathum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableResourceServer
public class ApiGwApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiGwApplication.class, args);
	}
}
