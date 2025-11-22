package co.edu.uvpalmira.urss.Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ComiditasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComiditasApplication.class, args);
	}

}
