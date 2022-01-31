package com.ga.formationonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FormationOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormationOnlineApplication.class, args);
	}

	@GetMapping("say-hello")
	// @RequestMapping(path = "say-hello",method = RequestMethod.GET)
	public String sayHello() {
		return "Hello, Bienvenu";
	}

}
