package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterMicroserviceApp;
import com.mycompany.myapp.service.JhipsterMicroserviceKafkaProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EmbeddedKafka
@SpringBootTest(classes = JhipsterMicroserviceApp.class)
public class JhipsterMicroserviceKafkaResourceIT {

    @Autowired
    private JhipsterMicroserviceKafkaProducer kafkaProducer;

    private MockMvc restMockMvc;

    @BeforeEach
    public void setup() {
        JhipsterMicroserviceKafkaResource kafkaResource = new JhipsterMicroserviceKafkaResource(kafkaProducer);

        this.restMockMvc = MockMvcBuilders.standaloneSetup(kafkaResource)
            .build();
    }

    @Test
    public void sendMessageToKafkaTopic() throws Exception {
        restMockMvc.perform(post("/api/jhipster-microservice-kafka/publish?message=yolo"))
            .andExpect(status().isOk());
    }
}
