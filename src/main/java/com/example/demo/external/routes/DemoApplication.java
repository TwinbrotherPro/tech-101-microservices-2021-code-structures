package com.example.demo.external.routes;

import com.example.demo.Config;
import com.example.demo.core.applicationServices.RfidCardService;
import com.example.demo.core.domainEntities.RfidCard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@PostMapping("cards/{id}/activate")
	public String activateCard(@PathVariable String id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		RfidCardService cardService = context.getBean(RfidCardService.class);
		RfidCard card = cardService.activateRfidCard(id);
		context.close();
		return "Activated card:" + card.getId();
	}

}
