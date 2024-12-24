package com.munirmustakoglu.kunde;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.munirmustakoglu.kunde"})  // Entity'lerinizin bulunduğu paketi doğru belirtin.


public class KundeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KundeApplication.class, args);
	}

}
