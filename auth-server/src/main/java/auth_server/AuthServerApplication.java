package auth_server;

import auth_server.Model.ROLE;
import auth_server.Model.User;
import auth_server.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RibbonClient(name = "rolex-auth-server")
public class AuthServerApplication {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			userRepository.save(new User("admin","$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", ROLE.ADMIN));
			userRepository.save(new User("milan",new BCryptPasswordEncoder().encode("password"), ROLE.ADMIN));
			userRepository.save(new User("milance",new BCryptPasswordEncoder().encode("password"),ROLE.USER));
		};
	}
}
