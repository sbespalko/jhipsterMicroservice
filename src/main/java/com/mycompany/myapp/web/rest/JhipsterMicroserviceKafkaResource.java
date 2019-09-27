package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.JhipsterMicroserviceKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/jhipster-microservice-kafka")
public class JhipsterMicroserviceKafkaResource {

    private final Logger log = LoggerFactory.getLogger(JhipsterMicroserviceKafkaResource.class);

    private JhipsterMicroserviceKafkaProducer kafkaProducer;

    public JhipsterMicroserviceKafkaResource(JhipsterMicroserviceKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
