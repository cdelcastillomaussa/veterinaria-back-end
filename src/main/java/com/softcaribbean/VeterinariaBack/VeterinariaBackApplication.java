package com.softcaribbean.VeterinariaBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

@SpringBootApplication
public class VeterinariaBackApplication {

	public static void main(String[] args) {

		SpringApplication.run(VeterinariaBackApplication.class, args);
	}


}
