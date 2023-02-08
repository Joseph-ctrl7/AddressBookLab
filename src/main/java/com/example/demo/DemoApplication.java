package com.example.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(BuddyInfoRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new BuddyInfo(1L,"Jack", "613"));
			repository.save(new BuddyInfo(2L,"Chloe", "424"));
			repository.save(new BuddyInfo(3L,"Kim", "415"));

			//BuddyInfoController b = new BuddyInfoController(repository);

			//b.addBuddies("Josh");




			/**
			// fetch all customers
			log.info("Buddies found with findAll():");
			log.info("-------------------------------");
			for (BuddyInfo b : repository.findAll()) {
				log.info(b.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			BuddyInfo b = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(b.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('J'):");
			log.info("--------------------------------------------");
			repository.findByName("Jack").forEach(jack -> {
				log.info(jack.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");**/
		};
	}

}
