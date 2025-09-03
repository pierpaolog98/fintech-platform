package com.example.notification_service.service;

import com.example.notification_service.model.NotificationRequest;
import com.example.notification_service.model.NotificationResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NotificationService {


    public NotificationResponse processAndSend(NotificationRequest request){
        String messageId = UUID.randomUUID().toString();
        return new NotificationResponse();
    }

}
