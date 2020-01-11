package com.app.kafka.consumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class EmployeeListener {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeListener.class);

	@KafkaListener(topics = "${app.topic.example}")
	public void receive(ConsumerRecord<String, Object> cr, @Payload Object data, @Headers MessageHeaders headers) {
		/*
		 * LOG.info("received employee data='{}'", data.getEmpId() + "======= " +
		 * data.getEmpName() + "======= " + data.getEmpSalary() + "======= " +
		 * data.getCompany().getAddress());
		 */
		// Employee emp = cr.value();
		Object obj = cr.value();
		/*
		 * final ObjectMapper mapper = new ObjectMapper(); Employee emp =
		 * mapper.convertValue(obj, Employee.class);
		 */
		// Employee emp=(Employee)obj;
		LOG.info("consumerrecord :{}", obj);
	}

}
