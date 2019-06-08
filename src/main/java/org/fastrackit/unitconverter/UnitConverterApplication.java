package org.fastrackit.unitconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.fastrackit.unitconverter.repo")
public class UnitConverterApplication {
	public static void main(String[] args) {
		SpringApplication.run(UnitConverterApplication.class, args);
	}
}
