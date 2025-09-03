package com.example.userwallet_service.dto;

import com.example.userwallet_service.enumeration.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {

    private NotificationType notificationType;


}
