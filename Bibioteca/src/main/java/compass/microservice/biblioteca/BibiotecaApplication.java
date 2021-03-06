package compass.microservice.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
@EnableSpringDataWebSupport
public class BibiotecaApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
	
		return new RestTemplate();
		
		
	}

	public static void main(String[] args) {
		SpringApplication.run(BibiotecaApplication.class, args);
		
	}

}
