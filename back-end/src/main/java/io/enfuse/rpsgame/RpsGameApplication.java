package io.enfuse.rpsgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan("io.enfuse.rpsgame")
public class RpsGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpsGameApplication.class, args);
	}

}
