package com.millervein.vcss;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(basePackageClasses = { VCSSApplication.class, Jsr310JpaConverters.class })
@SpringBootApplication
public class VCSSApplication implements CommandLineRunner 	{

	public static void main(String[] args) {
		SpringApplication.run(VCSSApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
	
}
