package com.mrp.motorhomes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MotorhomesApplication {

	public static void main(String[] args) {
        System.out.println("razvan");

		SpringApplication.run(MotorhomesApplication.class, args);
	}
	
	public static void testMarius(){
		System.out.println("just a test");
	}
}
