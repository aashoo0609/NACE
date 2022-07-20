package com.nace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class ClmApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(ClmApplication.class, args);
	}

}
