package com.example.notification_service.service;


import com.example.notification_service.dto.NotificationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final ObjectMapper objectMapper;


    @KafkaListener(topics = "notification-event", groupId = "notification-group")
    @Transactional
    public void listen(String event) {
        try {
            NotificationDTO notificationEvent = objectMapper.readValue(event, NotificationDTO.class);
            System.out.println("NotificationEvent: " + notificationEvent);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
