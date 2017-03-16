package com.agung.penjualan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@EntityScan(
        basePackageClasses = {BelajarSpringBootApplication.class, Jsr310JpaConverters.class}
        )
@SpringBootApplication
public class BelajarSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringBootApplication.class, args);
	}

         @Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }
}
