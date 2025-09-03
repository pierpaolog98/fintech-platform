package com.example.notification_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {

    private String eventType;
    private String recipient;
    private Map<String, Object> data;

}
