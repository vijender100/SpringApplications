package com.app.kafka.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.app.kafka.consumer.Model.Employee;

@Service
public class EmployeeListener {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeListener.class);

    @KafkaListener(topics = "${app.topic.example}")
    public void receive(@Payload Employee data,
                        @Headers MessageHeaders headers) {
        LOG.info("received employee data='{}'", data.getEmpId()+"======= "+data.getEmpName()+"======= "+data.getEmpSalary());

        headers.keySet().forEach(key -> {
            LOG.info("{}: {}", key, headers.get(key));
        });
    }

}
