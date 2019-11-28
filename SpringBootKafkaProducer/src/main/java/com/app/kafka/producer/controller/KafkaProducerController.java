
package com.app.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.kafka.producer.model.Employee;
import com.app.kafka.producer.service.KafkaProducerService;

@RestController

@RequestMapping(value = "/kafkasender")
public class KafkaProducerController {

	@Autowired
	@Qualifier(value = "kafkaService")
	private KafkaProducerService kafkaProducerService;

	@PostMapping(value = "/send")
	public void sendMessageToKafkaTopic(@RequestBody Employee employee) {
		this.kafkaProducerService.sendMessage(employee);
	}
}
