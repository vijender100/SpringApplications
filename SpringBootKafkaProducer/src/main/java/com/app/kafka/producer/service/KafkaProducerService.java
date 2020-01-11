package com.app.kafka.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.app.kafka.producer.model.Employee;

@Service("kafkaService")
public class KafkaProducerService {

	private static final String TOPIC = "testtopic";
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	public void sendMessage(Employee employee) {
		Message<Employee> message = MessageBuilder.withPayload(employee).setHeader(KafkaHeaders.TOPIC, TOPIC).build();
		this.kafkaTemplate.send(message);
	}

}