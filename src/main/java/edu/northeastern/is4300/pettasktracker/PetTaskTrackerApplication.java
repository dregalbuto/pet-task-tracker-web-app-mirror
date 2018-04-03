package edu.northeastern.is4300.pettasktracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PetTaskTrackerApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PetTaskTrackerApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PetTaskTrackerApplication.class, args);
	}
}
