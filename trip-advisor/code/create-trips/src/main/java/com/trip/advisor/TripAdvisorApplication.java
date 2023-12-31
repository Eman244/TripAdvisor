package com.trip.advisor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.trip.advisor")
@EntityScan(basePackages = "com.trip.advisor")
public class TripAdvisorApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TripAdvisorApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TripAdvisorApplication.class);
	}
}
