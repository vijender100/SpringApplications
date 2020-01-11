package com.app.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import com.app.kafka.producer.model.Company;
import com.app.kafka.producer.model.Employee;

@SpringBootApplication
public class KafkaProducerMain implements CommandLineRunner {

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 5; i++) {
			this.kafkaTemplate.send("testtopic", new Employee("123", "vijju", "1234", new Company("hello", "hello")));
			System.out.println("employee id " + i + "sent successfully");

		}

	}

}
