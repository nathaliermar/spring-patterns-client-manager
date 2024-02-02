package project.spring.patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Project Spring Boot gerenated via Spring Initializr.
 * Selected modules:
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 * - OpenFeign
 */

@EnableFeignClients
@SpringBootApplication

public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}




