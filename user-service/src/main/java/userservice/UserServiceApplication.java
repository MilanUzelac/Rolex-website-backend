package userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import userservice.Model.UserAdmin;
import userservice.Repository.UserAdminRepository;

@EnableDiscoveryClient
@EnableFeignClients
@RibbonClient(name = "rolex-user-microservice")
@SpringBootApplication
public class UserServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Autowired
	UserAdminRepository userAdminRepository;

	@Bean
	CommandLineRunner runner() {
		return args -> {
			userAdminRepository.save(new UserAdmin("admin"));
			userAdminRepository.save(new UserAdmin("milan"));
			userAdminRepository.save(new UserAdmin("milance"));
		};
	}
}
