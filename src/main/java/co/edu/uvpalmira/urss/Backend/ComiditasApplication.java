package co.edu.uvpalmira.urss.Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EntityScan(basePackages = { "co.edu.uvpalmira.urss.Backend.Model" })
public class ComiditasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComiditasApplication.class, args);
	}

}
