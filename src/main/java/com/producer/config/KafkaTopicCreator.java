package com.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicCreator {
    @Bean
    public NewTopic newTopic()
    {
        return new NewTopic("kafka-topic-5",5,(short)1);
    }

}
