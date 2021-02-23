package com.example.demo.external.routes;

import com.example.demo.core.applicationServices.RfidCardService;
import com.example.demo.core.domainEntities.RfidCard;
import com.example.demo.core.domainServices.IRfidCardRepository;
import com.example.demo.external.database.RfidCardRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
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
		IRfidCardRepository cardRepo = new RfidCardRepository();
		RfidCardService cardService = new RfidCardService(cardRepo);
		RfidCard card = cardService.activateRfidCard(id);
		return "Activated card:" + card.getId();
	}

}
