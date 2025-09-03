package com.example.notification_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationResponse {
    private String status;      // Es: "SENT", "FAILED"
    private String messageId;   // ID restituito da SES o altro provider
}
