package fi.tuni.e02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class E02Application {

	public static void main(String[] args) {
		SpringApplication.run(E02Application.class, args);
	}

	@Bean
	public CommandLineRunner getAnotherBean() {
		MyBean bean = new MyBean("From Application!");
		return bean;
	}
}
//https://www.dropbox.com/s/y84gw2yr5r8vrh7/e02-0.0.1-SNAPSHOT.jar?dl=0