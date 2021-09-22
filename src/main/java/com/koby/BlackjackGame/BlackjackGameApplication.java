package com.koby.BlackjackGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class BlackjackGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackjackGameApplication.class, args);
	}

	@GetMapping("/customRoute")
	public String myResponse(){
		return "output";
	}

}
