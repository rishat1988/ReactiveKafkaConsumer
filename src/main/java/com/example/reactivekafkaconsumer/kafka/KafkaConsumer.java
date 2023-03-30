package com.example.reactivekafkaconsumer.kafka;

import com.example.reactivekafkaconsumer.CaseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private static final String USER_TOPIC = "${topic.name}";

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = USER_TOPIC)
    public Mono<Void> consumeMessage(String message) throws JsonProcessingException {

        var caseDto = objectMapper.readValue(message, CaseDto.class);
        System.out.println("succesfully got from kafka " + caseDto);

        return Mono.empty();
    }

}