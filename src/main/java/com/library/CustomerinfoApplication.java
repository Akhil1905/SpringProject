package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.library")
public class CustomerinfoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerinfoApplication.class, args);
	}

}
